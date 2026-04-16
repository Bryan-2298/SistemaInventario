package modelo;

import java.time.LocalDate;

public class Producto {//Inicia clase
    
    //Atributos de para los objetos
    private static int contador = 1;
    private int id;
    private String nombre;
    private Categoria categoria;
    private double precio;
    private int cantidad;
    private LocalDate fecha;
    
    //Generamos constructor
    public Producto(String nombre, Categoria categoria, double precio, int cantidad, LocalDate fecha) {
        this.id = contador++;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }
    
    //Generamos Getters y Setters
    public int getId(){
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

}//Termina clase