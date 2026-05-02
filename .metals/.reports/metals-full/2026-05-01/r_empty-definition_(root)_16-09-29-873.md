error id: file:///C:/Users/micha/Desktop/chiseltest/src/main/scala/led/LED.scala:local0
file:///C:/Users/micha/Desktop/chiseltest/src/main/scala/led/LED.scala
empty definition using pc, found symbol in pc: 
found definition using semanticdb; symbol local0
empty definition using fallback
non-local guesses:

offset: 145
uri: file:///C:/Users/micha/Desktop/chiseltest/src/main/scala/led/LED.scala
text:
```scala
package led

import chisel3._
import _root_.circt.stage.ChiselStage

class LED extends Module {
  val io = IO(new Bundle {
    val in = 
    val @@out = Output(Bool())
  })

  val state = RegInit(Bool(), true.B)

  state := !state
  io.out := state
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: 