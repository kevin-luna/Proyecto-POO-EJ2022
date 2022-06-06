package com.itver;

public abstract class OperacionHabitacion {
    private Cliente cliente;
    private int habitacion;

    public OperacionHabitacion(){};

    public OperacionHabitacion(Cliente cliente, int habitacion) {
        this.cliente = cliente;
        this.habitacion = habitacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(int habitacion) {
        this.habitacion = habitacion;
    }
}
