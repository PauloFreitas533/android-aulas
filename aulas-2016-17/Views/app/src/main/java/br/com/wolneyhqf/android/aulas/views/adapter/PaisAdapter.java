package br.com.wolneyhqf.android.aulas.views.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.wolneyhqf.android.aulas.views.R;
import br.com.wolneyhqf.android.aulas.views.model.Pais;

/**
 * Created by wolney on 22/09/16.
 */

public class PaisAdapter extends BaseAdapter {

    private Context context;
    private List<Pais> paises;

    public PaisAdapter(Context context, List<Pais> paises){
        this.context = context;
        this.paises = paises;
    }

    @Override
    public int getCount() {
        return paises.size();
    }

    @Override
    public Object getItem(int i) {
        return paises.get(i);
    }

    @Override
    public long getItemId(int i) {
        return paises.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View layout = LayoutInflater.from(context).inflate(R.layout.listview_paises, viewGroup, false);

        Pais pais = paises.get(i);

        ImageView imageView = (ImageView) layout.findViewById(R.id.img_bandeira_pais);
        imageView.setImageResource(pais.getBandeira());

        TextView textView = (TextView) layout.findViewById(R.id.textview_pais);
        textView.setText(pais.getNome());

        return layout;
    }
}
