`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 11/03/2019 02:04:05 PM
// Design Name: 
// Module Name: decoder2_4
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

module inv(
    input logic x,
    output logic y
    );
    
    assign y = ~x;
endmodule

module and2(
    input logic a,b,
    output logic y
    );
    
    assign y = a & b;
endmodule

module or2(
    input logic a,b,
    output logic y
    );
    
    assign y = a | b;
endmodule


module decoder2_4(
    input logic a0,
    input logic a1,
    output logic y0, y1, y2, y3
    );
    
    assign y0 = ~a1 & ~a0; // a1 = 0, a0 = 0
    assign y1 = ~a1 & a0; // a1 = 0, a0 = 1
    assign y2 = a1 & ~a0; // a1 = 1, a0 = 0
    assign y3 = a1 & a0; // a1 = 1, a0 = 1
    
endmodule


module test_bench_decoder_2_4();
    logic a0, a1;
    logic y0, y1, y2, y3;
    
    decoder2_4 D1(a0, a1, y0, y1, y2, y3);
    
        // apply inputs one at a time
    initial begin
        a1 = 0; #10;
        a0 = 0; #10;
        a0 = 1; #10;
        
        a1 = 1; #10;
        a0 = 0; #10;
        a0 = 1; #10;
    end
    
endmodule


module mux2_1(
    input logic d0, d1, s0,
    output logic y
    );
    
    assign y = s0 ? d1 : d0; 
    
endmodule


module mux4_1(
    input logic d0, d1, d2, d3, s0, s1,
    output logic y
    );
    
    logic m0, m1;
    
    mux2_1 M0(d0, d1, s0, m0);
    mux2_1 M1(d2, d3, s0, m1);
    mux2_1 M2(m0, m1, s1, y); 
    
endmodule

module mux8_1(
    input logic d0, d1, d2, d3, d4, d5, d6, d7,
                s2, s1, s0,
    output logic y
    );
    
    logic m0, m1, i, m2, m3;
    
    mux4_1 M0(d0, d1, d2, d3, s0, s1, m0);
    mux4_1 M1(d4, d5, d6, d7, s0, s1, m1);

    inv I1(s2, i);
    and2 A1(m0, i, m3);
    and2 A2(m1, s2, m4);
    or2 O1(m3, m4, y);
endmodule

module testbench_mux_4_1();

logic d0, d1, d2, d3, s1, s0, y;
mux4_1 test(d0, d1, d2, d3, s0, s1, y);

initial begin
        s0 = 0; s1 = 0; 
        d0 = 0; d1 = 0; d2 = 0; d3 = 0; #10;
        d0 = 0; d1 = 0; d2 = 0; d3 = 1; #10;
        d0 = 0; d1 = 0; d2 = 1; d3 = 0; #10;
        d0 = 0; d1 = 0; d2 = 1; d3 = 1; #10;
        d0 = 0; d1 = 1; d2 = 0; d3 = 0; #10;
        d0 = 0; d1 = 1; d2 = 0; d3 = 1; #10;
        d0 = 0; d1 = 1; d2 = 1; d3 = 0; #10;
        d0 = 0; d1 = 1; d2 = 1; d3 = 1; #10;
        d0 = 1; d1 = 0; d2 = 0; d3 = 0; #10;
        d0 = 1; d1 = 0; d2 = 0; d3 = 1; #10;
        d0 = 1; d1 = 0; d2 = 1; d3 = 0; #10;
        d0 = 1; d1 = 0; d2 = 1; d3 = 1; #10;
        d0 = 1; d1 = 1; d2 = 0; d3 = 0; #10;
        d0 = 1; d1 = 1; d2 = 0; d3 = 1; #10;
        d0 = 1; d1 = 1; d2 = 1; d3 = 0; #10;
        d0 = 1; d1 = 1; d2 = 1; d3 = 1; #10;
        s0 = 1; s1 = 0;
        d0 = 0; d1 = 0; d2 = 0; d3 = 0; #10;
        d0 = 0; d1 = 0; d2 = 0; d3 = 1; #10;
        d0 = 0; d1 = 0; d2 = 1; d3 = 0; #10;
        d0 = 0; d1 = 0; d2 = 1; d3 = 1; #10;
        d0 = 0; d1 = 1; d2 = 0; d3 = 0; #10;
        d0 = 0; d1 = 1; d2 = 0; d3 = 1; #10;
        d0 = 0; d1 = 1; d2 = 1; d3 = 0; #10;
        d0 = 0; d1 = 1; d2 = 1; d3 = 1; #10;
        d0 = 1; d1 = 0; d2 = 0; d3 = 0; #10;
        d0 = 1; d1 = 0; d2 = 0; d3 = 1; #10;
        d0 = 1; d1 = 0; d2 = 1; d3 = 0; #10;
        d0 = 1; d1 = 0; d2 = 1; d3 = 1; #10;
        d0 = 1; d1 = 1; d2 = 0; d3 = 0; #10;
        d0 = 1; d1 = 1; d2 = 0; d3 = 1; #10;
        d0 = 1; d1 = 1; d2 = 1; d3 = 0; #10;
        d0 = 1; d1 = 1; d2 = 1; d3 = 1; #10;
        s0 = 0; s1 = 1;
        d0 = 0; d1 = 0; d2 = 0; d3 = 0; #10;
        d0 = 0; d1 = 0; d2 = 0; d3 = 1; #10;
        d0 = 0; d1 = 0; d2 = 1; d3 = 0; #10;
        d0 = 0; d1 = 0; d2 = 1; d3 = 1; #10;
        d0 = 0; d1 = 1; d2 = 0; d3 = 0; #10;
        d0 = 0; d1 = 1; d2 = 0; d3 = 1; #10;
        d0 = 0; d1 = 1; d2 = 1; d3 = 0; #10;
        d0 = 0; d1 = 1; d2 = 1; d3 = 1; #10;
        d0 = 1; d1 = 0; d2 = 0; d3 = 0; #10;
        d0 = 1; d1 = 0; d2 = 0; d3 = 1; #10;
        d0 = 1; d1 = 0; d2 = 1; d3 = 0; #10;
        d0 = 1; d1 = 0; d2 = 1; d3 = 1; #10;
        d0 = 1; d1 = 1; d2 = 0; d3 = 0; #10;
        d0 = 1; d1 = 1; d2 = 0; d3 = 1; #10;
        d0 = 1; d1 = 1; d2 = 1; d3 = 0; #10;
        d0 = 1; d1 = 1; d2 = 1; d3 = 1; #10;
        s0 = 1; s1 = 1;
        d0 = 0; d1 = 0; d2 = 0; d3 = 0; #10;
        d0 = 0; d1 = 0; d2 = 0; d3 = 1; #10;
        d0 = 0; d1 = 0; d2 = 1; d3 = 0; #10;
        d0 = 0; d1 = 0; d2 = 1; d3 = 1; #10;
        d0 = 0; d1 = 1; d2 = 0; d3 = 0; #10;
        d0 = 0; d1 = 1; d2 = 0; d3 = 1; #10;
        d0 = 0; d1 = 1; d2 = 1; d3 = 0; #10;
        d0 = 0; d1 = 1; d2 = 1; d3 = 1; #10;
        d0 = 1; d1 = 0; d2 = 0; d3 = 0; #10;
        d0 = 1; d1 = 0; d2 = 0; d3 = 1; #10;
        d0 = 1; d1 = 0; d2 = 1; d3 = 0; #10;
        d0 = 1; d1 = 0; d2 = 1; d3 = 1; #10;
        d0 = 1; d1 = 1; d2 = 0; d3 = 0; #10;
        d0 = 1; d1 = 1; d2 = 0; d3 = 1; #10;
        d0 = 1; d1 = 1; d2 = 1; d3 = 0; #10;
        d0 = 1; d1 = 1; d2 = 1; d3 = 1; #10;
    end
endmodule

module testbench_mux_8_1();
    logic d0,d1,d2,d3,d4,d5,d6,d7,s0, s1, s2;
    logic y;
    
    mux8_1 test(d0, d1, d2, d3 ,d4, d5, d6, d7,
                    s0, s1, s2, y);
                    
    initial begin
    s2 = 0;
        s1 = 0;
        // case for 000
            s0 = 0;
            d0 = 1; d1 = 0; d2 = 0; d3 = 0; d4 = 0; d5 = 0; d6 = 0; d7 = 0; #10;
            d0 = 0; d1 = 1; #10;
            d1 = 0; d2 = 1; #10;
            d2 = 0; d3 = 1; #10;
            d3 = 0; d4 = 1; #10;
            d4 = 0; d5 = 1; #10;
            d5 = 0; d6 = 1; #10;    
            d6 = 0; d7 = 1; # 10;
            
            // case for 001
            s0 = 1;         
            d0 = 1; d1 = 0; d2 = 0; d3 = 0; d4 = 0; d5 = 0; d6 = 0; d7 = 0; #10;
            d0 = 0; d1 = 1; #10;
            d1 = 0; d2 = 1; #10;
            d2 = 0; d3 = 1; #10;
            d3 = 0; d4 = 1; #10;
            d4 = 0; d5 = 1; #10;
            d5 = 0; d6 = 1; #10;    
            d6 = 0; d7 = 1; # 10;
            
        
        s1 = 1;
            // case for 010
            s0 = 0;
            d0 = 1; d1 = 0; d2 = 0; d3 = 0; d4 = 0; d5 = 0; d6 = 0; d7 = 0; #10;
            d0 = 0; d1 = 1; #10;
            d1 = 0; d2 = 1; #10;
            d2 = 0; d3 = 1; #10;
            d3 = 0; d4 = 1; #10;
            d4 = 0; d5 = 1; #10;
            d5 = 0; d6 = 1; #10;    
            d6 = 0; d7 = 1; # 10;
            
            // case for 011
            s0 = 1;         
            d0 = 1; d1 = 0; d2 = 0; d3 = 0; d4 = 0; d5 = 0; d6 = 0; d7 = 0; #10;
            d0 = 0; d1 = 1; #10;
            d1 = 0; d2 = 1; #10;
            d2 = 0; d3 = 1; #10;
            d3 = 0; d4 = 1; #10;
            d4 = 0; d5 = 1; #10;
            d5 = 0; d6 = 1; #10;    
            d6 = 0; d7 = 1; # 10;
        
    s2 = 1;
        s1 = 0;
        // case for 100
            s0 = 0;
            d0 = 1; d1 = 0; d2 = 0; d3 = 0; d4 = 0; d5 = 0; d6 = 0; d7 = 0; #10;
            d0 = 0; d1 = 1; #10;
            d1 = 0; d2 = 1; #10;
            d2 = 0; d3 = 1; #10;
            d3 = 0; d4 = 1; #10;
            d4 = 0; d5 = 1; #10;
            d5 = 0; d6 = 1; #10;    
            d6 = 0; d7 = 1; # 10;
            
            // case for 101
            s0 = 1;         
            d0 = 1; d1 = 0; d2 = 0; d3 = 0; d4 = 0; d5 = 0; d6 = 0; d7 = 0; #10;
            d0 = 0; d1 = 1; #10;
            d1 = 0; d2 = 1; #10;
            d2 = 0; d3 = 1; #10;
            d3 = 0; d4 = 1; #10;
            d4 = 0; d5 = 1; #10;
            d5 = 0; d6 = 1; #10;    
            d6 = 0; d7 = 1; # 10;
            
        
        s1 = 1;
            // case for 110
            s0 = 0;
            d0 = 1; d1 = 0; d2 = 0; d3 = 0; d4 = 0; d5 = 0; d6 = 0; d7 = 0; #10;
            d0 = 0; d1 = 1; #10;
            d1 = 0; d2 = 1; #10;
            d2 = 0; d3 = 1; #10;
            d3 = 0; d4 = 1; #10;
            d4 = 0; d5 = 1; #10;
            d5 = 0; d6 = 1; #10;    
            d6 = 0; d7 = 1; # 10;
            
            // case for 111
            s0 = 1;         
            d0 = 1; d1 = 0; d2 = 0; d3 = 0; d4 = 0; d5 = 0; d6 = 0; d7 = 0; #10;
            d0 = 0; d1 = 1; #10;
            d1 = 0; d2 = 1; #10;
            d2 = 0; d3 = 1; #10;
            d3 = 0; d4 = 1; #10;
            d4 = 0; d5 = 1; #10;
            d5 = 0; d6 = 1; #10;    
            d6 = 0; d7 = 1; # 10;
    end
endmodule


// Structural SystemVerilog module for the function F

module F( 
    input logic a, b, c, d,
    output logic y
    );
    
    logic D, D_not, dummyWire1, dummyWire2;
    decoder2_4(d, d, D_not, dummyWire1, dummyWire2, D);
    
    logic I;
    or2(D, D_not, I);
    
    mux8_1(D_not, D_not, D, D_not, D_not, D_not, I, D, a, b, c, y);  
endmodule

module updatedF(
    input logic a, b, c, d,
    output logic y
    );

    mux8_1(~d, ~d, d, ~d, ~d, ~d, 1, d, a,b,c, y);
    
endmodule

module finalModule(
        input a0, a1, a, b, c, d,
        output y0, y1, y2, y3, y
    );
    
    decoder2_4 D(a0, a1, y0, y1, y2, y3);
    updatedF func(a,b,c,d,y);
    
endmodule
