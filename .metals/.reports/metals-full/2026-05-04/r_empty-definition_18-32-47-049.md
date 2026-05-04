error id: file://<WORKSPACE>/src/main/scala/Main.scala:sw1.
file://<WORKSPACE>/src/main/scala/Main.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -counter/io/sw1.
	 -counter/io/sw1#
	 -counter/io/sw1().
	 -scala/Predef.counter.io.sw1.
	 -scala/Predef.counter.io.sw1#
	 -scala/Predef.counter.io.sw1().
offset: 305
uri: file://<WORKSPACE>/src/main/scala/Main.scala
text:
```scala
import _root_.circt.stage.ChiselStage
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
  counter.io.@@sw1 
}

object Main extends App {
  ChiselStage.emitSystemVerilogFile(
    new Counter,
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

```


#### Short summary: 

empty definition using pc, found symbol in pc: 