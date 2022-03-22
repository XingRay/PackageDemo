package com.xingray.packagedemo;


import com.xingray.commandexecutor.CommandExecutor;
import com.xingray.commandexecutor.CommandResult;
import com.xingray.commandexecutor.JavaRuntimeCommandExecutor;
import com.xingray.packagedemo.command.JDepsCommand;
import com.xingray.packagedemo.command.JPackageCommand;

import java.nio.charset.Charset;
import java.util.List;

public class Make {
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
            jPackageCommand.setIcon("./src/main/resources/images/launcher.ico");
            jPackageCommand.setDest("./output/package");
            jPackageCommand.setName(name);
            jPackageCommand.setAppVersion("1.0.0");
            jPackageCommand.setCopyright("xingray.com");
            jPackageCommand.setDescription("java package demo");
            jPackageCommand.setVendor(vendor);
            jPackageCommand.setWinDirChooser(true);
            jPackageCommand.setWinShortcut(true);
            jPackageCommand.setInstallDir(vendor + "/" + name);
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

