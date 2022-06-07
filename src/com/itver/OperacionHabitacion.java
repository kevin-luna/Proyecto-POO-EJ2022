package com.itver;

import java.io.BufferedReader;

public abstract class OperacionHabitacion {
    private Cliente cliente;
    private int habitacion;

    public OperacionHabitacion(){}

    public OperacionHabitacion(Cliente cliente, int habitacion) {
        this.cliente = cliente;
        this.habitacion = habitacion;
    }

    public abstract void leer(BufferedReader bfr);

    public abstract void guardar();

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
