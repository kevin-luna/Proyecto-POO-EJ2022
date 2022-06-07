package com.itver;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {
    private Cliente cliente;
    private Cargo[] cargos;
    private float total;

    public Factura(){}

    public Factura(Cliente cliente, Cargo[] cargos, float total) {
        this.cliente = cliente;
        this.cargos = cargos;
        this.total = total;
    }

    public void leer(BufferedReader bfr){
        int cargos=0;
        do{
            try {
                System.out.println("Ingrese el RFC del cliente:");
                String rfcCliente = bfr.readLine();

                Cliente clienteFactura = BuscadorCliente.buscar(rfcCliente);
                if(clienteFactura==null) break;

                System.out.println("Generando factura para "+clienteFactura.getNombre()+" "+clienteFactura.getApellido());

                System.out.println("¿Cuántos cargos se harán?");
                cargos = Integer.parseInt(bfr.readLine());
                Cargo[] listaCargos = new Cargo[cargos];
                float total = 0;
                for (int i = 0; i < cargos; i++) {
                    listaCargos[i] = new Cargo();
                    System.out.println("Ingrese el concepto:");
                    listaCargos[i].setConcepto(bfr.readLine());
                    System.out.println("Ingrese el precio:");
                    listaCargos[i].setPrecio(Float.parseFloat(bfr.readLine()));
                    total += listaCargos[i].getPrecio();
                    System.out.println("Ingrese la descripción del concepto (Opcional):");
                    listaCargos[i].setDescripcion(bfr.readLine());
                }
                setCliente(clienteFactura);
                setCargos(listaCargos);
                setTotal(total);

            }catch (NumberFormatException e){
                System.out.println("Solo se pueden ingresar números enteros positivos.");
            } catch (IOException e){
                System.out.println("Ocurrió un error al leer los datos");
            }
        }while(cargos<1);
    }

    public void guardar(){
        Date date = new Date(System.currentTimeMillis());
        try{
            FileWriter fw = new FileWriter("./Facturas/"+(new SimpleDateFormat("dd-MM-yyyy-HH-mm").format(date))+".txt");
            fw.write("---FACTURA---\n");
            fw.write("HOTEL LOS OLIVOS\n\n");
            fw.write(new SimpleDateFormat("dd-MM-yyyy 'a las' HH:mm").format(date)+"\n\n");
            fw.write("Cliente: "+cliente.getNombre()+" "+cliente.getApellido()+"\n");
            fw.write("RFC: "+cliente.getRFC()+"\n");
            fw.write("Método de pago: "+cliente.getMetodoPago()+"\n\n");
            fw.write("    Cargo    |    Descripción    |     Precio    \n");
            for (Cargo cargo : cargos) {
                fw.write(cargo.getConcepto() + "    " + cargo.getDescripcion() + "    $" + cargo.getPrecio() + "\n");
            }
            fw.write("\nTotal: $"+total+" pesos mexicanos (MXN).\n");
            fw.close();
            System.out.println("Factura generada exitosamente.");
        }catch (IOException e){
            System.out.println("Ocurrió un error al generar la factura.");
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cargo[] getCargos() {
        return cargos;
    }

    public void setCargos(Cargo[] cargos) {
        this.cargos = cargos;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
