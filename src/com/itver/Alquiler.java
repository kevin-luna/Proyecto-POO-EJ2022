package com.itver;

public class Alquiler extends OperacionHabitacion{

    private String fechaLlegada;
    private String fechaSalida;

    public Alquiler(Cliente cliente, Habitacion habitacion, String fechaLlegada, String fechaSalida) {
        super(cliente, habitacion);
        this.fechaLlegada = fechaLlegada;
        this.fechaSalida = fechaSalida;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}
