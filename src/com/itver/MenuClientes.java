package com.itver;

import java.io.BufferedReader;
import java.io.IOException;

public class MenuClientes extends Menu {
    public MenuClientes(BufferedReader lector, String textoMenu) {
        super(lector, textoMenu);
    }

    @Override
    public void leerOpcion(){
        int opcion=0;
        System.out.print("->");
        do{
            try{
                opcion=Integer.parseInt(lector.readLine());
            }catch (IOException e){
                System.out.println("Ocurrio un error al leer la entrada");
            }
        }while(opcion<1 && opcion>3);

        seleccionarOpcion(opcion);
    }

    @Override
    public void seleccionarOpcion(int op){
        switch (op){
            case 1:
                System.out.println("Cliente agregado");
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
