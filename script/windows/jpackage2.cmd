jpackage ^
--verbose ^
--type app-image ^
--win-console ^
--runtime-image ./output/runtime ^
--icon ./src/main/resources/images/launcher.ico ^
--dest ./output/package ^
--temp output/package/tmp ^
--app-version 1.0.0 ^
--copyright "xingray.com" ^
--description "java package demo" ^
--name PackageDemo ^
--vendor xingray ^
--module com.xingray.PackageDemo/com.xingray.packagedemo.app.Launcher ^
--resource-dir ./src/main/resources ^
--module-path ./target/classes;./output/dependency ^
--input  ./target/classes ^