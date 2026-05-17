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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import modelo.Categoria;

import modelo.Producto;
import modelo.Inventario;

public class AgregarProductoController implements Initializable {
    
    @FXML
    private TextField txtnom;
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
    private ChoiceBox<Categoria> chCategoria;
    
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
        chCategoria.getItems().addAll(Categoria.values());
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
        Categoria categoria = chCategoria.getValue();
        double precio = Double.parseDouble(txtprecio.getText());
        int cantidad = Integer.parseInt(txtcantidad.getText());
        LocalDate fecha = dpFecha.getValue();

        //Validacion para campos vacios
       if (nombre.isEmpty() || categoria == null || fecha == null) {
            System.out.println("Faltan datos obligatorios");
            return;
        }
        
        txtnom.clear();
        chCategoria.setValue(null);
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
private void aptProducto(ActionEvent event) {

    try {
        String nombre = txtnom.getText();
        Categoria categoria = chCategoria.getValue();
        double precio = Double.parseDouble(txtprecio.getText());
        int cantidad = Integer.parseInt(txtcantidad.getText());
        LocalDate fecha = dpFecha.getValue();

         //Validacion para campos vacios
       if (nombre.isEmpty() || categoria == null || fecha == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos vacios");
            alert.setHeaderText(null);
            alert.setContentText("Completa todos los campos obligatorios.");
            alert.showAndWait();
            return;
        }
        
        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmacion.");
        confirmacion.setHeaderText(null);
        confirmacion.setContentText("¿Estas seguro que quieres registrar estos datos?");
        Optional<ButtonType> resultado=confirmacion.showAndWait();
        if(resultado.isPresent() && resultado.get() == ButtonType.OK){
            
        // ===== AGREGe ESTAS 2 LÍNEAS =====
        Producto nuevoProducto = new Producto(nombre, categoria, precio, cantidad, fecha);
        Inventario.getConexion().agregarProducto(nuevoProducto);
            // =================================
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Exito");
        alert.setHeaderText(null);
        alert.setContentText("Producto agregado correctamente.");
        alert.showAndWait();

        txtnom.clear();
        chCategoria.setValue(null);
        txtprecio.clear();
        txtcantidad.clear();
        dpFecha.setValue(null);
            
        }


    } catch (NumberFormatException e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Precio o cantidad invalidos.");
        alert.showAndWait();
    }
}

@FXML
private void canceProducto(ActionEvent event) {

    Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
    confirmacion.setTitle("Cancelar.");
    confirmacion.setHeaderText(null);
    confirmacion.setContentText("¿Deseas cancelar la operacion?");

    Optional<ButtonType> resultado = confirmacion.showAndWait();

    if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
        
        txtnom.clear();
        chCategoria.setValue(null);
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