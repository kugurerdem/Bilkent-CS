`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 10/19/2019 08:19:59 PM
// Design Name: 
// Module Name: half_adder
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

/*
 BEHAVIOURAL HALF_ADDER
*/
module half_adder(
    input logic a, b,
    output logic sum, carry
    );
    
    assign sum = a ^ b;
    assign carry = a & b; 
endmodule

/*
 BEHAVIOURAL HALF_SUBSTRACTOR
*/
module half_substractor(
    input logic a, b,
    output logic diff, borrow
    );
   
    assign diff = a ^ b;
    assign borrow = b &  ~a;
endmodule

/*
BEHAVIORAL FULL_SUBSTRACTOR
*/
module b_full_substractor(
    input logic a, b, B_in,
    output logic diff, borrow
    );
   
    assign diff = a ^ b ^ B_in;
    assign borrow = (~a & B_in) | (~a & b) | (b & B_in);
endmodule

/*
 STRUCTURAL FULL_SUBSTRACTOR
*/
module s_full_substractor(
    input a, b, B_in,
    output diff, borrow
    );
   
    wire d1, b1, b2;
    
    half_substractor Hs1(a, b, d1, b1);
    half_substractor Hs2(d1,B_in, diff, b2);
    or(borrow, b1, b2);
    
endmodule

/*
BEHAVIORAL FULL_ADDER
*/
module b_full_adder(
    input logic a, b, c,
    output logic sum, carry
    );
   
    assign sum = a ^ b ^ c;
    assign carry = (a & b) | (c & (a ^ b) );
endmodule

/*
 STRUCTURAL FULL_ADDER
*/
module s_full_adder(
    input a, b, c,
    output sum, carry
    );
   
    wire s1, c1, c2;
    
    
    half_adder H1(a, b, s1, c1);
    half_adder H2(s1, c, sum, c2);
    or(carry, c1, c2);

endmodule


/*
    TestBench for 1-bit full adder, 1-bit full substractor
*/
module TestBench01();
    logic a, b, c;
    logic sum, carry, diff, borrow;
    
    s_full_adder Fa01(a, b, c, sum, carry);
    s_full_substractor Fs01(a, b, c, diff, borrow);
    
    // apply inputs one at a time
    initial begin
        a = 0; b = 0; c = 0; #10;
        c = 1; #10;
        b = 1; c = 0; #10;
        c = 1; #10;
        a = 1; b = 0; c = 0; #10;
        c = 1; #10;
        b = 1; c = 0; #10;
        c = 1; #10;
    end
endmodule

/*
    Structural 2-bit adder
*/
module full_adder_2bit(
    input logic a0, a1, b0, b1, c_in,
    output logic r0, r1, carry
    );
    
    logic c0;
    
    s_full_adder sFa01(a0, b0, c_in, r0, c0);
    s_full_adder sFa02(a1, b1, c0, r1, carry);
    
endmodule

/*
    Structural 2-bit substractor
*/
module full_substractor_2bit(
    input logic a0, a1, b0, b1,b_in,
    output logic r0, r1, borrow
    );
    
    logic borrow_0;
    
    s_full_substractor Fs01(a0, b0, b_in, r0, borrow_0);
    s_full_substractor Fs02(a1, b1, borrow_0, r1, borrow);
endmodule

/*
    TestBench for 2bit substractor and adder
*/
module TestBench02();
    logic a0, a1, b0, b1;
    logic s0, s1, c, d0, d1, b;
    
    full_adder_2bit Fa(a0, a1, b0, b1, 0, s0, s1, c);
    full_substractor_2bit Fs(a0, a1, b0, b1, 0, d0, d1, b);
    
    // apply inputs one at a time
    initial begin
        a1 = 0; a0 = 0; b1 = 0; b0 = 0; #10; // 00 - 00
        b0 = 1; #10; // 00 - 01
        b1 = 1; b0 = 0; #10; // 00 - 10
        b0 = 1; #10; // 00 - 11
        a0 = 1; b1 = 0; b0 = 0; #10; // 01 - 00
        b0 = 1; #10; // 01 - 01
        b1 = 1; b0 = 0; #10; // 01 - 10
        b0 = 1; #10; // 01 - 11
        
        a1 = 1; a0 = 0; b1 = 0; b0 = 0; // 10 - 00
        b0 = 1; #10; // 10 - 01
        b1 = 1; b0 = 0; #10; // 10 - 10
        b0 = 1; #10; // 10 - 11
        a0 = 1; b1 = 0; b0 = 0; #10; // 11 - 00
        b0 = 1; #10; // 11 - 01
        b1 = 1; b0 = 0; #10; // 11 - 10
        b0 = 1; #10; // 11 - 11
    end
    
endmodule

/*
    Final module
*/

module finalModule(
    input a0, a1, b0, b1, c_in, b_in,
    output s0, s1, c, d0, d1, b 
    );
    
    full_adder_2bit Fa(a0, a1, b0, b1, c_in, s0, s1, c);
    full_substractor_2bit Fs(a0, a1, b0, b1, b_in, d0, d1, b);
    
endmodule



 