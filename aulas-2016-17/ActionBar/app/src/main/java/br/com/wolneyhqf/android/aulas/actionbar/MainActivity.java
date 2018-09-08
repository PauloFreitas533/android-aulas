package br.com.wolneyhqf.android.aulas.actionbar;

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

        Button buttonActionBar1 = (Button) findViewById(R.id.buttonActionBar1);
        buttonActionBar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActionBar1Activity.class);
                startActivity(intent);
            }
        });

        Button buttonActionBar2 = (Button) findViewById(R.id.buttonActionBar2);
        buttonActionBar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActionBar2Activity.class);
                startActivity(intent);
            }
        });

        Button buttonActionBar3 = (Button) findViewById(R.id.buttonActionBar3);
        buttonActionBar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActionBar3Activity.class);
                startActivity(intent);
            }
        });

    }
}
