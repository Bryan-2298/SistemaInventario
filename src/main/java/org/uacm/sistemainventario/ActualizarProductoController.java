package org.uacm.sistemainventario;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ActualizarProductoController implements Initializable {

    //  CONEXIÓN CON FXML
    @FXML
    private TextField txtBuscar, txtNombre, txtCategoria, txtPrecio, txtCantidad;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Puedes inicializar cosas aquí si quieres
    }

    // BUSCAR PRODUCTO
    @FXML
    private void buscarProducto() {
        String dato = txtBuscar.getText();

        if (dato == null || dato.isEmpty()) {
            mostrarAlerta("Error", "Ingresa un valor para buscar");
            return;
        }

        // Simulación (luego lo conectas a BD)
        if (dato.equals("1")) {
            txtNombre.setText("Laptop");
            txtCategoria.setText("Electrónica");
            txtPrecio.setText("15000");
            txtCantidad.setText("10");

            mostrarAlerta("Éxito", "Producto encontrado");
        } else {
            limpiarCampos();
            mostrarAlerta("Error", "Producto no encontrado");
        }
    }

    // ACTUALIZAR PRODUCTO
    @FXML
    private void actualizarProducto() {

        String nombre = txtNombre.getText();
        String categoria = txtCategoria.getText();
        String precio = txtPrecio.getText();
        String cantidad = txtCantidad.getText();

        // VALIDAR CAMPOS VACÍOS
        if (nombre.isEmpty() || categoria.isEmpty() ||
            precio.isEmpty() || cantidad.isEmpty()) {

            mostrarAlerta("Error", "Todos los campos son obligatorios");
            return;
        }

        try {
            double precioNum = Double.parseDouble(precio);
            int cantidadNum = Integer.parseInt(cantidad);

            //  Aquí irá tu UPDATE a BD después
            System.out.println("Actualizando producto...");
            System.out.println(nombre + " - " + categoria);
            System.out.println("Precio: " + precioNum);
            System.out.println("Cantidad: " + cantidadNum);

            mostrarAlerta("Éxito", "Producto actualizado correctamente");

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Precio y cantidad deben ser números");
        }
    }

    //LIMPIAR CAMPOS
    private void limpiarCampos() {
        txtNombre.clear();
        txtCategoria.clear();
        txtPrecio.clear();
        txtCantidad.clear();
    }

    //ALERTAS
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
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
}