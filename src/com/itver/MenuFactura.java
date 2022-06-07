package com.itver;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class MenuFactura extends Menu{
    public MenuFactura(String textoMenu,int cantOpciones) {
        super(textoMenu,cantOpciones);
    }

    @Override
    public void iniciar() {
        this.leerDatos();
    }


    public void leerDatos(){
        int cargos=0;
        do{
            try {
                System.out.println("Ingrese el RFC del cliente:");
                String rfcCliente = lector.readLine();

                Cliente clienteFactura = BuscadorCliente.buscar(rfcCliente);
                if(clienteFactura==null) break;

                System.out.println("Generando factura para "+clienteFactura.getNombre()+" "+clienteFactura.getApellido());

                System.out.println("¿Cuántos cargos se harán?");
                cargos = Integer.parseInt(lector.readLine());
                Cargo[] listaCargos = new Cargo[cargos];
                float total = 0;
                for (int i = 0; i < cargos; i++) {
                    listaCargos[i]= new Cargo();
                    System.out.println("Ingrese el concepto:");
                    listaCargos[i].setConcepto(lector.readLine());
                    System.out.println("Ingrese el precio:");
                    listaCargos[i].setPrecio(Float.parseFloat(lector.readLine()));
                    total+=listaCargos[i].getPrecio();
                    System.out.println("Ingrese la descripción del concepto (Opcional):");
                    listaCargos[i].setDescripcion(lector.readLine());
                }
                Factura factura = new Factura(clienteFactura,listaCargos,total);
                factura.guardar();
            }catch (NumberFormatException e){
                System.out.println("Solo se pueden ingresar números enteros positivos.");
            } catch (IOException e){
                System.out.println("Ocurrió un error al leer los datos");
            }
        }while(cargos<1);
    }

}
