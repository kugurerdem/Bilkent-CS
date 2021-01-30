`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 12/21/2019 11:53:42 PM
// Design Name: 
// Module Name: partA
// Project Name: 
// Target Devices: 
// Tool Versions: 
// Description: 
// 
// Dependencies: 
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
//////////////////////////////////////////////////////////////////////////////////

// 2 to 4 decoder with enable
module decoder2_4(
    input logic a1, a0, en,
    output logic y0, y1, y2, y3
    );
    
    assign y0 = ~a1 & ~a0 & en; // a1 = 0, a0 = 0
    assign y1 = ~a1 & a0 & en; // a1 = 0, a0 = 1
    assign y2 = a1 & ~a0 & en; // a1 = 1, a0 = 0
    assign y3 = a1 & a0 & en; // a1 = 1, a0 = 1
    
endmodule


// 4 bit register with load & reset
module register4(
    input logic clk, reset, load, [3:0] data,
    output logic [3:0] Q
    );
    
    always_ff @(posedge clk, posedge reset, posedge load) begin
        if (reset)
            Q <= 0;
        else if(load)
            Q <= data;
    end
endmodule

// 2 x 1, 4 bit multiplexer
module mux4bit_2(
    input logic [3:0] d0, d1,
    input logic s0,
    output logic y
    );
    
    assign y = s0 ? d1 : d0; 
endmodule

// 4 x 2, 16 bit multiplexer
module mux16bit_4(
    input logic [15:0] d0, d1, d2, d3,
    input logic s1, s0,
    output logic [15:0] y);

    assign y = s1 ? ( s0 ? d3 : d2) : ( s0 ? d1 : d0);
endmodule


module fileReg( input logic clk, _assign, 
                      logic [3:0] data,
                      logic [1:0] selectDigit,
                output logic [15:0] outputD);
         
     // this is for deciding which memory should we write into
    logic decoderO0, decoderO1, decoderO2, decoderO3;
    decoder2_4 DEC(selectDigit[1], selectDigit[0], _assign, 
                decoderO0, decoderO1, decoderO2, decoderO3);
    
    // this is where our memory is kept
    register4 MEMORY_0(clk, 0, decoderO0, data,  outputD[3:0]);
    register4 MEMORY_1(clk, 0, decoderO1, data,  outputD[7:4]);
    register4 MEMORY_2(clk, 0, decoderO2, data,  outputD[11:8]);
    register4 MEMORY_3(clk, 0, decoderO3, data,  outputD[15:12]);
                
endmodule

module partA(
    input logic clk, _assign,
          logic [3:0] data,
          logic [1:0] selectDigit,
    output logic [6:0] seg, logic dp, logic [3:0] an // for seven segment
    );
    
    logic [15:0] outputD;
    fileReg REG_FILE(clk, _assign, data, selectDigit, outputD);
    
    // 
    SevSeg_4digit S7(clk, outputD[15:12], outputD[11:8], outputD[7:4], outputD[3:0], seg, dp, an);
    
    // NOTE D[0] is the least significant bit of D
endmodule

module partB(
    input logic clk, _assign, 
          logic [3:0] data,
          logic [1:0] selectDigit,
          logic [1:0] selectFileReg,
    output logic [63:0] Q, logic [15:0] selectedD
    );
    
    logic assign_0, assign_1, assign_2, assign_3;
    decoder2_4 DECODER_SELECT_FILEREG(selectFileReg[1], selectFileReg[0], _assign,
                assign_0, assign_1, assign_2, assign_3);
    
    logic [15:0] D0, D1, D2, D3;
    fileReg REG_FILE_0( clk, assign_0, data, selectDigit, D0);
    fileReg REG_FILE_1( clk, assign_1, data, selectDigit, D1);
    fileReg REG_FILE_2( clk, assign_2, data, selectDigit, D2);
    fileReg REG_FILE_3( clk, assign_3, data, selectDigit, D3);
    
    assign Q[15:0] = D3;
    assign Q[31:16] = D2;
    assign Q[47:32] = D1;
    assign Q[63:48] = D0;
    
    // assign LED = D0;
    mux16bit_4 MULTIPLEXER( D0, D1, D2, D3, selectFileReg[1], selectFileReg[0], selectedD);
endmodule

// CLOCK_DIVIDER
module clockDivider(
    input logic clk, [31:0] DIVISOR,
    output logic clkP
    );
    
    logic [31:0] count;
    always_ff@(posedge clk) begin
        count <= count + 1;
        if( count >= DIVISOR - 1)
            count <= 32'd0;
        
        clkP <= (count < DIVISOR/2) ? 0 : 1;
    end
endmodule

// CONTROLLER FOR OUR HLSM
module controller(
    input logic clk, restartButton, [3:0] assignButton,
          logic gameOver, reset,
          logic [1:0] selectFileReg,  // controller input
          logic [15:0] chosenNum, 
          logic [15:0] count, 
          logic [63:0] cells, // input from datapath
    output logic num_ld, num_clr, 
                 count_ld, count_clr,
                 cells_ld, cells_clr, 
           logic [3:0] assignGroup, // output to datapath
        [15:0] LED, logic [6:0] seg, logic dp, logic [3:0] an // external outputs
    );
    
    logic [2:0] state;
    logic [2:0] nextState;
    
    // STATES WE HAVE
    logic [2:0] state_0 = 3'b000; // Initialization state
    logic [2:0] state_1 = 3'b001; // GameSelect state
    logic [2:0] state_2 = 3'b010; // GameInit state
    logic [2:0] state_3 = 3'b011; // Game state
    logic [2:0] state_4 = 3'b100; // GameOver state
    
    logic [15:0] SevSegNum;
    logic enable;
    
    
    logic clockEnable;
    clockDivider(clk, 32'd200000000, clockEnable);
    // CombLogic
    always_comb begin
         case( state) 
            state_0: begin   
                SevSegNum <= 16'd0;
                count_ld <= 0;
                count_clr <= 1;
                if( restartButton) begin
                    nextState <= state_0;
                    num_ld <= 0;
                    num_clr <= 1;
                end
                
                else begin
                    nextState <= state_1; 
                    num_ld <= 1;
                    num_clr <= 0;
                end  
            end
            
            state_1: begin    
                SevSegNum <= chosenNum;
                // initialize cells
                cells_ld <= 0;
                cells_clr <= 1;
                
                count_ld <= 0;
                count_clr <= 1;
                
                assignGroup <= 4'b0000;
                enable <= 1;
                if ( restartButton) begin
                    nextState <= state_2;
                    num_ld <= 0;
                    num_clr <= 1;
                end
                else begin
                    nextState <= state_1;  
                    num_ld <= 1;
                    num_clr <= 0;
                end  
            end
            
            state_2: begin    
                SevSegNum <= count; 
                count_ld <= 0;
                count_clr <= 1;
                // initialize cells
                cells_ld <= 0;
                cells_clr <= 1;
                nextState <= state_3;
                
                assignGroup <= 4'b0000;
                enable <= 1;
            end
            
            state_3: begin    
                SevSegNum <= count; 
                enable <= 1;
                if( restartButton) begin
                    nextState <= state_2;
                 end
                 else if( gameOver) begin
                    nextState <= state_4;
                    count_ld <= 0;
                    cells_ld <= 0;
                 end
                 else if( assignButton[0] | assignButton[1] | assignButton[2] | assignButton[3]) begin
                    nextState <= state_3;
                    count_ld <= 1;
                    count_clr <= 0;
                    // update cells
                    cells_ld <= 1;
                    cells_clr <= 0;
                    
                    if ( assignButton[0]) begin
                        assignGroup <= 4'b0001;
                    end 
                    
                    else if( assignButton[1]) begin
                        assignGroup <= 4'b0010;
                    end 
                    
                    else if( assignButton[2]) begin
                        assignGroup <= 4'b0100;
                    end 
                    
                    else if( assignButton[3]) begin
                        assignGroup <= 4'b1000;
                    end
                 end 
                 
                 else begin
                    nextState <= state_3;
                    count_ld <= 0;
                    cells_ld <= 0;
                    assignGroup <= 4'b0000;
                 end
            end
            
            state_4: begin
                SevSegNum <= count;
                enable <= clockEnable;
                if( restartButton) begin
                    nextState <= state_0;
                end
                else
                    nextState <= state_4;
            end
        endcase
        
//        LED[2:0] <= state;
//        LED[15:3] <= cells[63:51];
    end
    
    mux16bit_4 MUX( cells[63:48], cells[47:32], cells[31:16], cells[15:0], selectFileReg[1], selectFileReg[0], LED);
    SevSeg_4digit S7(clk, enable, SevSegNum[15:12], SevSegNum[11:8], SevSegNum[7:4], SevSegNum[3:0], seg, dp, an);
     
     // StateReg
     always_ff @(posedge clk) begin
         if ( reset)
            state <= state_0;
         else
            state <= nextState;
     end
endmodule

module data_path(
    input logic clk, _assign, 
          logic [3:0] data,
          logic [1:0] selectDigit,
          logic [1:0] selectFileReg, 
                 // EXTERNAL INPUTS
          
          logic num_ld, num_clr,
                count_ld, count_clr,
                cells_ld, cells_clr,
          logic [3:0] assignGroup, // CONTROL INPUTS
    output logic [15:0] num, [15:0] count, [63:0] cells,
           logic gameOver
    );
    
    logic [63:0] numMemory;
    logic [15:0] chosenData;
    partB FileB(clk, _assign, data, selectDigit, selectFileReg, numMemory, chosenData);
    
    // NUM register
    always_ff @(posedge clk, posedge num_clr, posedge num_ld) begin
        if (num_clr)
            num <= 0;
        else if(num_ld)
            num <= chosenData;
    end 
    
    // COUNT register
    always_ff @(posedge count_ld, posedge count_clr) begin
        if (count_clr)
            count <= 0;
        else if(count_ld)
            count <= count + 1;
    end 
    
    logic [63:0] nextCells;
    logic [63:0] output_cells;
    cellsProcess( cells, nextCells); 
    cellGroupProcess( cells, nextCells, assignGroup, output_cells);
    // CELL REGISTER
    always_ff @(posedge cells_ld, posedge cells_clr) begin
        if( cells_clr) begin
            cells <= numMemory;
        end
        else if( cells_ld) begin
            cells <= output_cells;
        end
    end
    
    assign gameOver = (cells == 64'd0);
endmodule

// FOR UPDATING THE ENTIRE CELLS
module cellsProcess(
    input logic [63:0] cells, 
    output logic [63:0] output_cells
    );
    
    always_comb begin
        for(int i = 0; i < 8; i++) begin
            for(int j = 0; j < 8; j++) begin
                automatic logic up = cells[ ((i + 1) % 8) * 8 + j];
                automatic logic down = cells[ ((i + 7) % 8) * 8 + j];
                automatic logic left = cells[ i * 8 + ((j+1) % 8)];
                automatic logic right = cells[ i * 8 + ((j+7) % 8)];
                
                automatic logic rule_1 = left & up & right & ~down;
                automatic logic rule_2 = left & up & ~right & ~down;
                automatic logic rule_3 = ~left & up & right & ~down;
                automatic logic rule_4 = ~left & up & ~right & down;
                automatic logic rule_5 = left & ~up & ~right & down;
                
                output_cells[i * 8 + j] <= rule_1 | rule_2 | rule_3 | rule_4 | rule_5;
            end
        end
    end
endmodule

// FOR UPDATING THE GROUPS
module cellGroupProcess(
    input logic [63:0] cells, [63:0] nextCells, [3:0] assign_,
    output logic [63:0] output_cells
    );
    
    int group_1 [15:0] = '{63, 61, 50, 48, 47, 45, 34, 32, 23, 21, 19, 17, 7, 5, 3, 1 };
    int group_2 [15:0] = '{62, 60, 51, 49, 46, 44, 35, 33, 22, 20, 18, 16, 6, 4, 2, 0 };
    int group_3 [15:0] = '{59, 57, 55, 53, 43, 41, 39, 37, 30, 28, 26, 24, 14, 12, 10, 8};
    int group_4 [15:0] = '{58, 56, 54, 52, 42, 40, 38, 36, 31, 29, 27, 25, 15, 13, 11, 9};
    
    always_comb begin
        output_cells <= cells;
        foreach(group_1[i]) begin
            output_cells[ group_1[i] ] <= assign_[0] ? nextCells[ group_1[i]] : cells[ group_1[i] ];
        end
        
        foreach(group_2[i]) begin
            output_cells[ group_2[i] ] <= assign_[1] ? nextCells[ group_2[i]] : cells[ group_2[i] ];
        end
        
        foreach(group_3[i]) begin
            output_cells[ group_3[i] ] <= assign_[2] ? nextCells[ group_3[i]] : cells[ group_3[i] ];
        end
        
        foreach(group_4[i]) begin
            output_cells[ group_4[i] ] <= assign_[3] ? nextCells[ group_4[i]] : cells[ group_4[i] ];
        end 
    end
    
endmodule



module FSM(
    input logic clk, restartButton, [3:0] assignButton,
          logic reset, // controller external inputs
          _assign, logic [3:0] data,
          logic [1:0] selectDigit,
          logic [1:0] selectFileReg, // datapath external inputs
          
    output  logic [15:0] LED, logic [6:0] seg, logic dp, logic [3:0] an, // controler external outputs
                // data path external outputs
            logic [7:0] rowsOut, 
            logic ds, oe, stcp, shcp, mr // converter outputs
    );
    
    logic [15:0] chosenNum;
    logic num_ld, num_clr;
    
    logic [15:0] count;
    logic count_ld, count_clr;
    
    logic [63:0] cells;
    logic cells_ld, cells_clr;
    
    logic [3:0] assignGroup;
    
    logic gameOver;
    
    controller(clk, restartButton, assignButton, gameOver, reset, selectFileReg, chosenNum, count, cells,
                num_ld, num_clr, count_ld, count_clr, cells_ld, cells_clr, assignGroup, LED, seg, dp, an);
    data_path(clk, _assign, data, selectDigit, selectFileReg, num_ld, num_clr, count_ld, count_clr, 
                cells_ld, cells_clr, assignGroup, chosenNum, count, cells, gameOver);
                
    
    // CONVERTING THE CELLS
    logic[7:0][7:0] data_in;
    assign data_in[7] = cells[63:56];
    assign data_in[6] = cells[55:48];
    assign data_in[5] = cells[47:40];
    assign data_in[4] = cells[39:32];
    assign data_in[3] = cells[31:24];
    assign data_in[2] = cells[23:16];
    assign data_in[1] = cells[15:8];
    assign data_in[0] = cells[7:0];
    
    converter(clk, data_in, rowsOut, shcp, stcp, mr, oe, ds);
endmodule
