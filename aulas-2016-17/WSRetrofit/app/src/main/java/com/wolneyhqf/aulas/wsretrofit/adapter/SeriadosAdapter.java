package com.wolneyhqf.aulas.wsretrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wolneyhqf.aulas.wsretrofit.R;
import com.wolneyhqf.aulas.wsretrofit.model.Seriado;

import java.util.List;

/**
 * Created by wolney on 15/11/17.
 */

public class SeriadosAdapter extends RecyclerView.Adapter<SeriadosAdapter.SeriadosViewHolder> {

    private final List<Seriado> seriados;
    private final Context context;
    private final SeriadoOnClickListener onClickListener;

    public interface SeriadoOnClickListener{
        public void onClickSeriado(View view, int index);
    }

    public SeriadosAdapter(Context context, List<Seriado> seriados, SeriadoOnClickListener onClickListener){
        this.context = context;
        this.seriados = seriados;
        this.onClickListener = onClickListener;
    }

    @Override
    public SeriadosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_seriados, parent, false);
        SeriadosViewHolder holder =  new SeriadosViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(SeriadosViewHolder holder, final int position) {
        Seriado seriado = seriados.get(position);
        holder.textViewNome.setText(seriado.getNome());
        holder.textViewGenero.setText(seriado.getGenero());
        holder.textViewPeriodo.setText(seriado.getPeriodoProducao());
        Picasso.with(context).load(seriado.getUrlImagem())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.noimage)
                .into(holder.imageView);
        if(onClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListener.onClickSeriado(view, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return this.seriados != null ? this.seriados.size() : 0;
    }

    public static class SeriadosViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewNome;
        TextView textViewGenero;
        TextView textViewPeriodo;

        public SeriadosViewHolder(View view){
            super(view);
            imageView = (ImageView) view.findViewById(R.id.image_view_seriado);
            textViewNome = (TextView) view.findViewById(R.id.text_view_nome_seriado);
            textViewGenero = (TextView) view.findViewById(R.id.text_view_genero);
            textViewPeriodo = (TextView) view.findViewById(R.id.text_view_periodo);
        }

    }

}
