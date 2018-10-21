package com.juan.autenticarmysql;

public class Cliente {

    private String nombre, direccion, telefono,  correo;
    private int imagen;

    public Cliente(String nombre, String direccion, String telefono , String correo, int imagen) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.imagen = imagen;
    }

    // Getters.
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
    public int getImagen() { return imagen; }

    // Setters.
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setImagen(int imagen) { this.imagen = imagen; }

}
