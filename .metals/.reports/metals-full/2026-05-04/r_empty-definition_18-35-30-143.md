error id: file://<WORKSPACE>/src/main/scala/Main.scala:App#
file://<WORKSPACE>/src/main/scala/Main.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -chisel3/App#
	 -App#
	 -scala/Predef.App#
offset: 140
uri: file://<WORKSPACE>/src/main/scala/Main.scala
text:
```scala
import chisel3._
import _root_.circt.stage.ChiselStage
import led.LEDCircuit
import counter.Counter

type Top = Coun
object Main extends App@@ {
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