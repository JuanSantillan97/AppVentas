package com.juan.autenticarmysql.Model;

public class Producto {

    private String key, nombreP, descripcion, imagenP;
    private int precioCosto, cantidad, precioVenta;

    public Producto(String key, String nombreP, int precioCosto, int cantidad, int precioVenta, String descripcion, String imagenP) {
        this.key = key;
        this.nombreP = nombreP;
        this.precioCosto = precioCosto;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.descripcion = descripcion;
        this.imagenP = imagenP;
    }

    public Producto() {}

    // Getters.
    public String getKey() { return key; }
    public String getNombreP() { return nombreP; }
    public String getDescripcion() { return descripcion; }
    public int getPrecioCosto() { return precioCosto; }
    public int getCantidad() { return cantidad; }
    public int getPrecioVenta() { return precioVenta; }
    public String getImagenP() { return imagenP; }

    // Setters.
    public void setkey(String key) { this.key = key; }
    public void setNombreP(String nombreP) { this.nombreP = nombreP; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setPrecioCosto(int precioCosto) { this.precioCosto = precioCosto; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setPrecioVenta(int precioVenta) { this.precioVenta = precioVenta; }
    public void setImagenP(String imagenP) { this.imagenP = imagenP; }

}
