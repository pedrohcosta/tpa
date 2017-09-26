/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelahash;

import java.util.LinkedList;

/**
 * @author PedroBook
 */
public class TADDicEA extends TADDic {

    private ItemTabHash[] vetBuckets;

    public TADDicEA(int tamanho, HashEngine hashEngine) {
        super(tamanho, hashEngine);
        vetBuckets = new ItemTabHash[this.tamVetBuckets];
    }

    public TADDicEA() {
        super();
        vetBuckets = new ItemTabHash[this.tamVetBuckets];
    }

    public TADDicEA(HashEngine hashEngine) {
        super(hashEngine);
        vetBuckets = new ItemTabHash[this.tamVetBuckets];
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

    public boolean insertItem(Object k, Object o) {
        int i = hashEngine.h(k, this.tamVetBuckets);
        int p = 0;

        redimensionar();

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

    //retornar objecto ou chave não encontrada
    public Object removeElement(Object k) {
        int i = hashEngine.h(k, this.tamVetBuckets);
        int p = 0;

        do {
            ItemTabHash c = vetBuckets[i];
            if (c.getKey() == k) {
                vetBuckets[i] = null;
                this.tam--;
                return c.getElement();
            } else {
                i = (i + 1) % tamVetBuckets;
                p += 1;
            }
        } while (p != tamVetBuckets);
        return NO_SUCH_KEY;
    }

    public LinkedList<Object> keys() {
        LinkedList vet = new LinkedList();
        for (ItemTabHash vetBucket : this.vetBuckets) {
            if (vetBucket != null) {
                vet.add(vetBucket.getKey());
            }
        }

        return vet;
    }

    public LinkedList<Object> elements() {
        LinkedList vet = new LinkedList();
        for (ItemTabHash vetBucket : this.vetBuckets) {
            if (vetBucket != null) {
                vet.add(vetBucket.getElement());
            }
        }
        return vet;
    }

    public void redimensionar() {
        double v = this.tamVetBuckets * 0.8;

        if (this.tam >= v) {

            //copia para vetor auxiliar
            ItemTabHash[] vetBucketsAux = new ItemTabHash[this.tamVetBuckets];
            for (int i = 0; i < this.vetBuckets.length; i++) {
                vetBucketsAux[i] = this.vetBuckets[i];
            }

            this.tamVetBuckets += 100;
            this.vetBuckets = new ItemTabHash[this.tamVetBuckets];
            this.tam = 0;

            //recalcula os hash
            for (ItemTabHash itemTabHash : vetBucketsAux) {
                if (itemTabHash != null) {
                    insertItem(itemTabHash.getKey(), itemTabHash.getElement());
                }
            }

        }

    }
}
