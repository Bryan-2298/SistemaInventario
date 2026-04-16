package org.uacm.sistemainventario;

import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class AgregarProductoController implements Initializable {
    
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtcategoria;
    @FXML
    private TextField txtprecio;
    @FXML
    private TextField txtcantidad;
    @FXML
    private DatePicker dpFecha;
    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnCancelar;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //jdskfdjsfhdjkfhsdjkf
        //JOJOJKJJ
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
        //Aqui se obtiene los datos
        String nombre = txtnom.getText();
        String categoria = txtcategoria.getText();
        double precio = Double.parseDouble(txtprecio.getText());
        int cantidad = Integer.parseInt(txtcantidad.getText());
        LocalDate fecha = dpFecha.getValue();

        //Validacion para campos vacios
        if (nombre.isEmpty() || categoria.isEmpty() || fecha == null) {
            System.out.println("Faltan datos obligatorios");
            return;
        }

        
        txtnom.clear();
        txtcategoria.clear();
        txtprecio.clear();
        txtcantidad.clear();
        dpFecha.setValue(null);

    } catch (NumberFormatException e) {
        System.out.println("Error: Precio o cantidad invalidos");
    } catch (Exception e) {
        System.out.println("Error inesperado...");
    }
}

@FXML
private void aceptarProducto(ActionEvent event) {

    try {
        String nombre = txtnom.getText();
        String categoria = txtcategoria.getText();
        double precio = Double.parseDouble(txtprecio.getText());
        int cantidad = Integer.parseInt(txtcantidad.getText());
        LocalDate fecha = dpFecha.getValue();

         //Validacion para campos vacios
        if (nombre.isEmpty() || categoria.isEmpty() ||  fecha == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos vacios");
            alert.setHeaderText(null);
            alert.setContentText("Completa todos los campos obligatorios.");
            alert.showAndWait();
            return;
        }

        System.out.println("Producto agregado correctamente.");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Exito");
        alert.setHeaderText(null);
        alert.setContentText("Producto agregado correctamente.");
        alert.showAndWait();

        txtnom.clear();
        txtcategoria.clear();
        txtprecio.clear();
        txtcantidad.clear();
        dpFecha.setValue(null);

    } catch (NumberFormatException e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Precio o cantidad invalidos.");
        alert.showAndWait();
    }
}

@FXML
private void cancelarOperacion(ActionEvent event) {

    Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
    confirmacion.setTitle("Cancelar.");
    confirmacion.setHeaderText(null);
    confirmacion.setContentText("¿Deseas cancelar la operacion?");

    Optional<ButtonType> resultado = confirmacion.showAndWait();

    if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
        
        txtnom.clear();
        txtcategoria.clear();
        txtprecio.clear();
        txtcantidad.clear();
        dpFecha.setValue(null);

        System.out.println("Operacion cancelada.");
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
    
}
