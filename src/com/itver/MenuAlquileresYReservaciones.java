package com.itver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MenuAlquileresYReservaciones extends Menu{

    public MenuAlquileresYReservaciones(String textoMenu, int cantOpciones) {
        super(textoMenu,cantOpciones);
    }

    @Override
    public void seleccionarOpcion(int op){
        switch (op){
            case 1:
                Alquiler nuevoAlquiler = new Alquiler();
                nuevoAlquiler.leer(lector);
                nuevoAlquiler.guardar("./RegistroAlquiler.txt");
                break;
            case 2:
                Reservacion nuevaReservacion = new Reservacion();
                nuevaReservacion.leer(lector);
                nuevaReservacion.guardar("./RegistroReservaciones.txt");
                break;
            case 3:
                try{
                    BufferedReader fr = new BufferedReader(new FileReader("./RegistroAlquiler.txt"));
                    String leftAlignFormat = "| %-52s | %-52s | %-20s | %-18s | %-18s | %-18s |%n";
                    System.out.format("+------------------------------------------------------+------------------------------------------------------+----------------------+--------------------+--------------------+--------------------+%n");
                    System.out.format("| Nombre del cliente                                   | Apellido                                             | Número de habitación | Número de teléfono | Fecha de llegada   | Fecha de salida    |%n");
                    System.out.format("+------------------------------------------------------+------------------------------------------------------+----------------------+--------------------+--------------------+--------------------+%n");
                    String line;
                    while((line=fr.readLine())!=null){
                        String[] datosAlquiler = line.split(";");
                        System.out.format(leftAlignFormat,datosAlquiler[0],datosAlquiler[1],datosAlquiler[2],datosAlquiler[3],datosAlquiler[4],datosAlquiler[5]);
                    }
                    System.out.format("+------------------------------------------------------+------------------------------------------------------+----------------------+--------------------+--------------------+--------------------+%n");
                }catch (FileNotFoundException e){
                    System.out.println("No se encuentra el archivo");
                }catch (IOException e){
                    e.printStackTrace();
                }
                break;
            case 4:

                break;
            case 5:
                cerrar();
                break;
        }
    }
}
