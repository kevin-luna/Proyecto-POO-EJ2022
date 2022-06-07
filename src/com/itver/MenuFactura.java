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
        Factura factura = new Factura();
        factura.leer(lector);
        factura.guardar();
    }


}
