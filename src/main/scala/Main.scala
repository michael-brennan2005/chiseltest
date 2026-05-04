import chisel3._
import _root_.circt.stage.ChiselStage

class Top extends Module {
  val io = IO(new Bundle {
    val sw0 = Input(Bool())
    val sw1 = Input(Bool())
    val led = Output(Bool())
  })

  io.led := io.sw0 & io.sw1
}

object Main extends App {
  ChiselStage.emitSystemVerilogFile(
    new Top,
    args = Array(
      "--target-dir",
      "./build/sv/"
    ),
    firtoolOpts = Array(
      "-disable-all-randomization",
      "-strip-debug-info",
      "-default-layer-specialization=enable"
    )
  )
}
