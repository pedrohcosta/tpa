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
public class ItemTabHash {

    private Object key;
    private Object element;

    public ItemTabHash(Object key, Object element) {
        this.key = key;
        this.element = element;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

}
