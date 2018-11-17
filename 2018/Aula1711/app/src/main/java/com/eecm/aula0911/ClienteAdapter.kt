package com.eecm.aula0911

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ClienteAdapter
    (val clientes: List<Cliente>,
     val onClick: (Cliente) -> Unit) : RecyclerView.Adapter<ClienteAdapter.ClientesViewHolder>() {

    class ClientesViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var textViewNome: TextView
        var textViewEmail: TextView

        init{
            textViewNome = view.findViewById(R.id.textViewNome)
            textViewEmail = view.findViewById(R.id.textViewEmail)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ClientesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_cliente, parent, false)
        val holder = ClientesViewHolder(view)
        return holder
    }

    override fun getItemCount() = this.clientes.size

    override fun onBindViewHolder(holder: ClientesViewHolder, position: Int) {
        val context = holder.itemView.context
        val cliente = clientes[position]
        holder.textViewNome.text = cliente.nome
        holder.textViewEmail.text = cliente.email
        holder.itemView.setOnClickListener{onClick(cliente)}
    }




}