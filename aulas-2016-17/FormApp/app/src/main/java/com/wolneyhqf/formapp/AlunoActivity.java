package com.wolneyhqf.formapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.wolneyhqf.formapp.modelo.Aluno;

public class AlunoActivity extends AppCompatActivity {

    private TextView textViewNome;
    private TextView textViewEmail;
    private TextView textViewMatricula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);

        textViewNome = (TextView) findViewById(R.id.texview_nome_aluno);
        textViewEmail = (TextView) findViewById(R.id.texview_email_aluno);
        textViewMatricula = (TextView) findViewById(R.id.texview_matricula_aluno);

        Intent intent = getIntent();
        Aluno aluno = (Aluno) intent.getSerializableExtra("aluno");
        textViewNome.setText(aluno.getNome().toString());
        textViewEmail.setText(aluno.getEmail().toString());
        textViewMatricula.setText(aluno.getMatricula().toString());
    }
}
