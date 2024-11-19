package co.edu.uniquindio.proyectobases.aplication.model;

public class Producto {
    private int idProducto;
    private String nombre;
    private float precio;
    private String categoria;
    private String descripcionPTO;

    public Producto(int idProducto, String nombre, float precio, String categoria, String descripcionPTO) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.descripcionPTO = descripcionPTO;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcionPTO() {
        return descripcionPTO;
    }

    public void setDescripcionPTO(String descripcionPTO) {
        this.descripcionPTO = descripcionPTO;
    }
}
