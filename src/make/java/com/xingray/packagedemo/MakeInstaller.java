package com.xingray.packagedemo;


import com.xingray.commandexecutor.CommandExecutor;
import com.xingray.commandexecutor.CommandResult;
import com.xingray.commandexecutor.JavaRuntimeCommandExecutor;
import com.xingray.javacommand.JDepsCommand;
import com.xingray.javacommand.JPackageCommand;

import java.nio.charset.Charset;
import java.util.List;

public class MakeInstaller {

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

            JPackageCommand jPackageCommand = new JPackageCommand();
            jPackageCommand.setIcon(PackageConfig.ICON_PATH);
            jPackageCommand.setDest(PackageConfig.OUTPUT_PATH);
            jPackageCommand.setName(PackageConfig.NAME);
            jPackageCommand.setAppVersion(PackageConfig.APP_VERSION);
            jPackageCommand.setCopyright(PackageConfig.COPYRIGHT);
            jPackageCommand.setDescription(PackageConfig.DESCRIPTION);
            jPackageCommand.setVendor(PackageConfig.VENDOR);
            jPackageCommand.setWinDirChooser(true);
            jPackageCommand.setWinShortcut(true);
            jPackageCommand.setInstallDir(PackageConfig.VENDOR + "/" + PackageConfig.NAME);
            jPackageCommand.setResourceDir("./src/main/resources");
            jPackageCommand.setModule(PackageConfig.MODULE_AND_MAIN_CLASS);
            jPackageCommand.setAddModules(addModules);
            jPackageCommand.setModulePath(List.of("./target/classes", "./output/dependency"));

            commandResult = executor.executeCommand(jPackageCommand);
            System.out.println(commandResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

