package led

import chisel3._
import _root_.circt.stage.ChiselStage
import _root_.led.LED

class LEDCircuit extends Module {
  val io = IO(new Bundle {
    val in1 = Input(Bool())
    val in2 = Input(Bool())
    val out = Output(Bool())
  })

  val led = Module(new LED)
  val and = Module(new AND)

  and.io.in1 := io.in1
  and.io.in2 := io.in2

  led.io.in := and.io.out
  io.out := led.io.out
}
