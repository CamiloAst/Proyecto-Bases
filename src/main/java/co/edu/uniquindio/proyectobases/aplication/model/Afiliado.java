package co.edu.uniquindio.proyectobases.aplication.model;

import java.util.Date;

public class Afiliado {
    private int idAfiliado;
    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private Date fechaAfiliacion;
    private int idDireccion;
    private String rango;
    private String idAdministrador;
    private int idDesvinculacion;

    public Afiliado(int idAfiliado, String cedula, String nombre, String apellido, String telefono, String email, Date fechaAfiliacion, int idDireccion, String rango, String idAdministrador, int idDesvinculacion) {
        this.idAfiliado = idAfiliado;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.fechaAfiliacion = fechaAfiliacion;
        this.idDireccion = idDireccion;
        this.rango = rango;
        this.idAdministrador = idAdministrador;
        this.idDesvinculacion = idDesvinculacion;
    }

    public Afiliado(){
        super();
    }

    public Afiliado(int idAfiiliado,String nombre, String Rango, String Administrador){
        super();
        this.idAfiliado = idAfiiliado;
        this.nombre = nombre;
        this.rango = Rango;
        this.idAdministrador = Administrador;
    }

    public int getIdAfiliado() {
        return idAfiliado;
    }

    public void setIdAfiliado(int idAfiliado) {
        this.idAfiliado = idAfiliado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaAfiliacion() {
        return fechaAfiliacion;
    }

    public void setFechaAfiliacion(Date fechaAfiliacion) {
        this.fechaAfiliacion = fechaAfiliacion;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public int getIdDesvinculacion() {
        return idDesvinculacion;
    }

    public void setIdDesvinculacion(int idDesvinculacion) {
        this.idDesvinculacion = idDesvinculacion;
    }
}

