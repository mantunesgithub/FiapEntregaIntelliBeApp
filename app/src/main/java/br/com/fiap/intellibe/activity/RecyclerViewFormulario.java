package br.com.fiap.intellibe.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.fiap.intellibe.R;
import br.com.fiap.intellibe.RecyclerItemClickListener;
import br.com.fiap.intellibe.adapter.AdapterFormulario;
import br.com.fiap.intellibe.model.FormularioLista;

public class RecyclerViewFormulario extends AppCompatActivity {

    private RecyclerView recyclerViewFormulario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_formulario);

        recyclerViewFormulario = findViewById(R.id.recyclerViewForm);

        //Listagem de Formularios

        Intent i = getIntent();

        ArrayList<FormularioLista> listaFormok =
             (ArrayList<FormularioLista>) i.getSerializableExtra("LIST");

        AdapterFormulario adapterFormulario = new AdapterFormulario(listaFormok);

        //Config RecyclerView

        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getApplicationContext());

        recyclerViewFormulario.setLayoutManager(layoutManager);
        recyclerViewFormulario.setAdapter(adapterFormulario);
        recyclerViewFormulario.setHasFixedSize(true);
        recyclerViewFormulario.addItemDecoration
                (new DividerItemDecoration(this, LinearLayout.VERTICAL));

        // Evento Click

        recyclerViewFormulario.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerViewFormulario,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }

                            @Override
                            public void onItemClick(View view, int position) {

                                String formulario;
                                formulario = "Formulário: " + listaFormok.get(position).getNomeFormulario()
                                        +"\n Nota de Corte: " + listaFormok.get(position).getValorNotaMinima()
                                        +"\n Periodo teste: "
                                        +"\n de " + listaFormok.get(position).getDtInicioTeste()
                                        +" à " + listaFormok.get(position).getDtFinalTeste();

                                Toast.makeText(getApplicationContext(),
                               formulario,Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                String formulario;
                                formulario = "Formulário: " + listaFormok.get(position).getNomeFormulario()
                                        +"\n Nota de Corte: " + listaFormok.get(position).getValorNotaMinima()
                                        +"\n Periodo teste: "
                                        +"\n de " + listaFormok.get(position).getDtInicioTeste()
                                        +" à " + listaFormok.get(position).getDtFinalTeste();

                                Toast.makeText(getApplicationContext(),
                                        "" + formulario,Toast.LENGTH_LONG).show();
                            }
                        }
                )

        );
    }
}