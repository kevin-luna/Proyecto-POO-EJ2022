package com.itver;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {
    final private Cliente cliente;
    final private Cargo[] cargos;
    final private float total;

    public Factura(Cliente cliente, Cargo[] cargos, float total) {
        this.cliente = cliente;
        this.cargos = cargos;
        this.total = total;
    }

    public void guardar(){
        Date date = new Date(System.currentTimeMillis());
        try{
            FileWriter fw = new FileWriter("./Facturas/"+(new SimpleDateFormat("dd-MM-yyyy-HH-mm").format(date))+".txt");
            fw.write("---FACTURA---\n");
            fw.write("HOTEL LOS OLIVOS\n\n");
            fw.write(new SimpleDateFormat("dd-MM-yyyy 'a las' HH:mm").format(date)+"\n\n");
            fw.write("Cliente: "+this.cliente.getNombre()+" "+this.cliente.getApellido()+"\n");
            fw.write("RFC: "+this.cliente.getRFC()+"\n");
            fw.write("Método de pago: "+this.cliente.getMetodoPago()+"\n\n");
            fw.write("    Cargo    |    Descripción    |     Precio    \n");
            for (Cargo cargo : this.cargos) {
                fw.write(cargo.getConcepto() + "    " + cargo.getDescripcion() + "    $" + cargo.getPrecio() + "\n");
            }
            fw.write("\nTotal: $"+this.total+" pesos mexicanos (MXN).\n");
            fw.close();
            System.out.println("Factura generada exitosamente.");
        }catch (IOException e){
            System.out.println("Ocurrió un error al generar la factura.");
        }
    }
}
