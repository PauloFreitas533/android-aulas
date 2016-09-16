package br.com.wolneyhqf.android.aulas.fragments.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.wolneyhqf.android.aulas.fragments.R;

/**
 * Created by wolney on 13/09/16.
 */
public class PaisFragment extends Fragment {

    public static final String TAG = "PaisFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.fragment_pais, container, false);
        if(getArguments()!=null){
            TextView textViewPais = (TextView) view.findViewById(R.id.text_view_pais);
            String pais = getArguments().getString("pais");
            textViewPais.setText(pais);
        }
        return view;
    }

    public void setPais(String pais){
        TextView textViewPais = (TextView) getView().findViewById(R.id.text_view_pais);
        textViewPais.setText(pais);
    }

}
