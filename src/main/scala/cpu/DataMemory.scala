package cpu

import chisel3._
import _root_.circt.stage.ChiselStage
import chisel3.util.Cat

class DataMemory extends Module {
  val io = IO(new Bundle {
    // Address of memory, data to write, write enable, read data
    val i_addr = Input(UInt(32.W))
    val i_wd = Input(UInt(32.W))
    val i_we = Input(Bool())

    val o_rd = Output(UInt(32.W))
  })

  // TODO: uuhhh
  val mem = Reg(Vec(32, UInt(8.W)))

  io.o_rd := Cat(
    mem(io.i_addr + 3.U),
    mem(io.i_addr + 2.U),
    mem(io.i_addr + 1.U),
    mem(io.i_addr)
  )

  when(io.i_we === true.B) {
    mem(io.i_addr + 3.U) := io.i_wd(31, 24)
    mem(io.i_addr + 2.U) := io.i_wd(23, 16)
    mem(io.i_addr + 1.U) := io.i_wd(15, 8)
    mem(io.i_addr) := io.i_wd(7, 0)
  }
}
