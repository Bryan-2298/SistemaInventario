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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void iniciarSesion(ActionEvent event) {
        
        try {
            App.setRoot("MenuPrincipal");
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
    }
    
}
