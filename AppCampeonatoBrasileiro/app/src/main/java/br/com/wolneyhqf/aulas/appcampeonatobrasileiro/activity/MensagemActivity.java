package br.com.wolneyhqf.aulas.appcampeonatobrasileiro.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.com.wolneyhqf.aulas.appcampeonatobrasileiro.R;

public class MensagemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagem);

        TextView textView = (TextView) findViewById(R.id.textview_mensagem);

        String msg = getIntent().getStringExtra("mensagem");
        textView.setText(msg);
    }
}
