jlink ^
--add-modules java.base,java.desktop,java.scripting,jdk.jfr,jdk.unsupported ^
--module-path ./output/dependency;./target/classes ^
--output .\output\runtime