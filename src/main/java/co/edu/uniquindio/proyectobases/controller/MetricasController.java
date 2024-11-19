package co.edu.uniquindio.proyectobases.controller;

import co.edu.uniquindio.proyectobases.aplication.model.Afiliado;
import co.edu.uniquindio.proyectobases.aplication.model.Venta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import static co.edu.uniquindio.proyectobases.controller.AppController.INSTANCE;

public class MetricasController {

    @FXML
    private Label nombreLabel;

    @FXML
    private Label idLabel;

    @FXML
    private Label rangoLabel;

    @FXML
    private TableView<Venta> tablaVentas;

    @FXML
    private TableColumn<Venta, Integer> columnaIdVenta;

    @FXML
    private TableColumn<Venta, String> columnaProducto;

    @FXML
    private TableColumn<Venta, Integer> columnaCantidad;

    @FXML
    private TableColumn<Venta, Double> columnaTotal;

    @FXML
    private TableView<Afiliado> tablaAfiliados;

    @FXML
    private TableColumn<Afiliado, Integer> columnaIdAfiliado;

    @FXML
    private TableColumn<Afiliado, String> columnaNombreAfiliado;

    @FXML
    private TableColumn<Afiliado, String> columnaRangoAfiliado;

    private ObservableList<Venta> listaVentas;
    private ObservableList<Afiliado> listaAfiliados;

    public void initialize() {

        columnaIdVenta.setCellValueFactory(new PropertyValueFactory<>("idVenta"));
        columnaProducto.setCellValueFactory(new PropertyValueFactory<>("fechaVenta"));
        columnaCantidad.setCellValueFactory(new PropertyValueFactory<>("totalVenta"));
        columnaTotal.setCellValueFactory(new PropertyValueFactory<>("idAfiliado"));
        columnaIdAfiliado.setCellValueFactory(new PropertyValueFactory<>("ifAfiliado"));


        columnaNombreAfiliado.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaRangoAfiliado.setCellValueFactory(new PropertyValueFactory<>("rango"));

        cargarVentas();
        cargarAfiliados();
        cargarDatosVendedor(INSTANCE.getAfiliado().getNombre(), INSTANCE.getAfiliado().getCedula(), INSTANCE.getAfiliado().getRango());
    }

    public void cargarDatosVendedor(String nombre, String id, String rango) {
        nombreLabel.setText(nombre);
        idLabel.setText(id);
        rangoLabel.setText(rango);
    }

    public void cargarVentas() {
        listaVentas = FXCollections.observableArrayList(INSTANCE.getDatabaseConnection().cargarVentas());
    }

    public void cargarAfiliados() {
        listaAfiliados = FXCollections.observableArrayList(INSTANCE.getDatabaseConnection().cargarAfiliadosJerarquicos(INSTANCE.getAfiliado().getIdAfiliado()));
    }
}
