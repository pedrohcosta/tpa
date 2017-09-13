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
public class Endereco {
    private String cep;
    private String endereco;
    private String bairro;
    private String cidade;
    private String UF;

    public Endereco(String cep, String endereco, String bairro, String cidade, String UF) {
        this.cep = cep;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.UF = UF;
    }

    public String getCep() {
        return cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUF() {
        return UF;
    }
    
}
