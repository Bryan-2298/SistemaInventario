package org.uacm.sistemainventario;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    //private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("PreLogin"));
        stage.setScene(scene);
        stage.show();
    }
/*
    static void setRoot(String fxml, String titulo) throws IOException {
        scene.setRoot(loadFXML(fxml));
        stage.setTitle(titulo);
    }
*/    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    /*    
    static void setRoot(String fxml, String titulo, Double ancho, Double alto) throws IOException {
        scene.setRoot(loadFXML(fxml));
        stage.setTitle(titulo);
        stage.setWidth(ancho);
        stage.setHeight(alto);
    }
*/
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }

}