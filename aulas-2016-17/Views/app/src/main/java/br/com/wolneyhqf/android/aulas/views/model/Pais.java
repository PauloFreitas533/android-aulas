package br.com.wolneyhqf.android.aulas.views.model;

/**
 * Created by wolney on 22/09/16.
 */

public class Pais {

    private int id;
    private String nome;
    private int bandeira;

    public Pais(int id, String nome, int bandeira){
        this.id = id;
        this.nome = nome;
        this.bandeira = bandeira;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
