package com.itver;

import java.io.BufferedReader;
import java.io.IOException;

public class MenuClientes extends Menu {
    public MenuClientes(BufferedReader lector, String textoMenu,int cantOpciones) {
        super(lector, textoMenu,cantOpciones);
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
