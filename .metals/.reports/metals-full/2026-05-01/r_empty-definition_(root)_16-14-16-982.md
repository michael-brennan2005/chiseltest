error id: file:///C:/Users/micha/Desktop/chiseltest/src/main/scala/led/LEDCircuit.scala:led/AND#io.
file:///C:/Users/micha/Desktop/chiseltest/src/main/scala/led/LEDCircuit.scala
empty definition using pc, found symbol in pc: 
found definition using semanticdb; symbol led/AND#io.
empty definition using fallback
non-local guesses:

offset: 322
uri: file:///C:/Users/micha/Desktop/chiseltest/src/main/scala/led/LEDCircuit.scala
text:
```scala
package led

import chisel3._
import _root_.circt.stage.ChiselStage
import _root_.led.LED

class LEDCircuit extends Module {
  val io = IO(new Bundle {
    val in1 = Input(Bool())
    val in2 = Input(Bool())
    val out = Output(Bool())
  })

  val led = Module(new LED)
  val and = Mnew AND

  and.io.in1 := io.in1
  and.@@io.in2 := io.in2

  led.io.in := and.io.out
  io.out := led.io.out
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: 