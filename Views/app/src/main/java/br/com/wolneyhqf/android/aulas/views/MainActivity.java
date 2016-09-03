package br.com.wolneyhqf.android.aulas.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Recupera String do arquivo strings.xml
        String helloWorld = getResources().getString(R.string.hello_world);

        // Recuperando os botões para navegar nos exemplos da aula
        Button botaoTextViewEditText = (Button) findViewById(R.id.botao_textview_edittext);
        botaoTextViewEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TextViewEditTextActivity.class);
                startActivity(intent);
            }
        });

        Button botaoAutocomplet = (Button) findViewById(R.id.botao_autocomplet);
        botaoAutocomplet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AutoCompletTextViewActivity.class);
                startActivity(intent);
            }
        });

        Button botaoButtons = (Button) findViewById(R.id.botao_buttons);
        botaoButtons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ButtonsActivity.class);
                startActivity(intent);
            }
        });

        Button botaoCheckBoxToogleButton = (Button) findViewById(R.id.botao_check_toogle);
        botaoCheckBoxToogleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CheckBoxToggleButtonActivity.class);
                startActivity(intent);
            }
        });

        Button botaoRadioButton = (Button) findViewById(R.id.botao_radio_button);
        botaoRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RadioButtonActivity.class);
                startActivity(intent);
            }
        });

        Button botaoSpinner = (Button) findViewById(R.id.botao_spinner);
        botaoSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SpinnerActivity.class);
                startActivity(intent);
            }
        });
    }
}
