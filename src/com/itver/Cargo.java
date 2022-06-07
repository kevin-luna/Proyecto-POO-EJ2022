package com.itver;

public class Cargo {
    private String concepto;
    private String descripcion;
    private float precio;

    public Cargo(){}

    public Cargo(String concepto, float precio) {
        this.concepto = concepto;
        this.precio = precio;
    }

    public Cargo(String concepto, String descripcion, float precio) {
        this.concepto = concepto;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
