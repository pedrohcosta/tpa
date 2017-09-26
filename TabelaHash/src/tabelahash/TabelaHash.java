/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelahash;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

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

//        TADDicChain tADDicChain = new TADDicChain();
//        
//        tADDicChain.insertItem("29043-528", "Praça Anita Francisca Crystello");
//        tADDicChain.insertItem("19043-558", "Pal de Santa Rita");
//        
        /*Object o = tADDicChain.findElement("29043-528");
        
        if (o instanceof ItemTabHash){
            System.out.println("---");
        } else {
            System.out.println(o);
        }*/
//        Object[] list = tADDicChain.elements();
//        for (Object object : list) {
//            System.out.println(object);
//        }
        //Endereco e = new Endereco("29043-528", "Praça Anita Francisca Crystello", "Tabuazeiro", "Vitória", "ES");
        TADDicEA tADDicEA = new TADDicEA();
        String nomeArquivo = "vix-ruas-ceps.txt";

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nomeArquivo), "ISO-8859-1"));
            while (br.ready()) {
                String[] array = br.readLine().split(";");
               // for (int i = 1; i < array.length; i++) {
                    if (array.length > 0) {
                         String cep = array[0].trim();
                         String endereco = array[1].trim();
                         String bairro = array[2].trim();
                         String cidade = array[3].trim();

                         Endereco end = new Endereco(cep, endereco, bairro, cidade);
                         Object r = tADDicEA.insertItem(cep, end);
                    }
                   
                   // System.out.println(r);
//                   if (!(boolean)r){
//                       return;
//                   }
               // }
            }

            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        System.out.println(tADDicEA.size());
        /* Object result = tADDicEA.findElement("29043-528");
        if (!(result instanceof ItemTabHash)) {
            System.out.println(result);
        }
         */
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
