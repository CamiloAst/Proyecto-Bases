package co.edu.uniquindio.proyectobases.aplication.model;

public class Producto {
    private int idProducto;
    private String nombre;
    private float precio;
    private int idCategoria;
    private int idDescripcionPTO;

    public Producto(int idProducto, String nombre, float precio, int idCategoria, int idDescripcionPTO) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.idCategoria = idCategoria;
        this.idDescripcionPTO = idDescripcionPTO;
    }
    public Producto(){
        super();
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdDescripcionPTO() {
        return idDescripcionPTO;
    }

    public void setIdDescripcionPTO(int idDescripcionPTO) {
        this.idDescripcionPTO = idDescripcionPTO;
    }
}
