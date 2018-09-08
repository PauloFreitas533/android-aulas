package br.com.wolneyhqf.android.aulas.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.wolneyhqf.android.aulas.fragments.fragments.HelloWorldFragment;
import br.com.wolneyhqf.android.aulas.fragments.fragments.PaisFragment;

public class PaisFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pais_fragment);

        FragmentManager fragmentManager = getSupportFragmentManager();

        if(savedInstanceState==null){
            PaisFragment fragment = new PaisFragment();
            fragment.setArguments(getIntent().getExtras());

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.layout_fragment_pais, fragment, PaisFragment.TAG);
            fragmentTransaction.commit();
        }

    }
}
