package cpu

import chisel3._
import _root_.circt.stage.ChiselStage
import chisel3.util._

class Alu extends Module {
  val io = IO(new Bundle {
    val i_src_a = Input(UInt(32.W))
    val i_src_b = Input(UInt(32.W))
    val i_control = Input(UInt(3.W))

    val o_result = Output(UInt(32.W))
    val o_zero = Output(Bool())
  })

  val result = Wire(UInt(32.W))

  switch(io.i_control) {
    is("0b000".U) {
      result := io.i_src_a + io.i_src_b
    }
    is("0b001".U) {
      result := io.i_src_a - io.i_src_b
    }
    is("0b010".U) {
      result := io.i_src_a & io.i_src_b
    }
    is("0b011".U) {
      result := io.i_src_a | io.i_src_b
    }
    is("0b101".U) {
      result := io.i_src_a < io.i_src_b
    }
  }

  io.o_result := result
  io.o_zero := result === 0.U
}
