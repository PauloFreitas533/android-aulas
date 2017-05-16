package br.com.wolneyhqf.aulas.persistencia.model.entidade;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wolney on 12/05/17.
 */

public class Livro implements Parcelable {

    private long id;
    private String titulo;
    private String autor;
    private String editora;
    private int ano;

    public Livro(){}

    private Livro(Parcel p){
        id = p.readLong();
        titulo = p.readString();
        autor = p.readString();
        editora = p.readString();
        ano = p.readInt();
    }

    public static final Parcelable.Creator<Livro> CREATOR = new Parcelable.Creator<Livro>() {
        public Livro createFromParcel(Parcel p) {
            return new Livro(p);
        }

        public Livro[] newArray(int size) {
            return new Livro[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel p, int flags) {
        p.writeLong(id);
        p.writeString(titulo);
        p.writeString(autor);
        p.writeString(editora);
        p.writeInt(ano);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
