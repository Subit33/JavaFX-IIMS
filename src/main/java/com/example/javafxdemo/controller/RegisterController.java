package com.example.javafxdemo.controller;

import com.example.javafxdemo.Application;
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

    private Application application;
    private boolean isFormValid;

    @FXML
    private Label imageId;
    private String imagePath;

    public void setApplication(Application application) {
        this.application = application;
    }

    public void register(ActionEvent event) throws IOException {
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
            isFormValid = false;
        }
        else {
            isFormValid = true;
        }

        if (isFormValid) {
            try {
                FileWriter fileWriter = new FileWriter(pathToCSV, true);
                CSVWriter csvWriter = new CSVWriter(fileWriter);

                String[] csvData = {name, userEmail, birthYear, gender, nationality, password, imagePath};
                csvWriter.writeNext(csvData);
                csvWriter.close();
                clearFormElements();
            } catch (IOException e) {
                e.printStackTrace();
            }
            application.loginScene();
        }
    }

    public void uploadImage(ActionEvent event) {
        // FileChooser class to choose files
        FileChooser fileChooser = new FileChooser();
        // FileChooser ExtensionFilters to add filters to specific files only
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));

        // File class to capture the selected image as a file
        // File class has access to file details like file name, file location, file size,
        // file url and so on...
        File selectedImage = fileChooser.showOpenDialog(null);
        if (selectedImage != null) {

            // Image class to process the url as an image
            Image image = new Image(selectedImage.toURI().toString());
            // Showing the name of the image after upload
            imageId.setText(selectedImage.getName());
            // Displaying the image after upload
            userImage.setImage(image);
            // Imagepath will later be added into csv which is a file uri
            imagePath = selectedImage.getPath();
        }
    }

    public void clearFormElements(){
        userName.clear();
        email.clear();
        dateOfBirth.setValue(null);
        userGender.getSelectionModel().clearSelection();
        userPassword.clear();
        userNationality.clear();
        userImage.setImage(null);
        imageId.setText("");

    }
}
