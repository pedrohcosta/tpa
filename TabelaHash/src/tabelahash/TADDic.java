/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelahash;

import java.util.LinkedList;

/**
 *
 * @author PedroBook
 */
abstract public class TADDic {

    protected int tam;
    protected int tamVetBuckets;
    protected HashEngine hashEngine;
    protected static ItemTabHash NO_SUCH_KEY = new ItemTabHash(null, null);

    public TADDic(int tamanho, HashEngine hashEngine) {
        tamVetBuckets = tamanho;
        this.hashEngine = hashEngine;
        tam = 0;
    }

    public TADDic() {
        this.tamVetBuckets = 64;
        this.hashEngine = new HashEngine();
        tam = 0;
    }

    public TADDic(HashEngine hashEngine) {
        this.tamVetBuckets = 64;
        this.hashEngine = hashEngine;
        tam = 0;
    }

    abstract public Object findElement(Object k);

    abstract public boolean insertItem(Object k, Object o);

    abstract public Object removeElement(Object k);

    abstract public LinkedList<Object> keys();

    abstract public LinkedList<Object> elements();

    abstract public void redimensionar();

    public int size() {
        return tam;
    }

    public boolean isEmpty() {
        return (tam < 1);
    }

}
