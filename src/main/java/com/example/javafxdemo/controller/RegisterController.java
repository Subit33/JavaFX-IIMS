package com.example.javafxdemo.controller;

import com.opencsv.CSVWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileWriter;
import java.io.IOException;

public class RegisterController {
    @FXML
    private TextField userName;
    @FXML
    private TextField email;
    @FXML
    private DatePicker dateOfBirth;
    @FXML
    private ComboBox<String> userGender;
    @FXML
    private TextField userNationality;
    @FXML
    private PasswordField userPassword;
    public void register(ActionEvent event){
        String name = userName.getText();
        String userEmail = email.getText();
        String birthYear = dateOfBirth.getValue().toString();
        String gender = userGender.getValue();
        String nationality = userNationality.getText();
        String password = userPassword.getText();
        String pathToCSV = "src/main/resources/userData.csv";
        if (userEmail.isEmpty()){
            email.getStyleClass().add("error-background");
        }
        try {
            FileWriter fileWriter = new FileWriter(pathToCSV, true);
            CSVWriter csvWriter = new CSVWriter(fileWriter);

            String[] csvData = {name, userEmail, birthYear, gender, nationality, password};
            csvWriter.writeNext(csvData);
            csvWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}

