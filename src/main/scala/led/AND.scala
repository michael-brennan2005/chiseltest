package led

import chisel3._
import _root_.circt.stage.ChiselStage

class AND extends Module {
  val io = IO(new Bundle {
    val in1 = Input(Bool())
    val in2 = Input(Bool())
    val out = Output(Bool())
  })

  io.out := io.in1 & io.in2
}
