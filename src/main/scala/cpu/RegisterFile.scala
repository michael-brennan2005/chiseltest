package cpu

import chisel3._
import _root_.circt.stage.ChiselStage

class RegisterFile extends Module {
  val io = IO(new Bundle {
    // Registers to read from
    val i_ra_1 = Input(UInt(5.W))
    val i_ra_2 = Input(UInt(5.W))

    // Registers data
    val o_rd_1 = Output(UInt(32.W))
    val o_rd_2 = Output(UInt(32.W))

    // Writing to registers - address, data, an enable
    val i_wa = Input(UInt(5.W))
    val i_wd = Input(UInt(32.W))
    val i_w_en = Input(Bool())
  })

  val regs = Reg(Vec(32, UInt(32.W)))

  io.o_rd_1 := regs(io.i_ra_1)
  io.o_rd_2 := regs(io.i_ra_2)

  when(io.i_w_en === true.B) {
    regs(io.i_wa) := io.i_wd
  }
}
