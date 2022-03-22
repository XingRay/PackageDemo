package com.xingray.packagedemo.command;

import java.io.File;

public interface CommandExecutor {
    CommandResult executeSplitCmd(String[] splitCmd, String[] envp, File dir) throws Exception;

    default CommandResult executeSplitCmd(String[] splitCmd) throws Exception {
        return executeSplitCmd(splitCmd, null, null);
    }

    default CommandResult execute(String cmd) throws Exception {
        return executeSplitCmd(CommandUtil.splitCmd(cmd));
    }

    default CommandResult executeCommand(Object command) throws Exception {
        return executeSplitCmd(CommandUtil.commandToStringArray(command));
    }
}
