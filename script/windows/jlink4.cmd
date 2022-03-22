jlink ^
--add-modules java.base,java.desktop,java.instrument,java.logging,java.management,java.naming,java.scripting,jdk.compiler,jdk.jfr,jdk.unsupported ^
--module-path ./output/dependency;./target/classes ^
--output .\output\runtime