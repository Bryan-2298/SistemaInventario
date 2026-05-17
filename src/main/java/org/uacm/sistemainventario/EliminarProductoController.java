package org.uacm.sistemainventario;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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

public class EliminarProductoController implements Initializable {

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
    
    private ObservableList<Producto> listaProductos = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tvColNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        tvColPrecio.setCellValueFactory(new PropertyValueFactory<>("Precio"));
        
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
    private void borrarProducto(ActionEvent event) {
        
        //Realizamos la eliminacion de un producto seleccionado de la tabla
        Producto productoSeleccionado = tvProductos.getSelectionModel().getSelectedItem();
        Inventario.getConexion().eliminarProducto(productoSeleccionado.getNombre());
        
        //Confirmacion al usuario del producto eliminado
        Alert exitoDelete = new Alert(Alert.AlertType.CONFIRMATION);
        exitoDelete.setTitle("Sistema");
        exitoDelete.setContentText("¡Producto eliminado correctamente!");
        exitoDelete.showAndWait();
        
        tvProductos.setItems(Inventario.getConexion().ConsultarProducto());
    }
    
}
