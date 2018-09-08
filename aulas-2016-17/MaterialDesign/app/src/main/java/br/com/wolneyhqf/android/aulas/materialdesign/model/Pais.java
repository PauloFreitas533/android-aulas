package br.com.wolneyhqf.android.aulas.materialdesign.model;

/**
 * Created by wolney on 17/10/16.
 */

public class Pais {

    private String nome;
    private int bandeira;

    public Pais(){}

    public Pais(String nome, int bandeira){
        this.nome = nome;
        this.bandeira = bandeira;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getBandeira() {
        return bandeira;
    }

    public void setBandeira(int bandeira) {
        this.bandeira = bandeira;
    }
}
