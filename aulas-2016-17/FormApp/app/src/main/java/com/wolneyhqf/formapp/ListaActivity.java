package com.wolneyhqf.formapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.wolneyhqf.formapp.adaptadores.AlunosAdapter;
import com.wolneyhqf.formapp.modelo.Aluno;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    private ListView listView;
    private List<Aluno> alunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        listView = (ListView) findViewById(R.id.listview_alunos);
        final List<Aluno> alunos = getAlunos();
        AlunosAdapter adaptador = new AlunosAdapter(alunos, this);

        listView.setAdapter(adaptador);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Aluno aluno = alunos.get(i);
                Intent intent = new Intent(ListaActivity.this, AlunoActivity.class);
                intent.putExtra("aluno", aluno);
                startActivity(intent);
            }
        });
    }

    private List<Aluno> getAlunos(){
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno("José", "1001", "josej@gmail.com"));
        alunos.add(new Aluno("Joana", "1002", "joana@gmail.com"));
        alunos.add(new Aluno("Alberto", "1003", "alberto@gmail.com"));
        alunos.add(new Aluno("Pedro", "1004", "pedro1444@gmail.com"));
        return alunos;
    }

}
