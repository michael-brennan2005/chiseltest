error id: file:///C:/Users/micha/Desktop/chiseltest/src/main/scala/led/LEDCircuit.scala:out
file:///C:/Users/micha/Desktop/chiseltest/src/main/scala/led/LEDCircuit.scala
empty definition using pc, found symbol in pc: out
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -chisel3/and/io/out.
	 -chisel3/and/io/out#
	 -chisel3/and/io/out().
	 -and/io/out.
	 -and/io/out#
	 -and/io/out().
	 -scala/Predef.and.io.out.
	 -scala/Predef.and.io.out#
	 -scala/Predef.and.io.out().
offset: 339
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

  val led = new LED
  val and = new AND

  and.io.in1 := io.in1
  and.io.in2 := io.in2
  and.io.@@out
  val state = RegInit(Bool(), true.B)

  state := !state
  io.out := io.in | state
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: out