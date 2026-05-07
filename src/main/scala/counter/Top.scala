package counter

import chisel3._
import chisel3.util.Fill
import chisel3.util.Cat

class Top extends Module {
  val io = IO(new Bundle {
    val sw = Input(UInt(16.W))
    val led = Output(UInt(16.W))

    val seg = Output(UInt(7.W))
    val dp = Output(Bool())
    val an = Output(UInt(4.W))
  })

  val double_dabble = Module(new DoubleDabble)
  val (start_counter_val, start_counter_wrap) = util.Counter(true.B, 16000)
  double_dabble.io.start := start_counter_wrap

  double_dabble.io.in := Cat("b00".U, io.sw(13, 0))
  io.led := io.sw

  val decoder0 = Module(new BCDToSevenSeg)
  val decoder1 = Module(new BCDToSevenSeg)
  val decoder2 = Module(new BCDToSevenSeg)
  val decoder3 = Module(new BCDToSevenSeg)

  decoder0.io.in := double_dabble.io.out(0)
  decoder1.io.in := double_dabble.io.out(1)
  decoder2.io.in := double_dabble.io.out(2)
  decoder3.io.in := double_dabble.io.out(3)

  // 4000 cycles = 16ms to show all digits
  val seven_seg_controller = Module(new SevenSegController(4000))

  seven_seg_controller.io.digits(0) := ~decoder0.io.out
  seven_seg_controller.io.digits(1) := ~decoder1.io.out
  seven_seg_controller.io.digits(2) := ~decoder2.io.out
  seven_seg_controller.io.digits(3) := ~decoder3.io.out
  seven_seg_controller.io.en := 1.U

  io.seg := seven_seg_controller.io.seg
  io.dp := seven_seg_controller.io.dp
  io.an := seven_seg_controller.io.an
}
