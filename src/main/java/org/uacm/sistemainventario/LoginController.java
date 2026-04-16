/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package org.uacm.sistemainventario;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

/**
 * FXML Controller class
 *
 * @author Tienda
 */
public class LoginController implements Initializable {
    
    @FXML
    private Button btnIngresar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnPasswordPerdida;
    @FXML
    private PasswordField txtPassword;
    
    final static String PASSWORD = "AjoloSoft2026";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //contraseña del programa
        
    }    
    
    @FXML
    private void iniciarSesion(ActionEvent event) {
        
        try {

            //Capturar la contraseñas
            String contrasenia = txtPassword.getText();

            //Condicciones para la validacion a la contraseña
            if (PASSWORD.equals(contrasenia)) {
                App.setRoot("MenuPrincipal");
            } else {
                Alert alrtInfo = new Alert(Alert.AlertType.ERROR);
                alrtInfo.setTitle("Sistema");
                alrtInfo.setHeaderText("CONTRASEÑA INVALIDA");
                alrtInfo.setContentText("INTENTAR DE NUEVO");
                alrtInfo.showAndWait();
            }
            
        } catch (Exception e) {
            System.out.println("Erroral cargar la pantalla...");
        }
        
    }
    
    @FXML
    private void volverPreLogin(ActionEvent event) {
        
        try {
            App.setRoot("PreLogin");
            
        } catch (Exception e) {
            System.out.println("Erroral cargar la pantalla...");
        }
    }
    
    @FXML
    private void infoContacto(ActionEvent event) {
     Alert alrtInfo = new Alert(Alert.AlertType.INFORMATION);
                alrtInfo.setTitle("Sistema");
                alrtInfo.setHeaderText("Has perdido la contraseña contactanos: ");
                alrtInfo.setContentText("Correo: bryan.amador@estudiante.uacm.edu.mx"
                                + "\nTelefono: 5534008829"
                                + "\nDirección: Av. del Arbol 12345");
                alrtInfo.showAndWait();
    }
}
