/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelahash;

/**
 * @author PedroBook
 */
public class TADDicEA {

    private static ItemTabHash NO_SUCH_KEY = new ItemTabHash(null, null);
    private HashEngine hashEngine;

    private ItemTabHash[] vetBuckets;
    private int tam;
    private int tamVetBuckets;
    
    public TADDicEA(int tamanho, HashEngine hashEngine) {
        this.tamVetBuckets = tamanho;
        vetBuckets = new ItemTabHash[this.tamVetBuckets];
        this.hashEngine = hashEngine;
        tam = 0;
    }

    public TADDicEA() {
        this.tamVetBuckets = 64;
        vetBuckets = new ItemTabHash[this.tamVetBuckets];
        this.hashEngine = new HashEngine();
        tam = 0;
    }
    
    public TADDicEA(HashEngine hashEngine) {
        this.tamVetBuckets = 64;
        vetBuckets = new ItemTabHash[this.tamVetBuckets];
        this.hashEngine = hashEngine;
        tam = 0;
    }

    public Object findElement(Object k) {
        int i = hashEngine.h(k, this.tamVetBuckets);
        int p = 0;

        do {
            ItemTabHash c = vetBuckets[i];
            if (c == null) {
                return NO_SUCH_KEY;
            } else if (c.getKey() == k) {
                return c.getElement();
            } else {
                i = (i + 1) % tamVetBuckets;
                p += 1;
            }
        } while (p != tamVetBuckets);

        return NO_SUCH_KEY;
    }

    public Object insertItem(Object k, Object o) {
        int i = hashEngine.h(k, this.tamVetBuckets);
        int p = 0;

        do {
            ItemTabHash c = vetBuckets[i];
            if (c == null) {
                vetBuckets[i] = new ItemTabHash(k, o);
                this.tam++;
                return true;
            } else if (c.getKey() == k) {//caso alteração
                vetBuckets[i].setElement(o);
                return true;
            } else {
                i = (i + 1) % tamVetBuckets;
                p += 1;
            }
        } while (p != tamVetBuckets);

        return false;
    }

    public Object removeElement(Object k) {
        int i = hashEngine.h(k, this.tamVetBuckets);
        int p = 0;

        do {
            ItemTabHash c = vetBuckets[i];
            if (c.getKey() == k) {
                vetBuckets[i] = null;
                this.tam--;
                return true;
            } else {
                i = (i + 1) % tamVetBuckets;
                p += 1;
            }
        } while (p != tamVetBuckets);
        return false;
    }

    public int size() {
        return tam;
    }

    public boolean isEmpty() {
        return (tam < 1);
    }

    public Object[] keys() {
        Object[] vet = new Object[this.tam];
        int i = 0;
        for (ItemTabHash vetBucket : this.vetBuckets) {
            if (vetBucket != null) {
                vet[i] = vetBucket.getKey();
                i++;
            }
        }

        return vet;
    }

    public Object[] elements() {
        Object[] vet = new Object[this.tam];
        int i = 0;
        for (ItemTabHash vetBucket : this.vetBuckets) {
            if (vetBucket != null) {
                vet[i] = vetBucket.getElement();
                i++;
            }
        }
        return vet;
    }

    private void redimensionar() {
        double v = this.tamVetBuckets * 0.8;

        if (this.tam >= v) {

            //copia para vetor auxiliar
            ItemTabHash[] vetBucketsAux = new ItemTabHash[this.tamVetBuckets];
            for (int i = 0; i < this.vetBuckets.length; i++) {
                vetBucketsAux[i] = this.vetBuckets[i];
            }

            this.tamVetBuckets += 100;
            this.vetBuckets = new ItemTabHash[this.tamVetBuckets];
            
            //recalcula os hash
            for (ItemTabHash itemTabHash : vetBucketsAux) {
                insertItem(itemTabHash.getKey(), itemTabHash.getElement());
            }
            
        }

    }
}
