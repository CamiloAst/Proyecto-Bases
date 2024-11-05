module co.edu.uniquindio.proyectobases {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens co.edu.uniquindio.proyectobases.controller to javafx.fxml;
    exports co.edu.uniquindio.proyectobases.aplication;
}