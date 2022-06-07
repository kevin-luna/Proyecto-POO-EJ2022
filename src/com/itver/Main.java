package com.itver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'a las' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        MenuPrincipal menuPrincipal = new MenuPrincipal(
                "---Bienvenido al sistema---\n\n¿Qué desea hacer?:\n1. Gestionar clientes\n2. Gestionar habitaciones\n3. Imprimir una factura\n4. Salir",4);
        menuPrincipal.iniciar();
        System.out.println("Saliendo...");
        System.out.println("¡Hasta pronto!");
    }
}
