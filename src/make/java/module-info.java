module PackageDemo {
    requires com.xingray.commandexecutor;

    opens com.xingray.packagedemo.command to com.xingray.commandexecutor;
}