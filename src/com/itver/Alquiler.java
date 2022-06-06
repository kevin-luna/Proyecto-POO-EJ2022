package com.itver;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class Alquiler extends OperacionHabitacion{

    private String fechaLlegada;
    private String fechaSalida;

    public Alquiler(){super();};
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

    public void leer(BufferedReader bfr){
        Cliente cliente = new Cliente();
        try{
            System.out.println("Ingrese el nombre del cliente:");
            cliente.setNombre(bfr.readLine());
            System.out.println("Ingrese el apellido del cliente:");
            cliente.setApellido(bfr.readLine());
            System.out.println("Ingrese el telefono del cliente:");
            cliente.setTelefono(bfr.readLine());
            this.setCliente(cliente);
            System.out.println("Ingrese la fecha de llegada:");
            this.setFechaLlegada(bfr.readLine());
            System.out.println("Ingrese la fecha de salida:");
            this.setFechaSalida(bfr.readLine());
        }catch (IOException e){
            System.out.println("Ocurrió un error al leer los datos.");
        }
    }
    public void guardar(String file){

        try{
            FileWriter fw = new FileWriter(file,true);
            fw.write(this.getCliente().getNombre()+";"+this.getCliente().getApellido()+";"+this.getFechaLlegada()+";"+this.getFechaSalida()+"\n");
            fw.close();
            System.out.println("El registro de la habitación alquilada se ha realizado correctamente.");
        }catch (IOException e){
            System.out.println("Ocurrió un error al intentar escribir en el archivo.");
        }
    }
}
