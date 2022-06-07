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
        switch (op) {
            case 1 -> {
                Alquiler nuevoAlquiler = new Alquiler();
                nuevoAlquiler.leer(lector);
                nuevoAlquiler.guardar();
            }
            case 2 -> {
                Reservacion nuevaReservacion = new Reservacion();
                nuevaReservacion.leer(lector);
                nuevaReservacion.guardar();
            }
            case 3 -> Alquiler.mostrarAlquileres();
            case 4 -> Reservacion.mostrarReservaciones();
            case 5 -> cerrar();
        }
    }
}
