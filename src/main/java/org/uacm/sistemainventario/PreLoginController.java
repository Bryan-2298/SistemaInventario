package org.uacm.sistemainventario;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class PreLoginController implements Initializable {

    @FXML
    private Button btnInicioSesion;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void irLogin(ActionEvent event) {
        
        try {
            App.setRoot("Login");
        } catch (Exception e) {
            System.out.println("Error al cambiar de pantalla...");
        }
        
    }
    
}
