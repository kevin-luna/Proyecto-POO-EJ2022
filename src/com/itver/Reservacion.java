package com.itver;

public class Reservacion extends OperacionHabitacion{
    private String fechaReservacion;

    public Reservacion(Cliente cliente, int habitacion, String fechaReservacion) {
        super(cliente, habitacion);
        this.fechaReservacion = fechaReservacion;
    }
}
