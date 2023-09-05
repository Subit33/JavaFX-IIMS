package com.example.javafxdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField userEmail;
    @FXML
    private TextField userPassword;
    @FXML
    private Label resultLabel;
    LoginModel loginModel;

    public void login(ActionEvent event){
        String email = userEmail.getText();
        String password = userPassword.getText();

        if (loginModel.loginAuthentication(email, password)){
            resultLabel.setText("Login Successful!!");
            resultLabel.getStyleClass().clear();
            resultLabel.getStyleClass().add("login-success");
        }
        else {
            resultLabel.setText("Invalid email or password");
            resultLabel.getStyleClass().clear();
            resultLabel.getStyleClass().add("login-error");
        }
    }

}