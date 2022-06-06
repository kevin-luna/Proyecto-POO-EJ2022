package com.itver;

import java.io.BufferedReader;
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
                cerrar();
                break;
        }
    }
}
