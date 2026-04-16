package org.uacm.sistemainventario;

import java.time.LocalDate;
import javafx.collections.ObservableList;
import modelo.Categoria;
import modelo.Producto;

public interface GestorProductos {//Inicia interface
    
    public ObservableList<Producto> ConsultarProducto();
    public void agregarProducto(Producto producto);
    public void actualizarProducto(int idBuscado, String nombre, Categoria categoria, double precio, int cantidad, LocalDate fecha);
    public Producto buscarNombre(String nombre);
    public void eliminarProducto(String nombre);
    public ObservableList filtrarProducto(String buscar);
    
}//Termina interface