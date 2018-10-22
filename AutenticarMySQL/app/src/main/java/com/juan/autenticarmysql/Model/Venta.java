package com.juan.autenticarmysql.Model;

public class Venta {

    //(Fecha de la venta, Cliente, Producto, Cantidad, (Calcular total a pagar), Pagado de contado (Si, NO), Pagado en Abonos (Si, NO).
    private String fecha, cliente, producto, formaDePago;
    private int cantidad, total;

    public Venta (String fecha, String cliente, String producto, int cantidad, int total, String formaDePago) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = total;
        this.formaDePago = formaDePago;
    }

    public Venta () {}

    // Getters.
    public String getFecha() { return fecha; }
    public String getCliente() { return cliente; }
    public String getProducto() { return producto; }
    public String getFormaDePago() { return formaDePago; }
    public int getCantidad() { return cantidad; }
    public int getTotal() { return total; }

    // Setters.
    public void setFecha(String fecha) { this.fecha = fecha; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public void setProducto(String producto) { this.producto = producto; }
    public void setFormaDePago(String formaDePago) { this.formaDePago = formaDePago; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setTotal(int total) { this.total = total; }

}
