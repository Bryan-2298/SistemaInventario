package modelo;

import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.uacm.sistemainventario.GestorProductos;

public class Inventario implements GestorProductos{
    
    /*
    * Para poder conectar los productos entre pantallas usaremos el patron Singleton
    */
    //Atributo para conectar todas las pantallas con esta
    private static Inventario conexion;
    
    //Creamos nuestra lista de prouctos
    private ObservableList<Producto> listaProductos;

    //Creamos nuestro constructor inicializando nuestra lista como un ObservableList
    private Inventario() {
        listaProductos = FXCollections.observableArrayList();
    }
    
    //Creamos metodo para que los controladores se puedan conectar con y utilizar los metodos de esta pantalla
    public static Inventario getConexion(){//Inicia metodo
        //Si no hay conexion...
        if(conexion == null){
            //Instanciamos la conexion
            conexion = new Inventario();
        }
        //Si ya existe la conexion solo la enviamos
        return conexion;
    }//Termina metodo

    //Metodo para Mostrar/consultar los productos del inventario
    @Override
    public ObservableList<Producto> ConsultarProducto() {
        return listaProductos;
    }

    //Metodo para agregar productos al inventario
    @Override
    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    //Metodo para actualziar los productos del inventario
    @Override
    public void actualizarProducto(int idBuscado, String nombre, Categoria categoria, double precio, int cantidad, LocalDate fecha) {
        //Recorremos la lista de productos
        for (Producto producto : listaProductos) {//Inicia foreach
            //Si el nombre buscado coincide con el nombre del producto en la lista...
            if (producto.getId() == idBuscado) {//Inicia if-else
                //Actualizamos los datos del producto
                producto.setNombre(nombre);
                producto.setCategoria(categoria);
                producto.setPrecio(precio);
                producto.setCantidad(cantidad);
                producto.setFecha(fecha);
                break;
            }
            
        }
    }

    //Metodo para buscar un producto
    @Override
    public Producto buscarNombre(String nombre) {
        
        for (Producto producto : listaProductos) {            
            if (producto.getNombre().equals(nombre)){
                return producto;
            }
        }
        return null;
    }

    //Metodo para eliminar un producto del inventario
    @Override
    public void eliminarProducto(String nombre) {
        Producto productoBorrar = buscarNombre(nombre);        
        if (productoBorrar != null){            
            listaProductos.remove(productoBorrar);     
        }
    }
    
    //Metodo para hacer un filtrado por nombre o categoria en las tablas
    @Override
    public ObservableList filtrarProducto(String buscar){//Inicia metodo
        
        ObservableList<Producto> buscado = FXCollections.observableArrayList();
        String filtro = buscar.toUpperCase();
                
        for (Producto productos : listaProductos) {
            
            String filtroNombre = productos.getNombre().toUpperCase();
            String filtroCategoria = productos.getCategoria().name().toLowerCase();
            
            if(filtroNombre.contains(filtro) || filtroCategoria.contains(filtro)){
                buscado.add(productos);
            }
            
        }
        return buscado;
    }
}