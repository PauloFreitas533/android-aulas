package br.com.wolneyhqf.android.aulas.fragments.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import br.com.wolneyhqf.android.aulas.fragments.R;

/**
 * Created by Ricardo Lecheta on 10/09/2014.
 */
public class PaisesAdapter extends BaseAdapter {
    private String[] paises = new String[]{"Argentina", "Brasil", "Espanha", "França", "Holanda",
            "Italia", "Irlanda", "Portugal", "Republica Tcheca"};
    private Context context;

    public PaisesAdapter(Context context) {
        super();
        this.context = context;
    }

    @Override
    public int getCount() {
        return paises.length;
    }

    @Override
    public Object getItem(int position) {
        return paises[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String pais = paises[position];
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_paises, parent, false);
        TextView t = (TextView) view.findViewById(R.id.text_pais);
        t.setText(pais);
        return view;
    }
}