package com.itver;

public class Cliente extends Persona{
    private String metodoPago;

    public Cliente(){};
    public Cliente(String nombre, String apellido, String fechaNacimiento, String RFC,String metodoPago) {
        super(nombre, apellido, fechaNacimiento, RFC);
        this.metodoPago=metodoPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }
}
