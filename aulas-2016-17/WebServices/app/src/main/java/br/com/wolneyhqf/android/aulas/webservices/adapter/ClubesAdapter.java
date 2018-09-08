package br.com.wolneyhqf.android.aulas.webservices.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.wolneyhqf.android.aulas.webservices.R;
import br.com.wolneyhqf.android.aulas.webservices.model.Clube;

/**
 * Created by wolney on 25/11/16.
 */

public class ClubesAdapter extends RecyclerView.Adapter<ClubesAdapter.ClubesViewHolder> {

    private Context context;
    private List<Clube> clubes;
    private final ClubeOnClickListener onClickListener;

    public ClubesAdapter(Context context, List<Clube> clubes, ClubeOnClickListener onClickListener){
        this.context = context;
        this.clubes = clubes;
        this.onClickListener = onClickListener;
    }

    @Override
    public ClubesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_clubes, parent, false);
        ClubesViewHolder viewHolder = new ClubesViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ClubesViewHolder holder, final int position) {
        Clube clube = clubes.get(position);
        holder.textViewNome.setText(clube.getNome());
        holder.textViewEstado.setText(clube.getEstado());
        holder.textViewEstadio.setText(clube.getEstadio());

        if(onClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListener.onClickClube(holder.view, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return this.clubes != null ? this.clubes.size() : 0;
    }

    public static class ClubesViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageViewEscudo;
        public TextView textViewNome;
        public TextView textViewEstadio;
        public TextView textViewEstado;
        private View view;

        public ClubesViewHolder(View view){
            super(view);

            textViewNome = (TextView) view.findViewById(R.id.textview_nome);
            textViewEstadio = (TextView) view.findViewById(R.id.textview_estadio);
            textViewEstado = (TextView) view.findViewById(R.id.textview_estado);
        }

    }

    public interface ClubeOnClickListener{
        public void onClickClube(View view, int index);
    }
}
