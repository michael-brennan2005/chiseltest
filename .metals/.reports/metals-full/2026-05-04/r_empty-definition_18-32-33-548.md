error id: file://<WORKSPACE>/src/main/scala/Main.scala:Counter#
file://<WORKSPACE>/src/main/scala/Main.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -counter/Counter.
	 -counter/Counter#
	 -counter/Counter().
	 -Counter.
	 -Counter#
	 -Counter().
	 -scala/Predef.Counter.
	 -scala/Predef.Counter#
	 -scala/Predef.Counter().
offset: 256
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

  val counter = Module(new @@Counter
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