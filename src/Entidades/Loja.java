/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author gu_sc
 */
public class Loja {
    
    private String nomeLoja;
    private String endereco;
    private long cep;
    private String uf;
    
    public Loja(String nomeLoja,String endereco,long cep,String uf){
        this.nomeLoja = nomeLoja;
        this.endereco = endereco;
        this.cep = cep;
        this.uf = uf;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public String getEndereco() {
        return endereco;
    }

    public long getCep() {
        return cep;
    }

    public String getUf() {
        return uf;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCep(long cep) {
        this.cep = cep;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    
    
}
