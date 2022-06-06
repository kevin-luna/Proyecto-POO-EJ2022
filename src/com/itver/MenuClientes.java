package com.itver;

import java.io.*;

public class MenuClientes extends Menu {
    public MenuClientes(BufferedReader lector, String textoMenu,int cantOpciones) {
        super(lector, textoMenu,cantOpciones);
    }

    @Override
    public void seleccionarOpcion(int op){
        switch (op){
            case 1:
                Cliente nuevoCliente=new Cliente();
                nuevoCliente.leer(lector);
                nuevoCliente.guardar("./Clientes.txt");
                break;
            case 2:
                try{
                    BufferedReader fr = new BufferedReader(new FileReader("./Clientes.txt"));
                    String leftAlignFormat = "| %-52s | %-52s | %-19s | %-9s | %-18s |%n";
                    System.out.format("+------------------------------------------------------+------------------------------------------------------+---------------------+-----------+--------------------+%n");
                    System.out.format("| Nombre                                               | Apellido                                             | Fecha de Nacimiento | RFC       | Metodo de pago     |%n");
                    System.out.format("+------------------------------------------------------+------------------------------------------------------+---------------------+-----------+--------------------+%n");
                    String line;
                    while((line=fr.readLine())!=null){
                        String serial[] = line.split(";");
                        System.out.format(leftAlignFormat,serial[0],serial[1],serial[2],serial[3],serial[4]);
                    }
                    System.out.format("+------------------------------------------------------+------------------------------------------------------+---------------------+-----------+--------------------+%n");
                }catch (FileNotFoundException e){
                    System.out.println("No se encuentra el archivo");
                }catch (IOException e){
                    e.printStackTrace();
                }
                break;
            case 3:
                cerrar();
                break;
        }
    }
}
