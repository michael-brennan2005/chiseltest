error id: file://<WORKSPACE>/src/main/scala/counter/Counter.scala:`<error>`#`<error>`.
file://<WORKSPACE>/src/main/scala/counter/Counter.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -chisel3/Output.
	 -chisel3/Output#
	 -chisel3/Output().
	 -Output.
	 -Output#
	 -Output().
	 -scala/Predef.Output.
	 -scala/Predef.Output#
	 -scala/Predef.Output().
offset: 194
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
    val led = @@Output(Bool())
  })

  io
  io.led := io.sw
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: 