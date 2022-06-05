package com.itver;

import java.io.BufferedReader;
import java.io.IOException;

public class MenuPrincipal extends Menu{
    public MenuPrincipal(BufferedReader lector, String textoMenu) {
        super(lector, textoMenu);
    }
    @Override
    public void leerOpcion() {
        int opcion=0;
            do{
                System.out.print("->");
                try{
                    opcion=Integer.parseInt(lector.readLine());
                }catch (IOException e){
                    System.out.println("Ocurrio un error al leer la entrada");
                }
            }while(opcion<1 && opcion>5);
            seleccionarOpcion(opcion);

    }

    @Override
    public void seleccionarOpcion(int opcion){
        switch (opcion){
            case 1:
                MenuClientes menuClientes = new MenuClientes(this.lector,"Gestión de clientes\n\n¿Qué desea hacer?:\n1. Agregar un cliente\n2. Ver la lista de clientes\n3. Regresar al menú anterior\n");
                menuClientes.iniciar();
                break;
            case 2:
                MenuHabitaciones menuHabitaciones = new MenuHabitaciones(this.lector,"");
                menuHabitaciones.iniciar();
                break;
            case 3:
                MenuEmpleados menuEmpleados = new MenuEmpleados(this.lector,"");
                menuEmpleados.iniciar();
                break;
            case 4:
                MenuFactura menuFactura = new MenuFactura(this.lector,"");
                menuFactura.iniciar();
                break;
            case 5:
                cerrar();
                break;
        }
    }
}
