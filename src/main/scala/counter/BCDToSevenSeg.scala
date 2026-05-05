package counter

import chisel3._
import chisel3.util.experimental.decode.TruthTable
import chisel3.util.BitPat
import chisel3.util.switch
import chisel3.util.is

// BCD to seven seg converter
class BCDToSevenSeg extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(4.W))
    val out = Output(UInt(7.W))
  })

  io.out := 0.U

  switch(io.in) {
    is(0.U) { io.out := "b0111111".U }
    is(1.U) { io.out := "b0000110".U }
    is(2.U) { io.out := "b1011011".U }
    is(3.U) { io.out := "b1001111".U }
    is(4.U) { io.out := "b1100110".U }
    is(5.U) { io.out := "b1101101".U }
    is(6.U) { io.out := "b1111101".U }
    is(7.U) { io.out := "b0000111".U }
    is(8.U) { io.out := "b1111111".U }
    is(9.U) { io.out := "b1101111".U }
  }
}
