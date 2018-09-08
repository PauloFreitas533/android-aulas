package br.com.wolneyhqf.android.aulas.navegateapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.wolneyhqf.android.aulas.navegateapp.R;

/**
 * Created by wolney on 15/11/16.
 */

public class HomeFragment extends Fragment {

    public static final String TAG = "HomeFragment";

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle){
        View view = inflater.inflate(R.layout.fragment_home, viewGroup, false);
        return view;
    }

}
