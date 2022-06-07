package com.itver;

import java.io.*;

public class MenuClientes extends Menu {
    public MenuClientes(String textoMenu,int cantOpciones) {
        super(textoMenu,cantOpciones);
    }

    @Override
    public void seleccionarOpcion(int op){
        switch (op) {
            case 1 -> {
                Cliente nuevoCliente = new Cliente();
                nuevoCliente.leer(lector);
                nuevoCliente.guardar();
            }
            case 2 -> Cliente.mostrarClientes();
            case 3 -> cerrar();
        }
    }
}
