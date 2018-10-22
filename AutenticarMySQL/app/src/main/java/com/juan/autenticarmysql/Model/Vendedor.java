package com.juan.autenticarmysql.Model;

public class Vendedor {

    private String nombre, contrasena, direccion, telefono,  correo;

    public Vendedor(String nombre, String contrasena, String direccion, String telefono , String correo, int imagen) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Vendedor(){ }

    // Getters.
    public String getNombre() { return nombre; }
    public String getContrasena() { return contrasena; }
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }

    // Setters.
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setCorreo(String correo) { this.correo = correo; }

}
