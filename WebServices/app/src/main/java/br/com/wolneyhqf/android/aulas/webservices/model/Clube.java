package br.com.wolneyhqf.android.aulas.webservices.model;

/**
 * Created by Wolney on 25/11/2016.
 */

public class Clube {

    private String nome;
    private String estado;
    private String estadio;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    @Override
    public String toString(){
        return nome;
    }
}
