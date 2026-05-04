error id: file://<WORKSPACE>/src/main/scala/counter/Counter.scala:LED.
file://<WORKSPACE>/src/main/scala/counter/Counter.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -chisel3/LED.
	 -chisel3/LED#
	 -chisel3/LED().
	 -_root_/led/LED.
	 -_root_/led/LED#
	 -_root_/led/LED().
	 -LED.
	 -LED#
	 -LED().
	 -scala/Predef.LED.
	 -scala/Predef.LED#
	 -scala/Predef.LED().
offset: 52
uri: file://<WORKSPACE>/src/main/scala/counter/Counter.scala
text:
```scala
package counter

import chisel3._
import _root_.led.@@LED

class Counter extends Module {
  val io = IO(new Bundle {
    val sw0 = Input(Bool())
    val sw1 = Input(Bool())
    val led = Output(Bool())
  })

  io.led := io.sw0 & io.sw1
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: 