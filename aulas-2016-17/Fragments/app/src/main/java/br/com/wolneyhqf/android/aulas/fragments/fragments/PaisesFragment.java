package br.com.wolneyhqf.android.aulas.fragments.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import br.com.wolneyhqf.android.aulas.fragments.PaisActivity;
import br.com.wolneyhqf.android.aulas.fragments.PaisFragmentActivity;
import br.com.wolneyhqf.android.aulas.fragments.R;
import br.com.wolneyhqf.android.aulas.fragments.adapter.PaisesAdapter;

/**
 * Created by wolney on 13/09/16.
 */
public class PaisesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.fragment_paises, container, false);
        ListView listViewPaises = (ListView) view.findViewById(R.id.list_view_paises);
        listViewPaises.setAdapter(new PaisesAdapter(getActivity()));
        listViewPaises.setOnItemClickListener(onItemClickPais());
        return view;
    }

    public AdapterView.OnItemClickListener onItemClickPais(){

        return new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parente, View view, int position, long id){
                PaisesAdapter adapter = (PaisesAdapter) parente.getAdapter();
                String pais = (String) adapter.getItem(position);

                PaisFragment paisFragment = (PaisFragment) getFragmentManager().findFragmentById(R.id.fragment_pais);
                if(paisFragment!=null){
                    paisFragment.setPais(pais);
                }else{
                    Intent intent = new Intent(getActivity(), PaisFragmentActivity.class);
                    intent.putExtra("pais", pais);
                    startActivity(intent);
                }
            }
        };

    }

}
