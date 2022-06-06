package com.itver;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;

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
                                    ObjectOutputStreamModificado osm = new ObjectOutputStreamModificado(new FileOutputStream("./Clientes.dat",true));
                                    osm.writeObject(nuevoCliente);
                                    osm.close();
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
                System.out.println("Clientes mostrados");
                break;
            case 3:
                cerrar();
                break;
        }
    }
}
