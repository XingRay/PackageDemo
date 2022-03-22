package com.xingray.packagedemo.command;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProcessBuilderReflection {

    private static Method environmentMethod;
    private static NoSuchMethodException initException;

    static {
        try {
            environmentMethod = ProcessBuilder.class.getDeclaredMethod("environment", String[].class);
            environmentMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            initException = e;
        }
    }

    private final ProcessBuilder processBuilder;

    public ProcessBuilderReflection(ProcessBuilder processBuilder) {
        this.processBuilder = processBuilder;
    }

    public ProcessBuilder environment(String[] envp) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (environmentMethod == null) {
            throw initException;
        }
        return (ProcessBuilder) environmentMethod.invoke(this.processBuilder, envp);
    }
}
