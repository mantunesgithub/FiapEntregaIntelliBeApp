package br.com.fiap.intellibe.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.fiap.intellibe.R;
import br.com.fiap.intellibe.model.FormularioLista;

public class AdapterFormulario extends RecyclerView.Adapter<AdapterFormulario.MyViewHolder>{

    private List<FormularioLista> listaformulario;

    public AdapterFormulario(List<FormularioLista> lista) {
        this.listaformulario = lista;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from
                (parent.getContext()).inflate(R.layout.adapter_lista_formulario, parent, false);

        return new MyViewHolder(itemLista);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        FormularioLista formLista = listaformulario.get(position);
        holder.idFormulario.setText(formLista.getIdFormulario().toString());
        holder.nomeFormulario.setText(formLista.getNomeFormulario());
        holder.descVaga.setText(formLista.getDescVaga());

        }


    @Override
    public int getItemCount() {
        return listaformulario.size() ;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView idFormulario;
        TextView nomeFormulario;
        TextView descVaga;

        public MyViewHolder( View itemView) {
            super(itemView);
            idFormulario   = itemView.findViewById(R.id.idFormulario);
            nomeFormulario = itemView.findViewById(R.id.nomeFormulario);
            descVaga = itemView.findViewById(R.id.descricaoVaga);
        }
    }
}
