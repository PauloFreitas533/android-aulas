package com.wolneyhqf.formapp.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.wolneyhqf.formapp.R;
import com.wolneyhqf.formapp.modelo.Aluno;

import java.util.List;

/**
 * Created by wolney on 23/09/17.
 */

public class AlunosAdapter extends BaseAdapter {

    private List<Aluno> alunos;
    private Context context;

    public AlunosAdapter(List<Aluno> alunos, Context context){
        this.alunos = alunos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int i) {
        return alunos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.listview_alunos, viewGroup, false);
        TextView textViewNome = (TextView) view.findViewById(R.id.texview_nome_aluno);
        TextView textViewMatricula = (TextView) view.findViewById(R.id.texview_matricula_aluno);
        TextView textViewEmail = (TextView) view.findViewById(R.id.texview_email_aluno);

        Aluno aluno = alunos.get(i);
        textViewNome.setText(aluno.getNome().toString());
        textViewMatricula.setText(aluno.getMatricula().toString());
        textViewEmail.setText(aluno.getEmail().toString());

        return view;
    }
}
