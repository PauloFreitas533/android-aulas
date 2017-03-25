package br.com.wolneyhqf.aulas.appcampeonatobrasileiro.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by wolney on 21/02/17.
 */

public class Clube implements Parcelable {

    private long id;
    private String nome;
    private String nomeAbreviado;
    private String mascote;
    private Date fundacao;
    private String estadio;
    private int capacidadeEstadio;
    private String pais;
    private String estado;
    private String cidade;

    public Clube(){}

    private Clube(Parcel p){
        nome = p.readString();
    }

    public static final Parcelable.Creator<Clube> CREATOR = new Parcelable.Creator<Clube>() {
        public Clube createFromParcel(Parcel in) {
            return new Clube(in);
        }

        public Clube[] newArray(int size) {
            return new Clube[size];
        }
    };


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeAbreviado() {
        return nomeAbreviado;
    }

    public void setNomeAbreviado(String nomeAbreviado) {
        this.nomeAbreviado = nomeAbreviado;
    }

    public String getMascote() {
        return mascote;
    }

    public void setMascote(String mascote) {
        this.mascote = mascote;
    }

    public Date getFundacao() {
        return fundacao;
    }

    public void setFundacao(Date fundacao) {
        this.fundacao = fundacao;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public int getCapacidadeEstadio() {
        return capacidadeEstadio;
    }

    public void setCapacidadeEstadio(int capacidadeEstadio) {
        this.capacidadeEstadio = capacidadeEstadio;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nome);
    }

}
