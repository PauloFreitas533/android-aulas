package br.com.wolneyhqf.android.aulas.fragments.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.wolneyhqf.android.aulas.fragments.R;

/**
 * Created by wolney on 05/09/16.
 */
public class HelloWorldFragment extends Fragment {

    public static final String TAG = "HelloWorldFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.fragment_hello_world, container);
        return view;
    }

}
