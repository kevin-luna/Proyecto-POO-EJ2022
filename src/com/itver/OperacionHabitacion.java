package com.itver;

public abstract class OperacionHabitacion {
    private Cliente cliente;
    private Habitacion habitacion;

    public OperacionHabitacion(){};

    public OperacionHabitacion(Cliente cliente, Habitacion habitacion) {
        this.cliente = cliente;
        this.habitacion = habitacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
}
