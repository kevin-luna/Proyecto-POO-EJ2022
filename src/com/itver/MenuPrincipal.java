package com.itver;

import java.io.BufferedReader;
import java.io.IOException;

public class MenuPrincipal extends Menu{
    public MenuPrincipal(BufferedReader lector, String textoMenu,int cantOpciones) {
        super(lector, textoMenu,cantOpciones);
    }

    @Override
    public void seleccionarOpcion(int opcion){
        switch (opcion){
            case 1:
                MenuClientes menuClientes = new MenuClientes(this.lector,"Gestión de clientes\n\n¿Qué desea hacer?:\n1. Agregar clientes\n2. Ver la lista de clientes\n3. Regresar al menú anterior\n",3);
                menuClientes.iniciar();
                break;
            case 2:
                MenuHabitaciones menuHabitaciones = new MenuHabitaciones(this.lector,"Gestión de habitaciones\n\n¿Qué desea hacer?\n1. Alquilar una habitación\n2. Reservar una habitación\n3. Regresar al menú anterior",3);
                menuHabitaciones.iniciar();
                break;
            case 3:
                MenuEmpleados menuEmpleados = new MenuEmpleados(this.lector,"Gestión de empleados\n\n¿Qué desea hacer?\n1. Agregar un empleado\n2. Ver la lista de empleados\n3. Regresar al menú anterior",3);
                menuEmpleados.iniciar();
                break;
            case 4:
                MenuFactura menuFactura = new MenuFactura(this.lector,"",3);
                menuFactura.iniciar();
                break;
            case 5:
                cerrar();
                break;
        }
    }
}
