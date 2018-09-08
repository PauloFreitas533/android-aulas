package br.com.wolneyhqf.android.aulas.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ButtonsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);

        Button botaoNormal = (Button) findViewById(R.id.botao_normal);
        botaoNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonsActivity.this, "Botão Normal", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton imageButtonSmile1 = (ImageButton) findViewById(R.id.botao_smile1);
        imageButtonSmile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonsActivity.this, "Botão Smile 1", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton imageButtonSmile2 = (ImageButton) findViewById(R.id.botao_smile2);
        imageButtonSmile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonsActivity.this, "Botão Smile 2", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
