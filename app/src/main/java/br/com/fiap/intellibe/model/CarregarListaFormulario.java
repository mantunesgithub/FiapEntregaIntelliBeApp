package br.com.fiap.intellibe.model;

import java.util.ArrayList;
import java.util.List;

public class CarregarListaFormulario {

    private ArrayList<FormularioLista> formulariosListas = new ArrayList<FormularioLista>();

    public ArrayList<FormularioLista> getFormulariosListas() {
        return formulariosListas;
    }

    public void cargaFormularioLista (FormularioLista formularioLista) {
        formulariosListas.add(formularioLista);
    }

}
