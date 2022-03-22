package com.xingray.packagedemo;

import com.xingray.packagedemo.command.CommandExecutor;
import com.xingray.packagedemo.command.CommandResult;
import com.xingray.packagedemo.command.JavaRuntimeCommandExecutor;

import java.nio.charset.Charset;
import java.util.List;

public class MakeApp {
    public static void main(String[] args) {
        try {

            CommandExecutor executor = new JavaRuntimeCommandExecutor(Charset.forName("GBK"), System.out::println);
            CommandResult commandResult = null;

            executor.execute("java -version");
            executor.execute("mvn.cmd -v");
            executor.execute("mvn.cmd dependency:copy-dependencies");

            JDepsCommand jdepsCommand = new JDepsCommand();
            jdepsCommand.setMultiRelease(17);
            jdepsCommand.setPrintModuleDeps(true);
            jdepsCommand.setIgnoreMissingDeps(true);
            jdepsCommand.setRecursive(true);
            jdepsCommand.setAddModules(List.of("ALL-MODULE-PATH"));
            jdepsCommand.setClassPath(List.of("./output/dependency"));
            jdepsCommand.setModulePath(List.of("./output/dependency"));
            commandResult = executor.executeCommand(jdepsCommand);
            System.out.println(commandResult);
            String addModules = commandResult.getResult();
            System.out.println("addModules:" + addModules);


            String name = "PackageDemo";
            String vendor = "xingray";

            JPackageCommand jPackageCommand = new JPackageCommand();
            jPackageCommand.setType("app-image");
            jPackageCommand.setIcon("./src/main/resources/images/launcher.ico");
            jPackageCommand.setDest("./output/package");
            jPackageCommand.setName(name);
            jPackageCommand.setAppVersion("1.0.0");
            jPackageCommand.setCopyright("xingray.com");
            jPackageCommand.setDescription("java package demo");
            jPackageCommand.setVendor(vendor);
            jPackageCommand.setResourceDir("./src/main/resources");
            jPackageCommand.setModule("com.xingray.PackageDemo/com.xingray.packagedemo.app.Launcher");
            jPackageCommand.setAddModules(addModules);
            jPackageCommand.setModulePath(List.of("./target/classes", "./output/dependency"));

            commandResult = executor.executeCommand(jPackageCommand);
            System.out.println(commandResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

