package counter

import chisel3._
import chisel3.util.Fill
import chisel3.util.is
import chisel3.util.switch
import chisel3.util.Cat
import counter.DoubleDabble.State.sIdle
import counter.DoubleDabble.State.sAdd0
import counter.DoubleDabble.State.sAdd1
import counter.DoubleDabble.State.sShift
import counter.DoubleDabble.State.{sCheck => sCheck}
import counter.DoubleDabble.State.sAdd2
import counter.DoubleDabble.State.sAdd3

object DoubleDabble {
  object State extends ChiselEnum {
    val sIdle, sAdd0, sAdd1, sAdd2, sAdd3, sShift, sCheck = Value
  }
}

// Fixed-width (16-bit input, 5-digit output), double dabble, binary -> BCD converter.
class DoubleDabble extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(16.W))
    val out = Output(Vec(5, UInt(4.W)))

    // Rising edge triggers translation
    val start = Input(Bool())
  })

  val state = RegInit(sIdle)
  val shiftCounter = Reg(UInt(8.W))
  val scratch = Reg(UInt((16 + (5 * 4)).W))
  val startTrigger = io.start && !RegNext(io.start)

  // Ones => 0th digit, Tens => 1st digit, Hundreds => 2nd digit, etc.
  def bcdLSBIdx(digit: Int) = digit * 4 + 16
  def bcdMSBIdx(digit: Int) = bcdLSBIdx(digit + 1) - 1

  switch(state) {
    is(sIdle) {
      when(startTrigger) {
        state := sAdd0
        scratch := Cat(Fill(4 * 5, 0.U), io.in)
        shiftCounter := 0.U
      }
    }

    is(sAdd0) {
      when(scratch(bcdMSBIdx(0), bcdLSBIdx(0)) >= 5.U) {
        scratch := scratch + (3.U << 16)
      }

      state := sAdd1
    }

    is(sAdd1) {
      when(scratch(bcdMSBIdx(1), bcdLSBIdx(1)) >= 5.U) {
        scratch := scratch + (3.U << 20)
      }

      state := sAdd2
    }

    is(sAdd2) {
      when(scratch(bcdMSBIdx(2), bcdLSBIdx(2)) >= 5.U) {
        scratch := scratch + (3.U << 24)
      }

      state := sAdd3
    }

    is(sAdd3) {
      when(scratch(bcdMSBIdx(3), bcdLSBIdx(3)) >= 5.U) {
        scratch := scratch + (3.U << 28)
      }

      state := sShift
    }

    is(sShift) {
      scratch := scratch << 1
      state := sCheck
    }

    is(sCheck) {
      shiftCounter := shiftCounter + 1.U

      when(shiftCounter === 15.U) {
        state := sIdle
      }.otherwise {
        state := sAdd0
      }
    }
  }

  io.out(0) := scratch(19, 16)
  io.out(1) := scratch(23, 20)
  io.out(2) := scratch(27, 24)
  io.out(3) := scratch(31, 28)
  io.out(4) := scratch(35, 32)
}
