package com.itver;

import java.io.*;

public class Cliente extends Persona{
    private static final String archivoRegistro = "./RegistroClientes.txt";
    private String metodoPago;

    public Cliente(){}

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

    public void guardar(){
        try{
            FileWriter fw = new FileWriter(archivoRegistro,true);
            fw.write(this.getNombre()+";"+this.getApellido()+";"+this.getFechaNacimiento()+";"+this.getTelefono()+";"+this.getRFC()+";"+this.getMetodoPago()+"\n");
            fw.close();
            System.out.println("Cliente registrado correctamente.");
        }catch (IOException e){
            System.out.println("Ocurrió un error al intentar escribir en el archivo.");
        }
    }

    public static void mostrarClientes(){
        try{
            BufferedReader fr = new BufferedReader(new FileReader(archivoRegistro));
            String leftAlignFormat = "| %-52s | %-52s | %-19s | %-9s | %-9s | %-18s |%n";
            System.out.format("+------------------------------------------------------+------------------------------------------------------+---------------------+------------+-----------+--------------------+%n");
            System.out.format("| Nombre                                               | Apellido                                             | Fecha de Nacimiento | Teléfono   | RFC       | Metodo de pago     |%n");
            System.out.format("+------------------------------------------------------+------------------------------------------------------+---------------------+------------+-----------+--------------------+%n");
            String line;
            while((line=fr.readLine())!=null){
                String[] serial = line.split(";");
                System.out.format(leftAlignFormat,serial[0],serial[1],serial[2],serial[3],serial[4],serial[5]);
            }
            System.out.format("+------------------------------------------------------+------------------------------------------------------+---------------------+------------+-----------+--------------------+%n");
        }catch (FileNotFoundException e){
            System.out.println("No se encuentra el archivo");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
