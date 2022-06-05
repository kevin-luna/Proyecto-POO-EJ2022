package com.itver;

public abstract class OperacionHabitacion {
    private Cliente cliente;
    private Habitacion habitacion;

    public OperacionHabitacion(Cliente cliente, Habitacion habitacion) {
        this.cliente = cliente;
        this.habitacion = habitacion;
    }
}
