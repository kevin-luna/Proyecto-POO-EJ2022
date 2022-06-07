package com.itver;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class Alquiler extends OperacionHabitacion{

    private static final String archivoRegistro = "./RegistroAlquiler.txt";
    private String fechaLlegada;
    private String fechaSalida;

    public Alquiler(){super();}
    public Alquiler(Cliente cliente, int habitacion, String fechaLlegada, String fechaSalida) {
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

    @Override
    public void leer(BufferedReader bfr){
        try{
            System.out.println("Ingrese el RFC del cliente:");
            String rfcCliente = bfr.readLine();
            this.setCliente(BuscadorCliente.buscar(rfcCliente));
            if(getCliente()==null) return;
            System.out.println("Ingrese el número de habitación:");
            setHabitacion(Integer.parseInt(bfr.readLine()));
            System.out.println("Ingrese la fecha de llegada:");
            setFechaLlegada(bfr.readLine());
            System.out.println("Ingrese la fecha de salida:");
            setFechaSalida(bfr.readLine());
        }catch (IOException e){
            System.out.println("Ocurrió un error al leer los datos.");
        }
    }
   @Override
    public void guardar(){
        if(getCliente()==null) return;
        try{
            FileWriter fw = new FileWriter(archivoRegistro,true);
            fw.write(this.getCliente().getNombre()+";"+this.getCliente().getApellido()+";"+this.getHabitacion()+";"+this.getCliente().getTelefono()+";"+this.getFechaLlegada()+";"+this.getFechaSalida()+"\n");
            fw.close();
            System.out.println("El registro de la habitación alquilada se ha realizado correctamente.");
        }catch (IOException e){
            System.out.println("Ocurrió un error al intentar escribir en el archivo.");
        }
    }
}
