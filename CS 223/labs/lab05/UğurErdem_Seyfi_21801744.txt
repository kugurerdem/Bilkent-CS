`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 12/07/2019 08:35:25 PM
// Design Name: 
// Module Name: modules
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

module timer(
    input logic clk, load, enable, [31:0] M,
    output logic clkP
    );
    
    logic[31:0] dummyC;
    counter C(clk, load, enable, M, clkP, dummyC);

endmodule

module counter(
    input logic clk, load, enable,[31:0] countNo,
    output logic tc, [31:0] OUT
    );
    
    always_ff @( posedge clk, posedge load) begin
        if (load | OUT >= countNo - 1) 
            OUT <= 0;
        else if (enable)
            OUT <= OUT + 1;
        
        tc <= (OUT == countNo - 1) ? 1 : 0;
    end    
endmodule

module master_process(
    input logic clk, load, enable,
    output logic ledCM
    );
    
    logic[31:0] A = 2000000;
    logic clk_20ms;
    timer T20(clk, load, enable, A, clk_20ms);
    
    logic[31:0] B = 50;
    logic[31:0] dummy;
    logic outflow;
    counter C(clk_20ms, load, enable, B, outflow, dummy); 
    
    always_ff @(posedge clk_20ms) begin
        ledCM <= outflow ? ~ledCM : ledCM;
    end
endmodule

module slave_process(
    input logic clk, load, enable,
    output logic ledSM
    );
    
    logic[31:0] A = 2000000;
    logic clk_20ms;
    timer T20(clk, load, enable, A, clk_20ms);
    
    logic[31:0] B = 25;
    logic[31:0] dummy;
    logic outflow;
    counter C(clk_20ms, load, enable, B, outflow, dummy); 
    
    always_ff @(posedge clk_20ms) begin
        ledSM <= outflow ? ~ledSM : ledSM;
    end
endmodule

module master_slave(
    input logic clk, M, S, Em, Es, reset,
    output logic M_LED, S_LED, CM_LED, CS_LED,
    output logic [6:0] seg, logic dp, logic [3:0] an 
    );
    
    assign M_LED = M | ((~M & ~S) & Em);
    assign S_LED = (~M & S) | ((~M & ~S) & (~Em & Es)) ;
    
    master_process MP(clk, 0, Em & M_LED, CM_LED);
    slave_process SP(clk, 0, Es & S_LED, CS_LED);
    
    logic[31:0] upperLim = 9999;
    logic[31:0] count;
    logic[31:0] tc;
    
    logic[31:0] count01;
    logic[31:0] count02;
    
    counter MasterCounter(CM_LED, reset, M_LED, upperLim, tc, count01);
    counter SlaveCounter(CS_LED, reset, S_LED, upperLim, tc, count02);
    
    assign count = (!M_LED & S_LED) ? count02 : count01;
    logic[3:0] a; // least significant bit
    logic[3:0] b;
    logic[3:0] c;
    logic[3:0] d; // most significant bit
    
    assign d = count[15:12];
    assign c = count[11:8];
    assign b = count[7:4];
    assign a = count[3:0];
    
//    assign a = count[31:28];
//    assign b = count[27:24];
//    assign c = count[23:20];
//    assign d = count[19:16];
    
    
    // register(clk, reset, CM_LED, C_1 + 1, C_1);
    SevSeg_4digit S7(clk, a, b, c, d, seg, dp, an);

endmodule

module register(
    input logic clk, reset, load, [15:0] data,
    output logic [15:0] Q
    );
    
    always_ff @(posedge clk, posedge reset, posedge load) begin
        if (reset)
            Q <= 0;
        else if(load)
            Q <= data;
    end
endmodule

module testbench();

    logic clk, M, S, Em, Es, reset;
    logic M_LED, S_LED, CM_LED, CS_LED, dp;
    logic [6:0] s;
    logic [3:0] an; 
    
    master_slave MS(clk, M, S, Em, Es, reset, 
        M_LED, S_LED, CM_LED, CS_LED, s, dp, an);
    
    initial begin
        M = 0; 
        S = 0; 
            Em = 0; 
                Es = 0; 
                repeat(10) begin
                    clk = 1; #10;
                    clk = 0; #10;
                end
                
                Es = 1;
                repeat(10) begin
                    clk = 1; #10;
                    clk = 0; #10;
                end
            
            Em = 1;
                Es = 0; 
                repeat(10) begin
                    clk = 1; #10;
                    clk = 0; #10;
                end
                
                Es = 1;
                repeat(10) begin
                    clk = 1; #10;
                    clk = 0; #10;
                end
         S = 1;
             Em = 0; 
                Es = 0; 
                repeat(10) begin
                    clk = 1; #10;
                    clk = 0; #10;
                end
                
                Es = 1;
                repeat(10) begin
                    clk = 1; #10;
                    clk = 0; #10;
                end
            
            Em = 1;
                Es = 0; 
                repeat(10) begin
                    clk = 1; #10;
                    clk = 0; #10;
                end
                
                Es = 1;
                repeat(10) begin
                    clk = 1; #10;
                    clk = 0; #10;
                end
       M = 1;
       S = 0; 
            Em = 0; 
                Es = 0; 
                repeat(10) begin
                    clk = 1; #10;
                    clk = 0; #10;
                end
                
                Es = 1;
                repeat(10) begin
                    clk = 1; #10;
                    clk = 0; #10;
                end
            
            Em = 1;
                Es = 0; 
                repeat(10) begin
                    clk = 1; #10;
                    clk = 0; #10;
                end
                
                Es = 1;
                repeat(10) begin
                    clk = 1; #10;
                    clk = 0; #10;
                end
         S = 1;
             Em = 0; 
                Es = 0; 
                repeat(10) begin
                    clk = 1; #10;
                    clk = 0; #10;
                end
                
                Es = 1;
                repeat(10) begin
                    clk = 1; #10;
                    clk = 0; #10;
                end
            
            Em = 1;
                Es = 0; 
                repeat(10) begin
                    clk = 1; #10;
                    clk = 0; #10;
                end
                
                Es = 1;
                repeat(10) begin
                    clk = 1; #10;
                    clk = 0; #10;
                end          
    end
    
endmodule