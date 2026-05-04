error id: file://<WORKSPACE>/src/main/scala/Main.scala:LEDCircuit.
file://<WORKSPACE>/src/main/scala/Main.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -led/LEDCircuit.
	 -led/LEDCircuit#
	 -led/LEDCircuit().
	 -LEDCircuit.
	 -LEDCircuit#
	 -LEDCircuit().
	 -scala/Predef.LEDCircuit.
	 -scala/Predef.LEDCircuit#
	 -scala/Predef.LEDCircuit().
offset: 49
uri: file://<WORKSPACE>/src/main/scala/Main.scala
text:
```scala
import _root_.circt.stage.ChiselStage
import led.@@LEDCircuit
import counter.Counter

class Top extends 
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