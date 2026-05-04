error id: file://<WORKSPACE>/src/main/scala/Main.scala:`<error>`#`<error>`.
file://<WORKSPACE>/src/main/scala/Main.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -_root_/circt/stage/ChiselStage.
	 -ChiselStage.
	 -scala/Predef.ChiselStage.
offset: 112
uri: file://<WORKSPACE>/src/main/scala/Main.scala
text:
```scala
import _root_.circt.stage.ChiselStage
import led.LEDCircuit
import counter.Counter

object Main extends App {
  @@ChiselStage.emitSystemVerilogFile(
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