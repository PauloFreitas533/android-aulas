package com.wolneyhqf.formapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome;
    private RadioGroup radioGroupSexo;
    private Spinner spinner;
    private CheckBox checkBoxManha;
    private CheckBox checkBoxTarde;
    private CheckBox checkBoxNoite;
    private Button botaoCancelar;
    private Button botaoEnviar;
    private String[] cursos = new String[]{"ADS", "Administração", "Direito", "Engenharia Civil"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = (EditText) findViewById(R.id.edittext_nome);
        radioGroupSexo = (RadioGroup) findViewById(R.id.radiogroup_sexo);
        spinner = (Spinner) findViewById(R.id.spinner_curso);
        checkBoxManha = (CheckBox) findViewById(R.id.checkbox_manha);
        checkBoxTarde = (CheckBox) findViewById(R.id.checkbox_tarde);
        checkBoxNoite = (CheckBox) findViewById(R.id.checkbox_noite);
        botaoCancelar = (Button) findViewById(R.id.button_cancelar);
        botaoEnviar = (Button) findViewById(R.id.button_enviar);

        // Adaptar do Spinner
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, cursos);
        spinner.setAdapter(adaptador);


        botaoCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        botaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarParametros();
            }
        });
    }

    private void enviarParametros(){
        // Pegar o que foi digitado no campo Nome
        String nome = editTextNome.getText().toString();
        Log.d("appform", "Nome: " + nome);

        // Pegar o que foi marcado no RadioGroup
        int idRadioButtonSelecionado = radioGroupSexo.getCheckedRadioButtonId();
        if(idRadioButtonSelecionado == R.id.radio_masculino){
            Log.d("appform", "Sexo: Masculino");
        }else if(idRadioButtonSelecionado == R.id.radio_feminino){
            Log.d("appform", "Nome: Feminino");
        }

        // Pegar informação selecionada no Spinner
        String curso = (String) spinner.getSelectedItem();
        Log.d("appform", "Curso: " + curso);

        // Pegar os valores dos Checkbox
        if(checkBoxManha.isChecked()){
            Log.d("appform", "Turno manhã: SIM");
        }else{
            Log.d("appform", "Turno manhã: NÃO");
        }
        if(checkBoxTarde.isChecked()){
            Log.d("appform", "Turno tarde: SIM");
        }else{
            Log.d("appform", "Turno tarde: NÃO");
        }
        if(checkBoxNoite.isChecked()){
            Log.d("appform", "Turno noite: SIM");
        }else{
            Log.d("appform", "Turno noite: NÃO");
        }
    }

}
