package co.edu.uniquindio.proyectobases.controller;

import co.edu.uniquindio.proyectobases.aplication.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class DashboardController {

    @FXML
    private Button btnDashboard;
    @FXML
    private Button btnProductos;
    @FXML
    private Button btnMetricas;
    @FXML
    private Button btnConfiguracion;

    @FXML
    void OnActionDashboard(ActionEvent event) throws IOException {

        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/Logo.png")));

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/Dashboard.fxml"));
        Parent root;
        root = fxmlLoader.load();
        //MainViewController mainController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("BioEssence");
        stage.getIcons().add(image);
        stage.setResizable(false);
        stage.show();

        Stage stage2 = (Stage) this.btnDashboard.getScene().getWindow();
        stage2.close();
    }

    @FXML
    void OnActionProductos(ActionEvent event) throws IOException {

        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/Logo.png")));

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/Productos.fxml"));
        Parent root;
        root = fxmlLoader.load();
        //MainViewController mainController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("BioEssence");
        stage.getIcons().add(image);
        stage.setResizable(false);
        stage.show();

        Stage stage2 = (Stage) this.btnProductos.getScene().getWindow();
        stage2.close();
    }

    @FXML
    void OnActionMetricas(ActionEvent event) throws IOException {

        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/Logo.png")));

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/Metricas.fxml"));
        Parent root;
        root = fxmlLoader.load();
        //MainViewController mainController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("BioEssence");
        stage.getIcons().add(image);
        stage.setResizable(false);
        stage.show();

        Stage stage2 = (Stage) this.btnMetricas.getScene().getWindow();
        stage2.close();
    }

    @FXML
    void OnActionConfiguracion(ActionEvent event) throws IOException {

        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/Logo.png")));

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/Configuracion.fxml"));
        Parent root;
        root = fxmlLoader.load();
        //MainViewController mainController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("BioEssence");
        stage.getIcons().add(image);
        stage.setResizable(false);
        stage.show();

        Stage stage2 = (Stage) this.btnConfiguracion.getScene().getWindow();
        stage2.close();
    }
}
