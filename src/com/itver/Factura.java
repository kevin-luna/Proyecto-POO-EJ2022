package com.itver;

public class Factura {
    private Cliente cliente;
    private Cargo cargos[];
    private float total;

    public Factura(Cliente cliente, Cargo[] cargos, float total) {
        this.cliente = cliente;
        this.cargos = cargos;
        this.total = total;
    }

    public void guardar(){

    }
}
