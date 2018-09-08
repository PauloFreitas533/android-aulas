package br.com.wolneyhqf.android.aulas.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.wolneyhqf.android.aulas.fragments.fragments.FragmentA;
import br.com.wolneyhqf.android.aulas.fragments.fragments.FragmentB;
import br.com.wolneyhqf.android.aulas.fragments.fragments.FragmentC;

public class ReplaceFragmentActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonFragmentA;
    private Button buttonFragmentB;
    private Button buttonFragmentC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replace_fragment);

        buttonFragmentA = (Button) findViewById(R.id.button_fragment_a);
        buttonFragmentA.setOnClickListener(this);
        buttonFragmentB = (Button) findViewById(R.id.button_fragment_b);
        buttonFragmentB.setOnClickListener(this);
        buttonFragmentC = (Button) findViewById(R.id.button_fragment_c);
        buttonFragmentC.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (id){
            case R.id.button_fragment_a:
                FragmentA fragmentA = new FragmentA();
                fragmentTransaction.replace(R.id.frame_fragments, fragmentA, FragmentA.TAG);
                break;
            case R.id.button_fragment_b:
                FragmentB fragmentB = new FragmentB();
                fragmentTransaction.replace(R.id.frame_fragments, fragmentB, FragmentB.TAG);
                break;
            case R.id.button_fragment_c:
                FragmentC fragmentC = new FragmentC();
                fragmentTransaction.replace(R.id.frame_fragments, fragmentC, FragmentC.TAG);
                break;
        }
        fragmentTransaction.commit();
    }
}
