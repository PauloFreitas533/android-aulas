package br.com.wolneyhqf.aulas.appcbr.activity;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

import br.com.wolneyhqf.aulas.appcbr.fragment.PreferencesFragment;

public class PreferencesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(android.R.id.content, new PreferencesFragment());
        ft.commit();
    }
}
