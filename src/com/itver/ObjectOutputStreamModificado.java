package com.itver;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectOutputStreamModificado extends ObjectOutputStream {
    ObjectOutputStreamModificado(OutputStream out) throws IOException {
        super(out);
    }

    ObjectOutputStreamModificado() throws IOException, SecurityException {
    }

    @Override
    public void writeStreamHeader(){
        return;
    }
}
