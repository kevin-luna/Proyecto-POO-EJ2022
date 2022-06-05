package com.itver;

public class Cargo {
    private String concepto;
    private String descripcion;
    private float precio;

    public Cargo(String concepto, float precio) {
        this.concepto = concepto;
        this.precio = precio;
    }

    public Cargo(String concepto, String descripcion, float precio) {
        this.concepto = concepto;
        this.descripcion = descripcion;
        this.precio = precio;
    }


}
