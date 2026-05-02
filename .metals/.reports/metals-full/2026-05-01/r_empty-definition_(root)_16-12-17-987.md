error id: file:///C:/Users/micha/Desktop/chiseltest/src/main/scala/led/LEDCircuit.scala:
file:///C:/Users/micha/Desktop/chiseltest/src/main/scala/led/LEDCircuit.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -chisel3/out.
	 -chisel3/out#
	 -chisel3/out().
	 -out.
	 -out#
	 -out().
	 -scala/Predef.out.
	 -scala/Predef.out#
	 -scala/Predef.out().
offset: 182
uri: file:///C:/Users/micha/Desktop/chiseltest/src/main/scala/led/LEDCircuit.scala
text:
```scala
package led

import chisel3._
import _root_.circt.stage.ChiselStage

class LEDCircuit extends Module {
  val io = IO(new Bundle {
    val in1 = Input(Bool())
    val in2 = I
    val @@out = Output(Bool())
  })

  val state = RegInit(Bool(), true.B)

  state := !state
  io.out := io.in | state
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: 