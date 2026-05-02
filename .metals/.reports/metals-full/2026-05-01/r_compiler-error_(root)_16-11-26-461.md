error id: 52321D261DF990A7A14CA77B45C7AE7F
file:///C:/Users/micha/Desktop/chiseltest/src/main/scala/led/AND.scala
### java.lang.AssertionError: assertion failed: file:///C:/Users/micha/Desktop/chiseltest/src/main/scala/led/AND.scala: 13 >= 13

occurred in the presentation compiler.



action parameters:
offset: 13
uri: file:///C:/Users/micha/Desktop/chiseltest/src/main/scala/led/AND.scala
text:
```scala
package led

@@
```


presentation compiler configuration:
Scala version: 2.13.18
Classpath:
<WORKSPACE>\.bloop\root\bloop-bsp-clients-classes\classes-Metals-qUL3qqzNTnum-fKJvG8jcw== [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\com\sourcegraph\semanticdb-javac\0.11.2\semanticdb-javac-0.11.2.jar [exists ], <HOME>\scoop\persist\coursier\cache\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.18\scala-library-2.13.18.jar [exists ], <HOME>\scoop\persist\coursier\cache\https\repo1.maven.org\maven2\org\chipsalliance\chisel_2.13\7.7.0\chisel_2.13-7.7.0.jar [exists ], <HOME>\scoop\persist\coursier\cache\https\repo1.maven.org\maven2\com\github\scopt\scopt_2.13\4.1.0\scopt_2.13-4.1.0.jar [exists ], <HOME>\scoop\persist\coursier\cache\https\repo1.maven.org\maven2\org\apache\commons\commons-text\1.15.0\commons-text-1.15.0.jar [exists ], <HOME>\scoop\persist\coursier\cache\https\repo1.maven.org\maven2\com\lihaoyi\os-lib_2.13\0.10.7\os-lib_2.13-0.10.7.jar [exists ], <HOME>\scoop\persist\coursier\cache\https\repo1.maven.org\maven2\io\github\json4s\json4s-native_2.13\4.1.0\json4s-native_2.13-4.1.0.jar [exists ], <HOME>\scoop\persist\coursier\cache\https\repo1.maven.org\maven2\io\github\alexarchambault\data-class_2.13\0.2.7\data-class_2.13-0.2.7.jar [exists ], <HOME>\scoop\persist\coursier\cache\https\repo1.maven.org\maven2\org\scala-lang\scala-reflect\2.13.18\scala-reflect-2.13.18.jar [exists ], <HOME>\scoop\persist\coursier\cache\https\repo1.maven.org\maven2\com\lihaoyi\upickle_2.13\3.3.1\upickle_2.13-3.3.1.jar [exists ], <HOME>\scoop\persist\coursier\cache\https\repo1.maven.org\maven2\org\chipsalliance\firtool-resolver_2.13\2.0.1\firtool-resolver_2.13-2.0.1.jar [exists ], <HOME>\scoop\persist\coursier\cache\https\repo1.maven.org\maven2\org\apache\commons\commons-lang3\3.20.0\commons-lang3-3.20.0.jar [exists ], <HOME>\scoop\persist\coursier\cache\https\repo1.maven.org\maven2\com\lihaoyi\geny_2.13\1.1.1\geny_2.13-1.1.1.jar [exists ], <HOME>\scoop\persist\coursier\cache\https\repo1.maven.org\maven2\io\github\json4s\json4s-core_2.13\4.1.0\json4s-core_2.13-4.1.0.jar [exists ], <HOME>\scoop\persist\coursier\cache\https\repo1.maven.org\maven2\io\github\json4s\json4s-native-core_2.13\4.1.0\json4s-native-core_2.13-4.1.0.jar [exists ], <HOME>\scoop\persist\coursier\cache\https\repo1.maven.org\maven2\com\lihaoyi\ujson_2.13\3.3.1\ujson_2.13-3.3.1.jar [exists ], <HOME>\scoop\persist\coursier\cache\https\repo1.maven.org\maven2\com\lihaoyi\upack_2.13\3.3.1\upack_2.13-3.3.1.jar [exists ], <HOME>\scoop\persist\coursier\cache\https\repo1.maven.org\maven2\com\lihaoyi\upickle-implicits_2.13\3.3.1\upickle-implicits_2.13-3.3.1.jar [exists ], <HOME>\scoop\persist\coursier\cache\https\repo1.maven.org\maven2\org\scala-lang\modules\scala-xml_2.13\2.2.0\scala-xml_2.13-2.2.0.jar [exists ], <HOME>\scoop\persist\coursier\cache\https\repo1.maven.org\maven2\org\scala-lang\modules\scala-collection-compat_2.13\2.11.0\scala-collection-compat_2.13-2.11.0.jar [exists ], <HOME>\scoop\persist\coursier\cache\https\repo1.maven.org\maven2\io\github\json4s\json4s-ast_2.13\4.1.0\json4s-ast_2.13-4.1.0.jar [exists ], <HOME>\scoop\persist\coursier\cache\https\repo1.maven.org\maven2\io\github\json4s\json4s-scalap_2.13\4.1.0\json4s-scalap_2.13-4.1.0.jar [exists ], <HOME>\scoop\persist\coursier\cache\https\repo1.maven.org\maven2\com\lihaoyi\upickle-core_2.13\3.3.1\upickle-core_2.13-3.3.1.jar [exists ]
Options:
-language:reflectiveCalls -deprecation -feature -Xcheckinit -Ymacro-annotations -Yrangepos -Xplugin-require:semanticdb




#### Error stacktrace:

```
scala.reflect.internal.util.SourceFile.position(SourceFile.scala:34)
	scala.tools.nsc.CompilationUnits$CompilationUnit.position(CompilationUnits.scala:136)
	scala.meta.internal.pc.WithCompilationUnit.<init>(WithCompilationUnit.scala:22)
	scala.meta.internal.pc.WithSymbolSearchCollector.<init>(PcCollector.scala:356)
	scala.meta.internal.pc.PcDocumentHighlightProvider.<init>(PcDocumentHighlightProvider.scala:12)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$documentHighlight$1(ScalaPresentationCompiler.scala:527)
	scala.meta.internal.pc.CompilerAccess.retryWithCleanCompiler(CompilerAccess.scala:182)
	scala.meta.internal.pc.CompilerAccess.$anonfun$withSharedCompiler$1(CompilerAccess.scala:155)
	scala.Option.map(Option.scala:242)
	scala.meta.internal.pc.CompilerAccess.withSharedCompiler(CompilerAccess.scala:154)
	scala.meta.internal.pc.CompilerAccess.$anonfun$withInterruptableCompiler$1(CompilerAccess.scala:92)
	scala.meta.internal.pc.CompilerAccess.$anonfun$onCompilerJobQueue$1(CompilerAccess.scala:209)
	scala.meta.internal.pc.CompilerJobQueue$Job.run(CompilerJobQueue.scala:152)
	java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	java.base/java.lang.Thread.run(Thread.java:1570)
```
#### Short summary: 

java.lang.AssertionError: assertion failed: file:///C:/Users/micha/Desktop/chiseltest/src/main/scala/led/AND.scala: 13 >= 13