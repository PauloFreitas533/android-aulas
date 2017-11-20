package com.wolneyhqf.aulas.wsretrofit.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wolney on 15/11/17.
 */

public class Seriado implements Parcelable {

    private Long id;

    private String nome;

    private String periodoProducao;

    private String genero;

    private String elenco;

    private String urlImagem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPeriodoProducao() {
        return periodoProducao;
    }

    public void setPeriodoProducao(String periodoProducao) {
        this.periodoProducao = periodoProducao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(nome);
        parcel.writeString(periodoProducao);
        parcel.writeString(genero);
        parcel.writeString(elenco);
        parcel.writeString(urlImagem);
    }

    public void readFromParcel(Parcel parcel){
        this.id = parcel.readLong();
        this.nome = parcel.readString();
        this.periodoProducao = parcel.readString();
        this.genero = parcel.readString();
        this.elenco = parcel.readString();
        this.urlImagem = parcel.readString();
    }

    public static final Parcelable.Creator<Seriado> CREATOR = new Parcelable.Creator<Seriado>(){
        @Override
        public Seriado createFromParcel(Parcel parcel){
            Seriado seriado = new Seriado();
            seriado.readFromParcel(parcel);
            return seriado;
        }

        @Override
        public Seriado[] newArray(int size){
            return new Seriado[size];
        }
    };

}
