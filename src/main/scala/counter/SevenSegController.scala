package counter

import chisel3._
import chisel3.util.Fill
import chisel3.util.switch
import chisel3.util.is

object SevenSegController {
  object State extends ChiselEnum {
    val sD0, sD1, sD2, sD3 = Value
  }
}

// (TODO: make this variable) this assumes a 1 MHz clock
class SevenSegController(cycles_per_digit: Int) extends Module {
  import SevenSegController.State
  import SevenSegController.State._

  val io = IO(new Bundle {
    val digits = Input(Vec(4, UInt(7.W)))
    val en = Input(Bool())

    val seg = Output(UInt(7.W))
    val dp = Output(Bool())
    val an = Output(UInt(4.W))
  })

  // Disable the periods (active LOW)
  io.dp := true.B

  // Tie common anodes to en. Common anides are active LOW, so we invert the en signal.
  io.an := Fill(4, ~io.en)

  // Not sure why this is needed
  io.seg := 0.U

  val state = RegInit(sD0)
  val counter = RegInit(0.U(16.W))

  switch(state) {
    is(sD0) {
      io.an := "b1110".U
      io.seg := io.digits(0)

      when(counter === (cycles_per_digit - 1).U) {
        state := sD1
        counter := 0.U
      }.otherwise {
        counter := counter + 1.U
      }
    }

    is(sD1) {
      io.an := "b1101".U
      io.seg := io.digits(1)

      when(counter === (cycles_per_digit - 1).U) {
        state := sD2
        counter := 0.U
      }.otherwise {
        counter := counter + 1.U
      }
    }

    is(sD2) {
      io.an := "b1011".U
      io.seg := io.digits(2)

      when(counter === (cycles_per_digit - 1).U) {
        state := sD3
        counter := 0.U
      }.otherwise {
        counter := counter + 1.U
      }
    }

    is(sD3) {
      io.an := "b0111".U
      io.seg := io.digits(3)

      when(counter === (cycles_per_digit - 1).U) {
        state := sD0
        counter := 0.U
      }.otherwise {
        counter := counter + 1.U
      }
    }
  }
}
