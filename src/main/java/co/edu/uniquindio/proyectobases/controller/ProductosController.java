package co.edu.uniquindio.proyectobases.controller;

import co.edu.uniquindio.proyectobases.aplication.model.Producto;
import co.edu.uniquindio.proyectobases.connection.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static co.edu.uniquindio.proyectobases.controller.AppController.INSTANCE;

public class ProductosController {


    public Button btnAgregarProducto;
    public Button btnEditarProducto;
    public Button btnEliminarProducto;
    public TableView<Producto> tablaProductos;
    public TableColumn<Producto, Integer> columnaIdProducto;
    public TableColumn<Producto, String> columnaNombre;
    public TableColumn<Producto, Float> columnaPrecio;
    public TableColumn<Producto, Integer> columnaIdCategoria;
    public TableColumn<Producto, Integer> columnaIdDescripcionPTO;

    private ObservableList<Producto> listaProductos;

    public void initialize() {
        columnaIdProducto.setCellValueFactory(new PropertyValueFactory<>("idProducto"));
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        columnaIdCategoria.setCellValueFactory(new PropertyValueFactory<>("idCategoria"));
        columnaIdDescripcionPTO.setCellValueFactory(new PropertyValueFactory<>("idDescripcionPTO"));

        cargarProductosEnTabla();
    }

    public void handleAgregarProducto(ActionEvent actionEvent) {
        abrirFormulario(null);

    }

    public void handleEditarProducto(ActionEvent actionEvent) {
        Producto seleccionado = tablaProductos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            abrirFormulario(seleccionado); // Modo editar
        } else {
            mostrarAlerta("Error", "Debes seleccionar un producto para editar.", Alert.AlertType.WARNING);
        }
    }

    public void handleEliminarProducto(ActionEvent actionEvent) {
        Producto seleccionado = tablaProductos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            listaProductos.remove(seleccionado);
            mostrarAlerta("Producto eliminado", "Se ha eliminado el producto seleccionado.", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Error", "Debes seleccionar un producto para eliminar.", Alert.AlertType.WARNING);
        }
    }

    public void abrirFormulario(Producto producto) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProductoFormulario.fxml"));
            Scene scene = new Scene(loader.load());


            ProductoFormularioController controller = loader.getController();
            controller.setProducto(producto);


            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle(producto == null ? "Agregar Producto" : "Editar Producto");


            stage.showAndWait();


            if (controller.isGuardado()) {
                if (producto == null) {
                    listaProductos.add(controller.getProducto());
                } else {
                    tablaProductos.refresh();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cargarProductosEnTabla() {
        listaProductos = FXCollections.observableArrayList(INSTANCE.getDatabaseConnection().cargarProductos());
        tablaProductos.setItems(listaProductos);
    }

    private void guardarProductoEnBaseDeDatos(Producto producto) {
        if (INSTANCE.getDatabaseConnection().guardarProducto(producto)) {
            listaProductos.add(producto);
        }
    }

    private void actualizarProductoEnBaseDeDatos(Producto producto) {
        if (INSTANCE.getDatabaseConnection().actualizarProducto(producto)) {
            tablaProductos.refresh();
        }
    }

    private void eliminarProductoDeBaseDeDatos(Producto producto) {
//        String sql = "DELETE FROM PRODUCTOS WHERE ID_PRODUCTO = ?";
//        try (PreparedStatement pstmt = databaseConnection.conectar().prepareStatement(sql)) {
//            pstmt.setInt(1, producto.getIdProducto());
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("Error al eliminar el producto");
//            e.printStackTrace();
//        }
    }

    private void mostrarAlerta(String titulo, String contenido, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}
