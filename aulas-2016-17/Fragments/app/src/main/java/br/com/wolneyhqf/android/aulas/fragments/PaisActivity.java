package br.com.wolneyhqf.android.aulas.fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PaisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pais);

        Intent intent = getIntent();
        String pais = intent.getStringExtra("pais");
        TextView textView = (TextView) findViewById(R.id.text_view_pais);
        textView.setText(pais);

    }
}
