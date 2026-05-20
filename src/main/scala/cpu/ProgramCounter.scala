package cpu

import chisel3._
import _root_.circt.stage.ChiselStage

class ProgramCounter extends Module {
  val io = IO(new Bundle {
    val i_pc_next = Input(UInt(32.W))
    val o_pc = Output(UInt(32.W))
  })

  val pc = RegNext(io.i_pc_next)
  io.o_pc := pc
}
