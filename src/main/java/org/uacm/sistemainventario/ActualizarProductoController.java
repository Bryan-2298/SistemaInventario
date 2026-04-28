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
import modelo.Inventario;
import modelo.Producto;

//leer comentarios para dudas

public class ActualizarProductoController implements Initializable {
// La clase implementa Initializable para poder usar el método initialize()

    @FXML
    private TextField txtBuscar, txtNombre, txtPrecio, txtCantidad;
    
    @FXML
    private ChoiceBox<Categoria>chCategoria; // para categoria
    
    @FXML
    private DatePicker dpFecha; //para la fecha
    
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
    
    private Producto productoEncontrado; // Guarda el producto encontrado
    // Variable para guardar el producto que se encontró al buscar
    // Así sabemos cuál producto estamos actualizando
    
   
    // MÉTODO INITIALIZE Se ejecuta automáticamente cuando se carga la pantalla
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // carga las categorias en el choicebox
        chCategoria.getItems().addAll(Categoria.values());
        // Inicialización
        // Por ahora no necesita inicializar nada
        // Aquí podrías cargar datos si fuera necesario
    }

    
     // ========== BUSCAR PRODUCTO ==========
    // Se ejecuta cuando el usuario presiona el boton buscar
    @FXML
    private void buscarProducto() {
        
         // Obtener el texto que el usuario escribió en el campo de búsqueda
        String nombreBuscado = txtBuscar.getText();
        //Validar que no este vacio
        if (nombreBuscado == null || nombreBuscado.isEmpty()) {
            mostrarAlerta("Error", "Ingresa un nombre para buscar", Alert.AlertType.ERROR);
            return;
        }

        // Buscar en el inventario real
        //  Buscar el producto en el inventario usando el metodo buscarNombre()
        //    Inventario.getConexion() obtiene la instancia única (patron Singleton)
        productoEncontrado = Inventario.getConexion().buscarNombre(nombreBuscado);

        if (productoEncontrado != null) {   //  Verificar si se encontroel producto            
            // Si se encontró, mostrar sus datos en los campos de texto

            txtNombre.setText(productoEncontrado.getNombre());
            chCategoria.setValue(productoEncontrado.getCategoria());//pra check de cstegoria
            //txtCategoria.setText(productoEncontrado.getCategoria().name());
            txtPrecio.setText(String.valueOf(productoEncontrado.getPrecio()));
            txtCantidad.setText(String.valueOf(productoEncontrado.getCantidad()));
             dpFecha.setValue(productoEncontrado.getFecha());
            
            mostrarAlerta("Éxito", "Producto encontrado", Alert.AlertType.INFORMATION);
        } else {
            // Si no se encontro limpiar los campos y mostrar error

            limpiarCampos();
            productoEncontrado = null;
            mostrarAlerta("Error", "Producto no encontrado", Alert.AlertType.ERROR);
        }
    }
     
    // ========== ACTUALIZAR PRODUCTO ==========
    // Se ejecuta cuando el usuario presiona el boton actualizar
    @FXML
    private void actualizarProducto() {
        // 1. Verificar que se haya buscado un producto primero

        if (productoEncontrado == null) {
            mostrarAlerta("Error", "Primero busca un producto para actualizar", Alert.AlertType.ERROR);
            return;
        }

        // Obtener los valores actuales de los campos de texto
        String nombre = txtNombre.getText();
        Categoria categoria = chCategoria.getValue();
        //String categoriaStr = txtCategoria.getText();
        String precio = txtPrecio.getText();
        String cantidad = txtCantidad.getText();
        LocalDate fecha = dpFecha.getValue();

        // alidar que ningún campo estevacio
        // Validar campos (nota que ahora validamos fecha != null)
        if (nombre.isEmpty() || categoria == null || precio.isEmpty() || cantidad.isEmpty() || fecha == null) {
            mostrarAlerta("Error", "Todos los campos son obligatorios", Alert.AlertType.ERROR);
            return;
        }
         //Intentar convertir precio y cantidad a numeros
        try {
            double precioNum = Double.parseDouble(precio);
            int cantidadNum = Integer.parseInt(cantidad);
            
            // 5. Convertir la categoría de String a Enum (Categoria)
            
            //Pedir confirmacion al usuario antes de actualizar
            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Confirmar");
            confirmacion.setHeaderText(null);
            confirmacion.setContentText("¿Estás seguro de actualizar este producto?");
            Optional<ButtonType> resultado = confirmacion.showAndWait();
            //Si el usuario confirmo (presiono OK)
            if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
                // Actualizar en el inventario
                // ctualizar el producto en el inventario
                // Se usa el método actualizarProducto que recibe:
                // - id del producto a actualizar
                // - nuevos valores (nombre, categoría, precio, cantidad)
                // - fecha original (se mantiene)
                Inventario.getConexion().actualizarProducto(
                    productoEncontrado.getId(), nombre, categoria, precioNum, cantidadNum, fecha
                );
                
                mostrarAlerta("¡Buen trabajo jejejeje!", 
                "Ahora ya sabes cómo actualizar productos en el sistema.\n" +
                "Recuerda que puedes modificar nombre, categoría, precio y cantidad.", 
                Alert.AlertType.INFORMATION);
                
                
                mostrarAlerta("Éxito", "Producto actualizado correctamente", Alert.AlertType.INFORMATION);
                //Limpiar los campos y reiniciar
                limpiarCampos();
                productoEncontrado = null;
                txtBuscar.clear();
                dpFecha.setValue(null);
            }

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Precio y cantidad deben ser números válidos", Alert.AlertType.ERROR);
        }
    }
     // ========== LIMPIAR CAMPOS ==========
    // Metodo auxiliar para borrar todos los campos del formulario
    private void limpiarCampos() {
        txtNombre.clear();
        chCategoria.setValue(null);

        txtPrecio.clear();
        txtCantidad.clear();
        dpFecha.setValue(null);
    }
    
    
    // ========== MOSTRAR ALERTA ==========
    // Metodo auxiliar para mostrar ventanas de alerta
    // tipo puede ser INFORMATION ERROR ARNING CONFIRMATION
    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
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
    
    
    
     @FXML
    private void volverLogin(ActionEvent event) {
        try {
            App.setRoot("Login");
        } catch (Exception e) {
            System.out.println("Error al cargar la pantalla...");
        }
    }
    
}
    
    




    