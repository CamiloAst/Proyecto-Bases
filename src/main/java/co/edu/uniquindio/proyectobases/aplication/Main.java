package co.edu.uniquindio.proyectobases.aplication;

import co.edu.uniquindio.proyectobases.connection.DatabaseConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    private Stage primaryStage;
    //private static Encuestadora encuestadora = new Encuestadora();
    private static DatabaseConnection conexion = new DatabaseConnection();

    @Override
    public void start(Stage primaryStage) throws IOException {

        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/Logo.png")));

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/MainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        primaryStage.setTitle("BioEssence");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(image);
        primaryStage.show();

    }

    public static void main(String[] args) {
        conexion.conectar();
        launch();
    }

/**    private void mostrarVentanaMain() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/MainView.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MainViewController mainController = loader.getController();
            mainController.setAplicacion(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }*/
}
