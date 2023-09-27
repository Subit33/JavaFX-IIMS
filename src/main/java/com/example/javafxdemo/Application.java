package com.example.javafxdemo;

import com.example.javafxdemo.controller.LoginController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;

public class Application extends javafx.application.Application {
    private Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        loginScene();
    }

    public void loginScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        scene.getStylesheets().add(getClass().getResource("css/login.css").toExternalForm());
        stage.setTitle("Login!");
        stage.setScene(scene);
        stage.show();

        LoginController loginController = fxmlLoader.getController();
        loginController.setApplication(this);

    }

    public void registerScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("register-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 400);
        scene.getStylesheets().add(getClass().getResource("css/register.css").toExternalForm());
        stage.setTitle("Register!");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}