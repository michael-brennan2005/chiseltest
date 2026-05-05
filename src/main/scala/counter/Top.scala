package counter

import chisel3._
import chisel3.util.Fill

class Top extends Module {
  val io = IO(new Bundle {
    val sw = Input(UInt(4.W))
    val led = Output(UInt(4.W))

    val seg = Output(UInt(7.W))
    val dp = Output(Bool())
    val an = Output(UInt(4.W))
  })

  val decoder = Module(new BCDToSevenSeg)

  io.led := io.sw
  decoder.io.in := io.sw

  io.dp := true.B
  io.an := false.B
  io.seg := ~decoder.io.out
}
