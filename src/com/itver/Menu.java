package com.itver;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class Menu {
    protected final BufferedReader lector;
    protected final String textoMenu;
    protected final int cantOpciones;

    protected boolean salir=false;

    public Menu(final BufferedReader lector, final String textoMenu, final int cantOpciones) {
        this.lector = lector;
        this.textoMenu = textoMenu;
        this.cantOpciones=cantOpciones;
    }

    public void iniciar(){
        while (!salir){
            mostrar();
            leerOpcion();
        }
    }

    public void leerOpcion(){
        int opcion=0;
        do{
            System.out.print("->");
            try{
                opcion=Integer.parseInt(lector.readLine());
            }catch (IOException e){
                System.out.println("Ocurrio un error al leer la entrada");
            }catch (NumberFormatException e){
                System.out.println("Solo puede ingresar un número entero");
            }
        }while(opcion<1 && opcion>cantOpciones);
        seleccionarOpcion(opcion);
    };

    public abstract void seleccionarOpcion(int op);

    public void mostrar(){
        System.out.println(textoMenu);
    }

    public void cerrar(){
        salir=true;
    }
}
