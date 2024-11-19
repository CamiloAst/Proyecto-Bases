package co.edu.uniquindio.proyectobases.aplication.model;

import java.util.Date;

public class Venta {
    private int idVenta;
    private Date fechaVenta;
    private float totalVenta;
    private String idAfiliado;
    private String idFactura;

    public Venta(int idVenta, Date fechaVenta, float totalVenta, String idAfiliado, String idFactura) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.totalVenta = totalVenta;
        this.idAfiliado = idAfiliado;
        this.idFactura = idFactura;
    }
    public Venta(){
        super();
    }


    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public float getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(float totalVenta) {
        this.totalVenta = totalVenta;
    }

    public String getIdAfiliado() {
        return idAfiliado;
    }

    public void setIdAfiliado(String idAfiliado) {
        this.idAfiliado = idAfiliado;
    }

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }
}
