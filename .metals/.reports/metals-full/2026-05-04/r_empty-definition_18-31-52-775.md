error id: file://<WORKSPACE>/src/main/scala/Main.scala:emitSystemVerilogFile.
file://<WORKSPACE>/src/main/scala/Main.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -_root_/circt/stage/ChiselStage.emitSystemVerilogFile.
	 -_root_/circt/stage/ChiselStage.emitSystemVerilogFile#
	 -_root_/circt/stage/ChiselStage.emitSystemVerilogFile().
	 -ChiselStage.emitSystemVerilogFile.
	 -ChiselStage.emitSystemVerilogFile#
	 -ChiselStage.emitSystemVerilogFile().
	 -scala/Predef.ChiselStage.emitSystemVerilogFile.
	 -scala/Predef.ChiselStage.emitSystemVerilogFile#
	 -scala/Predef.ChiselStage.emitSystemVerilogFile().
offset: 136
uri: file://<WORKSPACE>/src/main/scala/Main.scala
text:
```scala
import _root_.circt.stage.ChiselStage
import led.LEDCircuit
import counter.Counter

class Top e
object Main extends App {
  ChiselStage.@@emitSystemVerilogFile(
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