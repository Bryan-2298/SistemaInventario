package org.uacm.sistemainventario;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import modelo.Inventario;
import modelo.Producto;

public class ConsultarProductosController implements Initializable {

    @FXML
    private AnchorPane pnlPanelCentral;
    @FXML
    private Button btnCerrarSesion;
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnConsultar;
    @FXML
    private ImageView imgImagenFondo;
    @FXML
    private TextField txtBuscar;
    @FXML
    private Button btnBuscar;
    @FXML
    private TableView<Producto> tvProductos;
    @FXML
    private TableColumn<Producto, String> tvColNombre;
    @FXML
    private TableColumn<Producto, Double> tvColPrecio;
    @FXML
    private Button btnInformacion;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tvColNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        tvColPrecio.setCellValueFactory(new PropertyValueFactory<>("Precio"));  // ← AGREGA ESTA LÍNEA

        tvProductos.setItems(Inventario.getConexion().ConsultarProducto());
    }    

    @FXML
    private void volverLogin(ActionEvent event) {
        try {
            App.setRoot("Login");
        } catch (Exception e) {
            System.out.println("Error al cargar la pantalla...");
        }
    }

    @FXML
    private void agregarProducto(ActionEvent event) {
        try {
            App.setRoot("AgregarProducto");
        } catch (Exception e) {
            System.out.println("Error al cargar la pantalla...");
        }
    }

    @FXML
    private void actualizarProducto(ActionEvent event) {
        try {
            App.setRoot("ActualizarProducto");
        } catch (Exception e) {
            System.out.println("Error al cargar la pantalla...");
        }
    }

    @FXML
    private void eliminarProducto(ActionEvent event) {
        try {
            App.setRoot("EliminarProducto");
        } catch (Exception e) {
            System.out.println("Error al cargar la pantalla...");
        }
    }

    @FXML
    private void consultarProducto(ActionEvent event) {
        try {
            App.setRoot("ConsultarProductos");
        } catch (Exception e) {
            System.out.println("Error al cargar la pantalla...");
        }
    }

    @FXML
    private void buscarProducto(ActionEvent event) {
        String buscado = txtBuscar.getText();
        ObservableList<Producto> listaBusqueda = Inventario.getConexion().filtrarProducto(buscado);
        tvProductos.setItems(listaBusqueda);
    }

    @FXML
    private void mostrarInformacion(ActionEvent event) {

        Producto productoSeleccionado = tvProductos.getSelectionModel().getSelectedItem();

        if (productoSeleccionado == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Sin selección");
            alert.setHeaderText(null);
            alert.setContentText("Primero selecciona un producto de la tabla.");
            alert.showAndWait();
            return;
        }
       
        Alert alrtInfo = new Alert(Alert.AlertType.CONFIRMATION);
        alrtInfo.setTitle("Información del producto");
        alrtInfo.setHeaderText("Detalles del producto");
        alrtInfo.setContentText("Producto: " + productoSeleccionado.getNombre()
                              + "\nCategoría: " + productoSeleccionado.getCategoria()
                              + "\nPrecio: $" + productoSeleccionado.getPrecio()
                              + "\nStock: " + productoSeleccionado.getCantidad()
                              + "\nFecha de ingreso: " + productoSeleccionado.getFecha());
        alrtInfo.showAndWait();
    }


}
