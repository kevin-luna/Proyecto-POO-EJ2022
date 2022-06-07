package com.itver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BuscadorCliente {
    public static Cliente buscar(String rfc){
        try{
            Cliente clienteFactura = new Cliente();
            BufferedReader fileReader = new BufferedReader(new FileReader("./Clientes.txt"));
            String tmp;

            while ((tmp=fileReader.readLine())!=null){
                String[] obj = tmp.split(";");
                if(rfc.equals(obj[4])){
                    System.out.println("Recuperando datos del cliente...");
                    clienteFactura.setNombre(obj[0]);
                    clienteFactura.setApellido(obj[1]);
                    clienteFactura.setFechaNacimiento(obj[2]);
                    clienteFactura.setTelefono(obj[3]);
                    clienteFactura.setRFC(obj[4]);
                    clienteFactura.setMetodoPago(obj[5]);
                    return clienteFactura;
                }
            }

        }catch (FileNotFoundException e){
            System.out.println("No se encontró el archivo.");
        }catch (IOException e){
            System.out.println("Ocurrio un error al leer el archivo");
        }
        System.out.println("No se encontró el cliente con el RFC ingresado.");
        return null;
    }
}
