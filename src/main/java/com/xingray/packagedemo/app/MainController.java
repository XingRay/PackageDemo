package com.xingray.packagedemo.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    public Label welcomeText;

    @FXML
    public void onHelloButtonClick(ActionEvent actionEvent) {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
