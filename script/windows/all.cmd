java -version
mvn -version

mvn clean
mvn compile
mvn dependency:copy-dependencies

jdeps ^
--multi-release 17 ^
--print-module-deps ^
--ignore-missing-deps ^
--recursive ^
--add-modules=ALL-MODULE-PATH ^
--class-path .\output\dependency ^
--module-path .\output\dependency ^
.\target\classes


jpackage ^
--icon ./src/main/resources/images/launcher.ico ^
--dest ./output/package ^
--name PackageDemo ^
--app-version "1.0.0" ^
--copyright "xingray.com" ^
--description "java package demo" ^
--vendor "xingray" ^
--win-dir-chooser ^
--win-shortcut ^
--install-dir xingray/PackageDemo ^
--resource-dir ./src/main/resources ^
--module com.xingray.PackageDemo/com.xingray.packagedemo.app.Launcher ^
--add-modules java.base,java.desktop,java.scripting,jdk.jfr,jdk.unsupported ^
--module-path ./target/classes;./output/dependency ^