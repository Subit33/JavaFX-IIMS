module com.example.javafxdemo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    requires opencsv;

    opens com.example.javafxdemo to javafx.fxml;
    exports com.example.javafxdemo;
    exports com.example.javafxdemo.controller;
    opens com.example.javafxdemo.controller to javafx.fxml;
    exports com.example.javafxdemo.model;
    opens com.example.javafxdemo.model to javafx.fxml;
}