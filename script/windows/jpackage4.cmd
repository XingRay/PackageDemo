jpackage ^
--verbose ^
--type app-image ^
--icon ./src/main/resources/images/launcher.ico ^
--dest ./output/package ^
--name PackageDemo ^
--module com.xingray.PackageDemo/com.xingray.packagedemo.app.Launcher ^
--add-modules java.base ^
--module-path ./target/classes ^