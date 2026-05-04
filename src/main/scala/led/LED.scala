package led

import chisel3._
import _root_.circt.stage.ChiselStage

class LED extends Module {
  val io = IO(new Bundle {
    val in = Input(Bool())
    val out = Output(Bool())
  })

  val state = RegInit(Bool(), true.B)

  state := !state
  io.out := io.in | state
}
