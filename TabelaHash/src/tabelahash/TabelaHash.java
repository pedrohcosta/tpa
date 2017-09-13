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
public class TabelaHash {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Endereco e = new Endereco("29043-528", "Praça Anita Francisca Crystello", "Tabuazeiro", "Vitória", "ES");
        
        TADDicEA tADDicEA = new TADDicEA(new HashSomaPolinomial());
        
        Endereco end1 = (Endereco) tADDicEA.findElement("123");
        if (end1 != null) {
            System.out.println(end1.getBairro());
        }
        
        tADDicEA.insertItem("29043-528", e);
        
       /* Endereco end1 = tADDicEA.findElement("123");
        if (end1 != null) {
            System.out.println(end1.getBairro());
        }
        
        tADDicEA.insertItem("29043-528", e);
        Endereco end2 = tADDicEA.findElement("29043-528");
        if (end2 != null) {
            System.out.println(end2.getBairro());
        }
        */
//        if ((tADDicEA.findElement("123") instanceof ItemTabHash)) {
//            System.out.println("Not Object");
//        }
//        System.out.println("");
//
//        tADDicEA.insertItem("29043-528", e);

        //tADDicEA.insertItem("29043-528", new Object[]{"Praça Anita Francisca Crystello", "Tabuazeiro", "Vitória, ES"});

//        Object result = tADDicEA.findElement("29043-528");
//
//        if (!(result instanceof ItemTabHash)) {
//            System.out.println(((Object[]) result)[0]);
//        }
//        
//        System.out.println("Tam: "+ tADDicEA.size());
//        System.out.println("Empty: "+ tADDicEA.isEmpty());
//        
        //tADDicEA.removeElement("29043-528");
        
        //System.out.println("Tam: "+ tADDicEA.size());
        //System.out.println("Empty: "+ tADDicEA.isEmpty());
        
//        Object[] list = tADDicEA.keys();
//        for (Object object : list) {
//            System.out.println(object);
//        }
//        
        
    }

}
