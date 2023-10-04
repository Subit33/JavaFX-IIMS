package com.example.javafxdemo.controller;

import com.opencsv.CSVWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
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
    @FXML
    private Button registerBtn;
    @FXML
    private Label emailError;
    @FXML
    private ImageView userImage;

    private String imagePath;

    public void register(ActionEvent event) {
        String name = userName.getText();
        String userEmail = email.getText();
        String birthYear = dateOfBirth.getValue().toString();
        String gender = userGender.getValue();
        String nationality = userNationality.getText();
        String password = userPassword.getText();
        String pathToCSV = "src/main/resources/userData.csv";

        if (userEmail.isEmpty()) {
            emailError.setText("Email can't be empty");
            email.getStyleClass().add("error-background");
        }

        try {
            FileWriter fileWriter = new FileWriter(pathToCSV, true);
            CSVWriter csvWriter = new CSVWriter(fileWriter);

            String[] csvData = {name, userEmail, birthYear, gender, nationality, password, imagePath};
            csvWriter.writeNext(csvData);
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void uploadImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));

        File selectedImage = fileChooser.showOpenDialog(null);
        if (selectedImage != null) {
            Image image = new Image(selectedImage.toURI().toString());
            userImage.setImage(image);

            imagePath = selectedImage.getPath();
        }
    }
}
