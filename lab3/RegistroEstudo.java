package lab3;

import lab3.exception.HorasInvalidasException;

/**
 * registro de horas de estudo
 */
public class RegistroEstudo {
    private String nome;
    private int meta;
    private int horas;

    public RegistroEstudo(String nome) {
        this(nome, 120);
    }

    public RegistroEstudo(String nome, int meta) {
        if (nome == null || nome.trim().isEmpty()) throw new IllegalArgumentException("nome nao pode ser vazio");
        if (meta <= 0) throw new HorasInvalidasException("meta deve ser maior que zero");
        this.nome = nome;
        this.meta = meta;
        this.horas = 0;
    }

    /**
     * adiciona horas
     * @param valor horas a adicionar
     */
    public void adicionaHoras(int valor) {
        if (valor < 0) throw new HorasInvalidasException("horas nao pode ser menor que zero");
        this.horas += valor;
    }

    public boolean atingiuMeta() {
        return this.horas >= this.meta;
    }

    @Override
    public String toString() {
        return this.nome + " " + this.horas + "/" + this.meta;
    }
}
