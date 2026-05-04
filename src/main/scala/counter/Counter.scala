package counter

import chisel3._
import _root_.led.LED

class Counter extends Module {
  val io = IO(new Bundle {
    val sw0 = Input(Bool())
    val sw1 = Input(Bool())
    val led = Output(Bool())
  })

  io.led := io.sw0 & io.sw1
}
