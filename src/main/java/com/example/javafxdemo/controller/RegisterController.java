package com.example.javafxdemo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class RegisterController {
    @FXML
    private ComboBox userGender;
    @FXML
    private Label resultLabel;

    public void register(ActionEvent event){
        String selectedGender = (String) userGender.getValue();
        resultLabel.setText(selectedGender);
    }
}
