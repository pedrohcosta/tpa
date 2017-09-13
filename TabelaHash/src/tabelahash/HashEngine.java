/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelahash;

/**
 *
 * @author PedroBook
 */
public class HashEngine {

    public int h(Object key, int tam) {
        double novoValor = 0;
        int base = 33;
        String v = key.toString();

        for (int i = 0; i < v.length(); i++) {
            int result = v.codePointAt(i);
            novoValor += Math.pow(base, i) * result;
        }
        return (int) (novoValor % tam);
    }

}
