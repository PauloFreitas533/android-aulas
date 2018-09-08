package br.com.wolneyhqf.android.aulas.materialdesign.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import br.com.wolneyhqf.android.aulas.materialdesign.R;
import br.com.wolneyhqf.android.aulas.materialdesign.model.Pais;

/**
 * Created by wolney on 17/10/16.
 */

public class PaisesAdapter extends RecyclerView.Adapter<PaisesAdapter.PaisesViewHolder> {

    protected static final String TAG = "aula_material_design";
    private final List<Pais> paises;
    private final Context context;
    private final PaisOnClickListener onClickListener;

    public PaisesAdapter(List<Pais> paises, Context context, PaisOnClickListener onClickListener) {
        this.paises = paises;
        this.context = context;
        this.onClickListener = onClickListener;
    }

    @Override
    public PaisesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_paises, parent, false);
        PaisesViewHolder holder = new PaisesViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final PaisesViewHolder holder, final int position) {
        Pais pais = paises.get(position);
        holder.textViewNome.setText(pais.getNome());
        holder.img.setImageResource(pais.getBandeira());

        if(onClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListener.onClickPais(holder.view, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return this.paises != null ? this.paises.size() : 0;
    }

    public interface PaisOnClickListener{
        public void onClickPais(View view, int idx);
    }

    public static class PaisesViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewNome;
        ImageView img;
        ProgressBar progressBar;

        private View view;

        public PaisesViewHolder(View view){
            super(view);
            this.view = view;

            textViewNome = (TextView) view.findViewById(R.id.pNome);
            img = (ImageView) view.findViewById(R.id.img);
            progressBar = (ProgressBar) view.findViewById(R.id.progress);
        }
    }

}
