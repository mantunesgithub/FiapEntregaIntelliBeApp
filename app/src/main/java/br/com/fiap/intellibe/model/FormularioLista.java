package br.com.fiap.intellibe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FormularioLista implements Serializable {

    private Long idFormulario;
    private String nomeFormulario;
    private String descVaga;
    private Double valorNotaMinima;
    private String dtInicioTeste;
    private String dtFinalTeste;


    public FormularioLista() {
    }

    public FormularioLista(Long idFormulario, String nomeFormulario, String descVaga, Double valorNotaMinima, String dtInicioTeste, String dtFinalTeste) {
        this.idFormulario = idFormulario;
        this.nomeFormulario = nomeFormulario;
        this.descVaga = descVaga;
        this.valorNotaMinima = valorNotaMinima;
        this.dtInicioTeste = dtInicioTeste;
        this.dtFinalTeste = dtFinalTeste;
    }

    public Long getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(Long idFormulario) {
        this.idFormulario = idFormulario;
    }

    public String getNomeFormulario() {
        return nomeFormulario;
    }

    public void setNomeFormulario(String nomeFormulario) {
        this.nomeFormulario = nomeFormulario;
    }

    public String getDescVaga() {
        return descVaga;
    }

    public void setDescVaga(String descVaga) {
        this.descVaga = descVaga;
    }

    public Double getValorNotaMinima() {
        return valorNotaMinima;
    }

    public void setValorNotaMinima(Double valorNotaMinima) {
        this.valorNotaMinima = valorNotaMinima;
    }

    public String getDtInicioTeste() {
        return dtInicioTeste;
    }

    public void setDtInicioTeste(String dtInicioTeste) {
        this.dtInicioTeste = dtInicioTeste;
    }

    public String getDtFinalTeste() {
        return dtFinalTeste;
    }

    public void setDtFinalTeste(String dtFinalTeste) {
        this.dtFinalTeste = dtFinalTeste;
    }
    @Override
    public String toString() {
        return "FormularioLista{" +
                "idFormulario=" + idFormulario +
                ", nomeFormulario='" + nomeFormulario + '\'' +
                ", descVaga='" + descVaga + '\'' +
                ", valorNotaMinima=" + valorNotaMinima +
                ", dtInicioTeste='" + dtInicioTeste + '\'' +
                ", dtFinalTeste='" + dtFinalTeste + '\'' +
                '}';
    }

}
