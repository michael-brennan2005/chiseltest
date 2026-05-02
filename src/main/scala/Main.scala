import _root_.circt.stage.ChiselStage
import led.LEDCircuit

object Main extends App {
  ChiselStage.emitSystemVerilogFile(
    new LEDCircuit,
    args = Array(
      "--target-dir",
      "chisel_out/"
    ),
    firtoolOpts = Array(
      "-disable-all-randomization",
      "-strip-debug-info",
      "-default-layer-specialization=enable"
    )
  )
}
