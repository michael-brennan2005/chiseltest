`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company:
// Engineer:
//
// Create Date: 05/01/2026 04:53:31 PM
// Design Name:
// Module Name: Testbench1
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


module Testbench1;
    // DUT signals
    logic clock, reset, io_in1, io_in2, io_out;

    // Instantiate DUT
    LEDCircuit dut (
        .clock (clock),
        .reset (reset),
        .io_in1(io_in1),
        .io_in2(io_in2),
        .io_out(io_out)
    );

    // Clock gen: 10ns period
    initial clock = 0;
    always #5 clock = ~clock;

    // Test sequence
    initial begin
        $dumpfile("dump.vcd");
        $dumpvars();

        // Reset
        reset  = 1;
        io_in1 = 0;
        io_in2 = 0;
        @(posedge clock);
        #1;
        reset = 0;

        // Test all input combos
        for (int i = 0; i < 4; i++) begin
            io_in1 = i[1];
            io_in2 = i[0];
            @(posedge clock);
            #1;
            $display("io_in1=%b, io_in2=%b -> io_out=%b (expected=%b)", io_in1, io_in2, io_out,
                     io_in1 & io_in2);
        end

        $finish;
    end
endmodule
