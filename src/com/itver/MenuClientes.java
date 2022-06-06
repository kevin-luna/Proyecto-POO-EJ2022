package com.itver;

import java.io.*;

public class MenuClientes extends Menu {
    public MenuClientes(BufferedReader lector, String textoMenu,int cantOpciones) {
        super(lector, textoMenu,cantOpciones);
    }

    @Override
    public void seleccionarOpcion(int op){
        switch (op){
            case 1:
                int cantClientes=0;
                do{
                    try {
                        System.out.println("¿Cuántos clientes desea registrar?");
                        cantClientes = Integer.parseInt(lector.readLine());
                        for(int i=0;i<cantClientes;i++){
                            String nombre,apellido,fechaNacimiento,RFC,metodoPago;
                            try{
                                System.out.println("Ingrese el nombre del cliente:");
                                nombre = lector.readLine();
                                System.out.println("Ingrese el apellido del cliente:");
                                apellido = lector.readLine();
                                System.out.println("Ingrese la fecha de nacimiento del cliente:");
                                fechaNacimiento=lector.readLine();
                                System.out.println("Ingrese el RFC del cliente:");
                                RFC=lector.readLine();
                                System.out.println("Ingrese el método de pago del cliente:");
                                metodoPago= lector.readLine();
                                Cliente nuevoCliente = new Cliente(nombre,apellido,fechaNacimiento,RFC,metodoPago);
                                try{
                                    FileWriter fw = new FileWriter("./Clientes.txt",true);
                                    fw.write(nuevoCliente.getNombre()+";"+nuevoCliente.getApellido()+";"+nuevoCliente.getFechaNacimiento()+";"+nuevoCliente.getRFC()+";"+nuevoCliente.getMetodoPago()+"\n");
                                    fw.close();
                                    System.out.println("Cliente registrado correctamente.");
                                }catch (IOException e){
                                    System.out.println("Ocurrió un error al intentar escribir en el archivo.");
                                }
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
                break;
            case 2:
                try{
                    BufferedReader fr = new BufferedReader(new FileReader("./Clientes.txt"));
                    //System.out.println("|Nombre\t|\tApellido\t|\tFecha de nacimiento\t|\tRFC\t|\tMétodo de pago|");
                    String leftAlignFormat = "| %-52s | %-52s | %-19s | %-9s | %-18s |%n";
                    System.out.format("+------------------------------------------------------+------------------------------------------------------+---------------------+-----------+--------------------+%n");
                    System.out.format("| Nombre                                               | Apellido                                             | Fecha de Nacimiento | RFC       | Metodo de pago     |%n");
                    System.out.format("+------------------------------------------------------+------------------------------------------------------+---------------------+-----------+--------------------+%n");
                    String line;
                    while((line=fr.readLine())!=null){
                        String serial[] = line.split(";");
                        System.out.format(leftAlignFormat,serial[0],serial[1],serial[2],serial[3],serial[4]);
                    }
                    System.out.format("+------------------------------------------------------+------------------------------------------------------+---------------------+-----------+--------------------+%n");
                }catch (FileNotFoundException e){
                    System.out.println("No se encuentra el archivo");
                }catch (IOException e){
                    e.printStackTrace();
                }
                break;
            case 3:
                cerrar();
                break;
        }
    }
}
