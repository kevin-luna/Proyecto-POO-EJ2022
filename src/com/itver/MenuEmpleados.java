package com.itver;

import java.io.BufferedReader;

public class MenuEmpleados extends Menu{

    public MenuEmpleados(BufferedReader lector, String textoMenu,int cantOpciones) {
        super(lector, textoMenu,cantOpciones);
    }

    @Override
    public void seleccionarOpcion(int op){
        switch (op){
            case 1:
                System.out.println("Empleado agregado");
                break;
            case 2:
                System.out.println("Empleados mostrados");
                break;
            case 3:
                cerrar();
                break;
        }
    }
}
