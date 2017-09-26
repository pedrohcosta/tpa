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
public class TADDicChain extends TADDic {

    private LinkedList<ItemTabHash>[] vetBuckets;
    private int tamElementos;

    public TADDicChain(int tamanho, HashEngine hashEngine) {
        super(tamanho, hashEngine);
        vetBuckets = new LinkedList[this.tamVetBuckets];
        tamElementos = 0;
    }

    public TADDicChain() {
        super();
        vetBuckets = new LinkedList[this.tamVetBuckets];
        tamElementos = 0;
    }

    public TADDicChain(HashEngine hashEngine) {
        super(hashEngine);
        vetBuckets = new LinkedList[this.tamVetBuckets];
        tamElementos = 0;
    }

    public Object findElement(Object k) {
        int i = hashEngine.h(k, this.tamVetBuckets);

        //  LinkedList<ItemTabHash> l = (LinkedList<ItemTabHash>) vetBuckets[i];
        LinkedList<ItemTabHash> l = vetBuckets[i];
        if (l == null) {
            return NO_SUCH_KEY;
        } else {

            for (ItemTabHash itemTabHash : l) {
                if (itemTabHash.getKey().equals(k)) {
                    return itemTabHash.getElement();
                }
            }
            return NO_SUCH_KEY;
        }
    }

    public boolean insertItem(Object k, Object o) {
        int i = hashEngine.h(k, this.tamVetBuckets);

        LinkedList<ItemTabHash> l = vetBuckets[i];
        if (l == null) {
            if (l == null || l.isEmpty()) {
                vetBuckets[i] = new LinkedList<ItemTabHash>();
                this.tam++;
            }

            ((LinkedList) vetBuckets[i]).add(new ItemTabHash(k, o));

            this.tamElementos++;
            return true;

        } else {//caso alteração

            for (ItemTabHash itemTabHash : l) {
                if (itemTabHash.getKey().equals(k)) {
                    itemTabHash.setElement(o);
                    return true;
                }
            }
            return false;
        }
    }

    public Object removeElement(Object k) {
        int i = hashEngine.h(k, this.tamVetBuckets);

        LinkedList<ItemTabHash> l = vetBuckets[i];
        if (l == null) {
            return false;
        } else {

            for (int j = 0; j < l.size(); j++) {
                ItemTabHash itemTabHash = l.get(j);
                if (itemTabHash.getKey().equals(k)) {
                    ((LinkedList<ItemTabHash>) vetBuckets[i]).remove(j);
                    return itemTabHash;
                }
            }

            return NO_SUCH_KEY;
        }
    }

    public LinkedList<Object> keys() {
        LinkedList vet = new LinkedList();

        for (LinkedList<ItemTabHash> vetBucket : this.vetBuckets) {
            if (vetBucket != null) {
                for (ItemTabHash itemTabHash : vetBucket) {
                    vet.add(itemTabHash.getKey());
                }
            }
        }

        return vet;
    }

    public LinkedList<Object> elements() {
        LinkedList vet = new LinkedList();

        for (LinkedList<ItemTabHash> vetBucket : this.vetBuckets) {
            if (vetBucket != null) {
                for (ItemTabHash itemTabHash : vetBucket) {
                    vet.add(itemTabHash.getElement());
                }
            }
        }

        return vet;
    }

    public void redimensionar() {
        double v = this.tamVetBuckets * 0.8;

        if (this.tam >= v) {

            //copia para vetor auxiliar
            LinkedList<ItemTabHash>[] vetBucketsAux = new LinkedList[this.tamVetBuckets];
            for (int i = 0; i < this.vetBuckets.length; i++) {
                vetBucketsAux[i] = this.vetBuckets[i];
            }

            this.tamVetBuckets += 100;
            this.vetBuckets = new LinkedList[this.tamVetBuckets];
            this.tam = 0;
            this.tamElementos = 0;

            //recalcula os hash
            for (LinkedList<ItemTabHash> linkedList : vetBucketsAux) {
                if (linkedList != null) {
                    for (ItemTabHash itemTabHash : linkedList) {
                        insertItem(itemTabHash.getKey(), itemTabHash.getElement());
                    }
                }
            }
        }

    }
}
