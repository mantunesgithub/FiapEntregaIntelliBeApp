package br.com.fiap.intellibe;
public enum TipoCliente {
    PJ(1, "Pessoa Jurídica"),
    PF (2, "Pessoa Física");

    private	int	cod;
    private	String	descricao;

    private TipoCliente(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDesrição() {
        return descricao;
    }
    public	static	TipoCliente	toEnum	(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (TipoCliente x : TipoCliente.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id invalido: " + cod);
    }
}
