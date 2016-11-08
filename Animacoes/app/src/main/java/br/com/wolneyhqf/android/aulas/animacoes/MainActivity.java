package br.com.wolneyhqf.android.aulas.animacoes;

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

        Button buttonDrawableAnimationActivity = (Button) findViewById(R.id.buttonDrawableAnimationActivity);
        buttonDrawableAnimationActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DrawableAnimationActivity.class);
                startActivity(intent);
            }
        });

        Button buttonAlphaAnimationActivity = (Button) findViewById(R.id.buttonAlphaAnimationActivity);
        buttonAlphaAnimationActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AlphaAnimationActivity.class);
                startActivity(intent);
            }
        });

        Button buttonRotateAnimationActivity = (Button) findViewById(R.id.buttonRotateAnimationActivity);
        buttonRotateAnimationActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RotateAnimationActivity.class);
                startActivity(intent);
            }
        });

        Button buttonScaleAnimationActivity = (Button) findViewById(R.id.buttonScaleAnimationActivity);
        buttonScaleAnimationActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ScaleAnimationActivity.class);
                startActivity(intent);
            }
        });

        Button buttonTranslateAnimationActivity = (Button) findViewById(R.id.buttonTranslateAnimationActivity);
        buttonTranslateAnimationActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TranslateAnimationActivity.class);
                startActivity(intent);
            }
        });
    }
}
