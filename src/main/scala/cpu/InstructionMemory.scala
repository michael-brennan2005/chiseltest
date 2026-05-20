package cpu

import chisel3._
import _root_.circt.stage.ChiselStage
import chisel3.util.Cat

class InstructionMemory extends Module {
  val io = IO(new Bundle {
    val i_addr = Input(UInt(32.W))
    val o_rd = Output(UInt(32.W)) // rd => read data
  })

  val mem = Reg(Vec(32, UInt(8.W)))

  io.o_rd := Cat(
    mem(io.i_addr + 3.U),
    mem(io.i_addr + 2.U),
    mem(io.i_addr + 1.U),
    mem(io.i_addr)
  )
}
