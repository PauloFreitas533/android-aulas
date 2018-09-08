package br.com.wolneyhqf.android.aulas.activityintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class Tela2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        // Por meio do método getIntent() da Activity, eu recupero a Intent enviada pela outra tela
        Intent intent = getIntent();

        // Por meio do método getStringExtra() da Intent, eu recupero o paramêtro passado pela outra tela
        // Há um método para cada tipo de variável passada por parâmetro (Ex: getDoubleExtra())
        String parametroNomeUsuario = intent.getStringExtra("nome_usuario");

        // Verifica se o parametro não é nulo
        if(parametroNomeUsuario!=null){
            // Aqui eu recupero o TextView do xml para exibir a String passada pela outra tela
            TextView textView = (TextView) findViewById(R.id.textview_parametro);
            textView.setText("Nome do Usuário: " +  parametroNomeUsuario);
        }
    }
}
