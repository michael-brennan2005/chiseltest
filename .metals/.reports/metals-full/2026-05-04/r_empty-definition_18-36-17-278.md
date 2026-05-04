error id: file://<WORKSPACE>/src/main/scala/Main.scala:_empty_/Main.
file://<WORKSPACE>/src/main/scala/Main.scala
empty definition using pc, found symbol in pc: 
found definition using semanticdb; symbol _empty_/Main.
empty definition using fallback
non-local guesses:

offset: 167
uri: file://<WORKSPACE>/src/main/scala/Main.scala
text:
```scala
import chisel3._
import _root_.circt.stage.ChiselStage
import led.LEDCircuit
import counter.Counter

class Counter extends Module {
  val io = IO(new Bundle {
    val @@sw0 = Input(Bool())
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

```


#### Short summary: 

empty definition using pc, found symbol in pc: 