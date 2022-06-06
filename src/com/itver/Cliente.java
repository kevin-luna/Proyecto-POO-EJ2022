package com.itver;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class Cliente extends Persona{
    private String metodoPago;

    public Cliente(){};

    public Cliente(String nombre,String apellido,String telefono){
        super(nombre,apellido,telefono);
    }

    public Cliente(String nombre, String apellido, String fechaNacimiento,String telefono, String RFC, String metodoPago) {
        super(nombre, apellido, fechaNacimiento,telefono, RFC);
        this.metodoPago=metodoPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago){
        this.metodoPago=metodoPago;
    }

    public void leer(BufferedReader bfr){
        int cantClientes=0;
        do{
            try {
                System.out.println("¿Cuántos clientes desea registrar?");
                cantClientes = Integer.parseInt(bfr.readLine());
                for(int i=0;i<cantClientes;i++){
                    String nombre,apellido,fechaNacimiento,RFC,metodoPago;
                    try{
                        System.out.println("Ingrese el nombre del cliente:");
                        this.setNombre(bfr.readLine());
                        System.out.println("Ingrese el apellido del cliente:");
                        this.setApellido(bfr.readLine());
                        System.out.println("Ingrese la fecha de nacimiento del cliente:");
                        this.setFechaNacimiento(bfr.readLine());
                        System.out.println("Ingrese el telefono del cliente:");
                        this.setTelefono(bfr.readLine());
                        System.out.println("Ingrese el RFC del cliente:");
                        this.setRFC(bfr.readLine());
                        System.out.println("Ingrese el método de pago del cliente:");
                        this.setMetodoPago(bfr.readLine());
                    }catch (IOException e){
                        System.out.println("Ocurrió un error al leer los datos.");
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Debe ingresar un número entero positivo.");
            }catch (IOException e){
                System.out.println("Ocurrio un error al leer los datos.");
            }
        }while(cantClientes<0);
    }

    public void guardar(String file){
        try{
            FileWriter fw = new FileWriter(file,true);
            fw.write(this.getNombre()+";"+this.getApellido()+";"+this.getFechaNacimiento()+";"+this.getTelefono()+";"+this.getRFC()+";"+this.getMetodoPago()+"\n");
            fw.close();
            System.out.println("Cliente registrado correctamente.");
        }catch (IOException e){
            System.out.println("Ocurrió un error al intentar escribir en el archivo.");
        }
    }
}
