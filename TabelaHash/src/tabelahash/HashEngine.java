/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelahash;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author PedroBook
 */
public class HashEngine {

    private byte[] getByteArray(Object key) {
        
        byte[] bytes = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(key);
            objectOutputStream.flush();
            objectOutputStream.close();
            byteArrayOutputStream.close();
            bytes = byteArrayOutputStream.toByteArray();
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int h(Object key, int tam) {
        double novoValor = 0;
        int base = 33;
        byte[] bytes =  getByteArray(key);

        for (int i = 0; i < bytes.length; i++) {
            int result = bytes[i];
            novoValor += Math.pow(base, i) * result;
        }
        return (int) (novoValor % tam);
    }

}
