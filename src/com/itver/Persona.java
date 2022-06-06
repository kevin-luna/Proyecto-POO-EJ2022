package com.itver;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String RFC;
    private String telefono;

    public Persona(){};

    public Persona(String nombre,String apellido,String telefono){
        this.nombre=nombre;
        this.apellido=apellido;
        this.telefono=telefono;
    }
    public Persona(String nombre, String apellido, String fechaNacimiento,String telefono, String RFC) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.RFC = RFC;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getRFC() {
        return RFC;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }
}
