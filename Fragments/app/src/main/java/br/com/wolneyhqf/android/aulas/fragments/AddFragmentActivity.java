package br.com.wolneyhqf.android.aulas.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.wolneyhqf.android.aulas.fragments.fragments.FragmentB;
import br.com.wolneyhqf.android.aulas.fragments.fragments.HelloWorldFragment;

public class AddFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fragment_xml);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        FragmentB fragmentB = new FragmentB();
        fragmentTransaction.add(R.id.frame_fragmentB, fragmentB, FragmentB.TAG);
        fragmentTransaction.commit();
    }
}
