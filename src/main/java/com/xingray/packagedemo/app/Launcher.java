package com.xingray.packagedemo.app;

import javafx.application.Application;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Launcher {
    public static void main(String[] args) throws IOException {
        System.out.println("hello package");
        File file = new File("app.log");
        if (!file.exists()) {
            file.createNewFile();
        }
        Files.writeString(file.toPath(), "start:" + LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE) + "\n", StandardOpenOption.APPEND);
        try {
            Application.launch(FxApplication.class, args);
        } catch (Exception e) {
            Files.writeString(file.toPath(), "error at:" + LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE) + "\n" + e.getMessage(), StandardOpenOption.APPEND);
        }
    }
}
