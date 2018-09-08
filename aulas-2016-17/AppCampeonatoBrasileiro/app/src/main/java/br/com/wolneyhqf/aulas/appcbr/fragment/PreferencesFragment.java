package br.com.wolneyhqf.aulas.appcbr.fragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import br.com.wolneyhqf.aulas.appcbr.R;

/**
 * Created by wolney on 21/03/17.
 */

public class PreferencesFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.preferences);
    }

}
