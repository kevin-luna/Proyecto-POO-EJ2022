package com.itver;

import java.io.BufferedReader;

public abstract class Menu {
    protected final BufferedReader lector;
    protected final String textoMenu;

    protected boolean salir=false;

    public Menu(final BufferedReader lector, final String textoMenu) {
        this.lector = lector;
        this.textoMenu = textoMenu;
    }

    public void iniciar(){
        while (!salir){
            mostrar();
            leerOpcion();
        }
    }

    public abstract void leerOpcion();

    public abstract void seleccionarOpcion(int op);

    public void mostrar(){
        System.out.println(textoMenu);
    }

    public void cerrar(){
        salir=true;
    }
}
