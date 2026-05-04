error id: 771171E3839E1091472F40EC69F06C81
file://<WORKSPACE>/src/main/scala/counter/Counter.scala
### java.lang.AssertionError: assertion failed: file://<WORKSPACE>/src/main/scala/counter/Counter.scala: 235 >= 235

occurred in the presentation compiler.



action parameters:
offset: 235
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

  io.led := io.sw
}
@@
```


presentation compiler configuration:
Scala version: 2.12.21
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.12.21/scala-library-2.12.21.jar [exists ]
Options:





#### Error stacktrace:

```
scala.reflect.internal.util.SourceFile.position(SourceFile.scala:33)
	scala.tools.nsc.CompilationUnits$CompilationUnit.position(CompilationUnits.scala:133)
	scala.meta.internal.pc.WithCompilationUnit.<init>(WithCompilationUnit.scala:22)
	scala.meta.internal.pc.WithSymbolSearchCollector.<init>(PcCollector.scala:356)
	scala.meta.internal.pc.PcDocumentHighlightProvider.<init>(PcDocumentHighlightProvider.scala:12)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$documentHighlight$1(ScalaPresentationCompiler.scala:527)
	scala.meta.internal.pc.CompilerAccess.retryWithCleanCompiler(CompilerAccess.scala:182)
	scala.meta.internal.pc.CompilerAccess.$anonfun$withSharedCompiler$1(CompilerAccess.scala:155)
	scala.Option.map(Option.scala:230)
	scala.meta.internal.pc.CompilerAccess.withSharedCompiler(CompilerAccess.scala:154)
	scala.meta.internal.pc.CompilerAccess.$anonfun$withInterruptableCompiler$1(CompilerAccess.scala:92)
	scala.meta.internal.pc.CompilerAccess.$anonfun$onCompilerJobQueue$1(CompilerAccess.scala:209)
	scala.meta.internal.pc.CompilerJobQueue$Job.run(CompilerJobQueue.scala:152)
	java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	java.base/java.lang.Thread.run(Thread.java:1583)
```
#### Short summary: 

java.lang.AssertionError: assertion failed: file://<WORKSPACE>/src/main/scala/counter/Counter.scala: 235 >= 235