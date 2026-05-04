error id: file://<WORKSPACE>/src/main/scala/counter/Counter.scala:IO.
file://<WORKSPACE>/src/main/scala/counter/Counter.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -chisel3/IO.
	 -chisel3/IO#
	 -chisel3/IO().
	 -IO.
	 -IO#
	 -IO().
	 -scala/Predef.IO.
	 -scala/Predef.IO#
	 -scala/Predef.IO().
offset: 137
uri: file://<WORKSPACE>/src/main/scala/counter/Counter.scala
text:
```scala
package counter

import chisel3._
import _root_.circt.stage.ChiselStage
import _root_.led.LED

class Counter extends Module {
  val io = @@IO(new Bundle {
    val sw0 = Input(Bool())
    val led = Output(Bool())
  })

  io.led := !io.sw
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: 