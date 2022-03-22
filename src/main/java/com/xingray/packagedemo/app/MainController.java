package com.xingray.packagedemo.app;

import com.xingray.packagedemo.app.domain.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    public Label welcomeText;

    @FXML
    public void onHelloButtonClick(ActionEvent actionEvent) {
        Student student = new Student();
        student.setId(1L);
        student.setAge(18);
        student.setName("jack");

        welcomeText.setText("student:" + student);
    }
}
