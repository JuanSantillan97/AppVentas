package com.juan.autenticarmysql.Model;

public class Cliente {

    private String key, nombre, direccion, telefono,  correo;
    private String imagen;

    public Cliente(String key, String nombre, String direccion, String telefono , String correo, String imagen) {
        this.key = key;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.imagen = imagen;
    }

    public Cliente() {}

    // Getters.
    public String getKey() { return key; }
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
    public String getImagen() { return imagen; }

    // Setters.
    public void setKey(String key) { this.key = key; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setImagen(String imagen) { this.imagen = imagen; }

}
