package com.example.javafxdemo.controller;

import com.example.javafxdemo.Application;
import com.example.javafxdemo.model.LoginModel;
import com.opencsv.CSVReader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.FileReader;
import java.io.IOException;

public class LoginController {

    TextArea textArea;
    LoginModel loginModel;
    @FXML
    private TextField userEmail;
    @FXML
    private PasswordField userPassword;
    @FXML
    private Label resultLabel;

    private Application application;

    public LoginController() {

    }

    public LoginController(Application application) {
        this.application = application;

    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public void login(ActionEvent event) throws IOException {
        String email = userEmail.getText();
        String password = userPassword.getText();
        if (validateLogin(email, password)) {
            resultLabel.setText("Login Successful!!");
            resultLabel.getStyleClass().clear();
            resultLabel.getStyleClass().add("login-success");
            application.registerScene();
        } else {
            resultLabel.setText("Invalid email or password");
            resultLabel.getStyleClass().clear();
            resultLabel.getStyleClass().add("login-error");
        }
    }

    public boolean validateLogin(String email, String password) {
        String csvPath = "src/main/resources/userData.csv";
        try (CSVReader reader = new CSVReader(new FileReader(csvPath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line.length == 6 && line[1].equals(email) && line[5].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}