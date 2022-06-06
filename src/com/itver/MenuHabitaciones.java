package com.itver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MenuHabitaciones extends Menu{

    public MenuHabitaciones(BufferedReader lector, String textoMenu,int cantOpciones) {
        super(lector, textoMenu,cantOpciones);
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
                System.out.println("Habitación reservada");
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
                        String serial[] = line.split(";");
                        System.out.format(leftAlignFormat,serial[0],serial[1],serial[2],serial[3],serial[4],serial[5]);
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
