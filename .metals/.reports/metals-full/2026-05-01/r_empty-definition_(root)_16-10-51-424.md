error id: file:///C:/Users/micha/Desktop/chiseltest/src/main/scala/led/LED.scala:led/LED#state.
file:///C:/Users/micha/Desktop/chiseltest/src/main/scala/led/LED.scala
empty definition using pc, found symbol in pc: 
found definition using semanticdb; symbol led/LED#state.
empty definition using fallback
non-local guesses:

offset: 343
uri: file:///C:/Users/micha/Desktop/chiseltest/src/main/scala/led/LED.scala
text:
```scala
package led

import chisel3._
import _root_.circt.stage.ChiselStage

class LED extends Module {
  val io = IO(new Bundle {
    val in  = Input(Bool())
    val out = Output(Bool())
  })

  val state = RegInit(Bool(), true.B)

  state := !state
  // io.in | state | io.out
  // T   F  T
  // T  T   T
  // F  F   F
  // F  T   T
  io.out := io. @@state
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: 