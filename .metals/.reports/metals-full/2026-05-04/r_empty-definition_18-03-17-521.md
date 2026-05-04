error id: file://<WORKSPACE>/src/main/scala/counter/Counter.scala:led.
file://<WORKSPACE>/src/main/scala/counter/Counter.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -chisel3/io/led.
	 -chisel3/io/led#
	 -chisel3/io/led().
	 -io/led.
	 -io/led#
	 -io/led().
	 -scala/Predef.io.led.
	 -scala/Predef.io.led#
	 -scala/Predef.io.led().
offset: 220
uri: file://<WORKSPACE>/src/main/scala/counter/Counter.scala
text:
```scala
package counter

import chisel3._
import _root_.circt.stage.ChiselStage
import _root_.led.LED

class Counter extends Module {
  val io = IO(new Bundle {
    val sw = Input(Bool())
    val led = Output(Bool())
  })

  io.@@led := io.sw
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: 