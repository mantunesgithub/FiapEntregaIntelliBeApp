package br.com.fiap.intellibe;

import java.io.Serializable;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long cnpjOuCpf;
    private Integer tipoCliente;
    private String nomeCliente;
    private String descricaoEmail;
    private String descricaoEndereco;
    private String complementoEndereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;
    private String telefone;
    //private List<Departamento> departamentos = new ArrayList<>();
    //private List<Formulario> formulario = new ArrayList<>();

    public Cliente(Long cnpjOuCpf, String tipoCliente, String nomeCliente, String descricaoEmail,
                   String descricaoEndereco, String complementoEndereco, String bairro, String cidade, String estado,
                   String pais, String cep, String telefone) {
        super();
        this.cnpjOuCpf = cnpjOuCpf;
        this.nomeCliente = nomeCliente;
        setTipoCliente(tipoCliente);
        this.nomeCliente = nomeCliente;
        this.descricaoEmail = descricaoEmail;
        this.descricaoEndereco = descricaoEndereco;
        this.complementoEndereco = complementoEndereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cep = cep;
        this.telefone = telefone;
    }

    public Cliente() {
    }

    public Long getCnpjOuCpf() {
        return cnpjOuCpf;
    }

    public void setCnpjOuCpf(Long cnpjOuCpf) {
        this.cnpjOuCpf = cnpjOuCpf;
    }

    public TipoCliente getTipoCliente() {
        return TipoCliente.toEnum(tipoCliente);
    }

    public void setTipoCliente(String tipo) {
        if (!tipo.equals("PF") && !tipo.equals("PJ")) {
            throw new RuntimeException("Tipo dever ser PF ou PJ");
        }
        TipoCliente tipoCliente = TipoCliente.valueOf(tipo);
        this.tipoCliente = tipoCliente.getCod();
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getDescricaoEmail() {
        return descricaoEmail;
    }

    public void setDescricaoEmail(String descricaoEmail) {
        this.descricaoEmail = descricaoEmail;
    }

    public String getDescricaoEndereco() {
        return descricaoEndereco;
    }

    public void setDescricaoEndereco(String descricaoEndereco) {
        this.descricaoEndereco = descricaoEndereco;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
//    public List<Departamento> getDepartamentos() {
//        return departamentos;
//    }
