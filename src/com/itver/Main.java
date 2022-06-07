package com.itver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        final BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        MenuPrincipal menuPrincipal = new MenuPrincipal(lector,
                "---Bienvenido al sistema---\n\n¿Qué desea hacer?:\n1. Gestionar clientes\n2. Gestionar habitaciones\n4. Imprimir una factura\n4. Salir",4);
        menuPrincipal.iniciar();
        System.out.println("Saliendo...");
        System.out.println("¡Hasta pronto!");
    }
}
