package com.itver;

import java.io.*;

public class Reservacion extends OperacionHabitacion{

    private static final String archivoRegistro = "RegistroReservaciones.txt";
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
    public void guardar() {
        if(getCliente()==null) return;
        try{
            FileWriter fw = new FileWriter(archivoRegistro,true);
            fw.write(this.getCliente().getNombre()+";"+this.getCliente().getApellido()+";"+this.getHabitacion()+";"+this.getCliente().getTelefono()+";"+this.getFechaReservacion()+"\n");
            fw.close();
            System.out.println("El registro de la habitación alquilada se ha realizado correctamente.");
        }catch (IOException e){
            System.out.println("Ocurrió un error al intentar escribir en el archivo.");
        }
    }

    public static void mostrarReservaciones(){
        try{
            BufferedReader fr = new BufferedReader(new FileReader(archivoRegistro));
            String leftAlignFormat = "| %-52s | %-52s | %-20s | %-18s | %-23s |%n";
            System.out.format("+------------------------------------------------------+------------------------------------------------------+----------------------+--------------------+-------------------------+%n");
            System.out.format("| Nombre del cliente                                   | Apellido                                             | Número de habitación | Número de teléfono | Fecha de la reservación |%n");
            System.out.format("+------------------------------------------------------+------------------------------------------------------+----------------------+--------------------+-------------------------+%n");
            String line;
            while((line=fr.readLine())!=null){
                String[] datosAlquiler = line.split(";");
                System.out.format(leftAlignFormat,datosAlquiler[0],datosAlquiler[1],datosAlquiler[2],datosAlquiler[3],datosAlquiler[4]);
            }
            System.out.format("+------------------------------------------------------+------------------------------------------------------+----------------------+--------------------+-------------------------+%n");
        }catch (FileNotFoundException e){
            System.out.println("No se encuentra el archivo");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getFechaReservacion() {
        return fechaReservacion;
    }

    public void setFechaReservacion(String fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
    }
}
