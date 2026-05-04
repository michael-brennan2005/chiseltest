error id: file://<WORKSPACE>/src/main/scala/Main.scala:_root_/
file://<WORKSPACE>/src/main/scala/Main.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 29
uri: file://<WORKSPACE>/src/main/scala/Main.scala
text:
```scala
import chisel3._

import _roo@@t_.circt.stage.ChiselStage
import led.LEDCircuit
import counter.Counter


class Top extends Module {
  val io = IO(new Bundle {
    val sw0 = Input(Bool())
    val sw1 = Input(Bool())
    val led = Output(Bool())
  })

  val counter = Module(new Counter)
  counter.io.sw0 := io.sw0
  counter.io.sw1 := io.sw1
  counter.io.led := io.led
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