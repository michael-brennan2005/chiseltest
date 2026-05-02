error id: file:///C:/Users/micha/Desktop/chiseltest/src/main/scala/Main.scala:led/LED.
file:///C:/Users/micha/Desktop/chiseltest/src/main/scala/Main.scala
empty definition using pc, found symbol in pc: led/LED.
found definition using semanticdb; symbol led/LED#
empty definition using fallback
non-local guesses:

offset: 49
uri: file:///C:/Users/micha/Desktop/chiseltest/src/main/scala/Main.scala
text:
```scala
import _root_.circt.stage.ChiselStage
import led.@@LED

object Main extends App {

  ChiselStage.emitSystemVerilogFile(
    new LED,
    firtoolOpts = Array(
      "-disable-all-randomization",
      "-strip-debug-info",
      "-default-layer-specialization=enable"
    )
  )
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: led/LED.