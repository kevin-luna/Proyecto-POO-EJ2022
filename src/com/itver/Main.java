package com.itver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        MenuPrincipal menuPrincipal = new MenuPrincipal(
                "---Bienvenido al sistema---\n\n¿Qué desea hacer?:\n1. Gestionar clientes\n2. Gestionar alquileres y reservaciones\n3. Imprimir una factura\n4. Salir",4);
        menuPrincipal.iniciar();
        System.out.println("Saliendo...");
        System.out.println("¡Hasta pronto!");
    }
}
