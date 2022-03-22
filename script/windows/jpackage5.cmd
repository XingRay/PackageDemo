jpackage ^
--verbose ^
--type app-image ^
--icon ./src/main/resources/images/launcher.ico ^
--dest ./output/package ^
--name PackageDemo ^
--module com.xingray.PackageDemo/com.xingray.packagedemo.app.Launcher ^
--add-modules java.base,java.desktop,java.scripting,jdk.jfr,jdk.unsupported ^
--module-path ./target/classes;./output/dependency ^