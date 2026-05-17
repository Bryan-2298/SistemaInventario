package org.uacm.sistemainventario;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
public class MenuPrincipalController implements Initializable {


    @FXML
    private Button btnCerrarSesion;
    @FXML
    private ImageView imgImagenFondo;
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnConsultar;



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void volverLogin(ActionEvent event) {
        
        try {
            App.setRoot("Login");
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
    
}


