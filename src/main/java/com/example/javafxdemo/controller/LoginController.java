package com.example.javafxdemo.controller;

import com.example.javafxdemo.Application;
import com.example.javafxdemo.model.LoginModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    LoginModel loginModel;
    @FXML
    private TextField userEmail;
    @FXML
    private PasswordField userPassword;
    @FXML
    private Label resultLabel;

    private Application application;

    public LoginController(){

    }

    public LoginController(Application application){
        this.application = application;
    }

    public void setApplication(Application application){
        this.application = application;
    }
    public void login(ActionEvent event) throws IOException {
        String email = userEmail.getText();
        String password = userPassword.getText();

        if (loginModel.loginAuthentication(email, password)){
            resultLabel.setText("Login Successful!!");
            resultLabel.getStyleClass().clear();
            resultLabel.getStyleClass().add("login-success");
            application.registerScene();
        }
        else {
            resultLabel.setText("Invalid email or password");
            resultLabel.getStyleClass().clear();
            resultLabel.getStyleClass().add("login-error");
        }
    }

}