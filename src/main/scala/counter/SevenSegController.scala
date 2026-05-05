package counter

import chisel3._
import chisel3.util.Fill

class SevenSegController extends Module {
  val io = IO(new Bundle {
    val input = Input(UInt(14.W))
    val seg = Output(UInt(7.W))
    val dp = Output(Bool())
    val an = Output(UInt(4.W))
  })

  // Disable the periods (active LOW)
  io.dp := true.B

}
