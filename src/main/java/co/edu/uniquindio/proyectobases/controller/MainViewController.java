package co.edu.uniquindio.proyectobases.controller;

import co.edu.uniquindio.proyectobases.aplication.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static co.edu.uniquindio.proyectobases.controller.AppController.INSTANCE;

public class MainViewController {

    @FXML
    private TextField tfUsuario;
    @FXML
    private PasswordField pfPassword;
    @FXML
    private Button btnIniciar;

    @FXML
    void OnActionIniciar(ActionEvent event) throws IOException {
        if (tfUsuario.getText().isBlank() || pfPassword.getText().isBlank()) {
            System.out.println("¡¡ Debe ingresar un usuario y una contraseña !!");
            tfUsuario.requestFocus();
        } else if (!INSTANCE.getDatabaseConnection().verificarDatosUsuario(tfUsuario.getText(), Integer.parseInt(pfPassword.getText()))) {
            System.out.println("¡¡ Usuario y/o Contraseña incorrectos !!");
            tfUsuario.requestFocus();
        } else {

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

            Stage stage2 = (Stage) this.btnIniciar.getScene().getWindow();
            INSTANCE.setUsuario(INSTANCE.getDatabaseConnection().buscarAfiliado(tfUsuario.getText(), pfPassword.getText()));
            stage2.close();
        }
    }

    @FXML
    public void Salir(KeyEvent event) {
        if (event.getCode() == KeyCode.ESCAPE) {
            System.exit(0);
        }

    }
}
