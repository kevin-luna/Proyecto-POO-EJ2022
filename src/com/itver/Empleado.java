package com.itver;

public class Empleado extends Persona{
    private String puesto;
    private String horaEntrada;
    private String horaSalida;
    private float salario;

    public Empleado(String nombre, String apellido, String fechaNacimiento,String telefono, String RFC, String puesto, String horaEntrada, String horaSalida, float salario) {
        super(nombre, apellido, fechaNacimiento,telefono, RFC);
        this.puesto = puesto;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.salario = salario;
    }

    public String getPuesto() {
        return puesto;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public float getSalario() {
        return salario;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
