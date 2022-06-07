package com.itver;

import java.io.BufferedReader;

public class MenuPrincipal extends Menu{
    public MenuPrincipal(String textoMenu,int cantOpciones) {
        super(textoMenu,cantOpciones);
    }

    @Override
    public void seleccionarOpcion(int opcion){
        switch (opcion) {
            case 1 -> {
                MenuClientes menuClientes = new MenuClientes("Gestión de clientes\n\n¿Qué desea hacer?:\n1. Agregar clientes\n2. Ver la lista de clientes\n3. Regresar al menú anterior\n", 3);
                menuClientes.iniciar();
            }
            case 2 -> {
                MenuAlquileresYReservaciones menuAlquileresYReservaciones = new MenuAlquileresYReservaciones("Gestión de habitaciones\n\n¿Qué desea hacer?\n1. Alquilar una habitación\n2. Reservar una habitación\n3. Ver habitaciones alquiladas\n4. Ver reservaciones\n5. Regresar al menú anterior", 5);
                menuAlquileresYReservaciones.iniciar();
            }
            case 3 -> {
                MenuFactura menuFactura = new MenuFactura("", 3);
                menuFactura.iniciar();
            }
            case 4 -> cerrar();
        }
    }
}
