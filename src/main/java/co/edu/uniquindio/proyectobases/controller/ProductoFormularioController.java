package co.edu.uniquindio.proyectobases.controller;

import co.edu.uniquindio.proyectobases.aplication.model.Producto;
import co.edu.uniquindio.proyectobases.connection.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProductoFormularioController {
    private DatabaseConnection databaseConnection;

    @FXML
    private TextField idProductoField;

    @FXML
    private TextField nombreField;

    @FXML
    private TextField precioField;

    @FXML
    private TextField idCategoriaField;

    @FXML
    private TextField idDescripcionPTOField;

    private Producto producto; // Producto que se va a editar o agregar

    private boolean guardado = false;

    public void initialize() {
        databaseConnection = new DatabaseConnection();
    }

    public void setProducto(Producto producto) {
        this.producto = producto;

        if (producto != null) {
            idProductoField.setText(String.valueOf(producto.getIdProducto()));
            nombreField.setText(producto.getNombre());
            precioField.setText(String.valueOf(producto.getPrecio()));
            idCategoriaField.setText(String.valueOf(producto.getCategoria()));
            idDescripcionPTOField.setText(String.valueOf(producto.getDescripcionPTO()));
        }
    }

    public Producto getProducto() {
        return producto;
    }

    public boolean isGuardado() {
        return guardado;
    }

    @FXML
    private void handleGuardar(ActionEvent event) {
        try {
            if (producto == null) {
                producto = new Producto();
            }
            producto.setIdProducto(Integer.parseInt(idProductoField.getText()));
            producto.setNombre(nombreField.getText());
            producto.setPrecio(Float.parseFloat(precioField.getText()));
            //producto.setCategoria(Integer.parseInt(idCategoriaField.getText()));
            //producto.setDescripcionPTO(Integer.parseInt(idDescripcionPTOField.getText()));

            guardado = true;

            Stage stage = (Stage) idProductoField.getScene().getWindow();
           // databaseConnection.guardarProducto(producto);

            stage.close();
        } catch (NumberFormatException e) {
            // Manejo de errores de entrada inválida
            e.printStackTrace();
        }
    }

    @FXML
    private void handleCancelar(ActionEvent event) {
        Stage stage = (Stage) idProductoField.getScene().getWindow();
        stage.close();
    }
}
