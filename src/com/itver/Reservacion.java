package com.itver;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class Reservacion extends OperacionHabitacion{
    private String fechaReservacion;

    public Reservacion(){}

    public Reservacion(Cliente cliente, int habitacion, String fechaReservacion) {
        super(cliente, habitacion);
        this.fechaReservacion = fechaReservacion;
    }


    @Override
    public void leer(BufferedReader bfr) {
        try{
            System.out.println("Ingrese el RFC del cliente:");
            String rfcCliente = bfr.readLine();
            this.setCliente(BuscadorCliente.buscar(rfcCliente));
            if(getCliente()==null) return;
            System.out.println("Ingrese el número de habitación:");
            setHabitacion(Integer.parseInt(bfr.readLine()));
            System.out.println("Ingrese la fecha de la reservación:");
            setFechaReservacion(bfr.readLine());
        }catch (IOException e){
            System.out.println("Ocurrió un error al leer los datos.");
        }
    }

    @Override
    public void guardar(String file) {
        if(getCliente()==null) return;
        try{
            FileWriter fw = new FileWriter(file,true);
            fw.write(this.getCliente().getNombre()+";"+this.getCliente().getApellido()+";"+this.getHabitacion()+";"+this.getCliente().getTelefono()+";"+this.getFechaReservacion()+"\n");
            fw.close();
            System.out.println("El registro de la habitación alquilada se ha realizado correctamente.");
        }catch (IOException e){
            System.out.println("Ocurrió un error al intentar escribir en el archivo.");
        }
    }

    public String getFechaReservacion() {
        return fechaReservacion;
    }

    public void setFechaReservacion(String fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
    }
}
