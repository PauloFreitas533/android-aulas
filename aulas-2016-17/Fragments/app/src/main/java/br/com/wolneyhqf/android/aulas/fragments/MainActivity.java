package br.com.wolneyhqf.android.aulas.fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.wolneyhqf.android.aulas.fragments.fragments.PaisesFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAddFragment = (Button) findViewById(R.id.button_add_fragment);
        buttonAddFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddFragmentActivity.class);
                startActivity(intent);
            }
        });

        Button buttonReplaceFragment = (Button) findViewById(R.id.button_replace_fragment);
        buttonReplaceFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ReplaceFragmentActivity.class);
                startActivity(intent);
            }
        });

        Button buttonActivityPaises = (Button) findViewById(R.id.button_activity_paises);
        buttonActivityPaises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PaisesActivity.class);
                startActivity(intent);
            }
        });

        Button buttonActivityFragmentPaises = (Button) findViewById(R.id.button_activity_fragment_paises);
        buttonActivityFragmentPaises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PaisesFragmentActivity.class);
                startActivity(intent);
            }
        });

        Button buttonActivityDualPaises = (Button) findViewById(R.id.button_activity_dual_paises);
        buttonActivityDualPaises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PaisesDualActivity.class);
                startActivity(intent);
            }
        });

        Button buttonActivityBackStack = (Button) findViewById(R.id.button_activity_back_stack);
        buttonActivityBackStack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BackStackActivity.class);
                startActivity(intent);
            }
        });
    }
}
