package lab3;

import java.util.Arrays;
import lab3.exception.HorasInvalidasException;

/**
 * componente com notas e horas
 */
public class Componente {
    private static final double MEDIA_APROVACAO = 7.0;
    private String nome;
    private int horas;
    private double[] notas;
    private int[] pesos;

    public Componente(String nome) {
        this(nome, 4);
    }

    public Componente(String nome, int qtdNotas) {
        this(nome, qtdNotas, null);
    }

    public Componente(String nome, int qtdNotas, int[] pesos) {
        this.nome = nome;
        this.horas = 0;
        this.notas = new double[qtdNotas];
        if (pesos != null && pesos.length == qtdNotas) this.pesos = Arrays.copyOf(pesos, pesos.length);
        else this.pesos = null;
    }

    /**
     * registra horas
     * @param h horas a adicionar
     */
    public void registraHoras(int h) {
        if (h < 0) throw new HorasInvalidasException("horas nao pode ser menor que zero");
        this.horas += h;
    }

    /**
     * registra nota
     * @param num numero da nota
     * @param valor valor da nota
     */
    public void registraNota(int num, double valor) {
        if (num < 1 || num > this.notas.length) throw new IllegalArgumentException("numero da nota invalido");
        if (valor < 0 || valor > 10) throw new IllegalArgumentException("valor da nota invalido");
        this.notas[num - 1] = valor;
    }

    private double calculaMedia() {
        if (this.pesos == null) {
            double soma = 0;
            for (double nota : this.notas) soma += nota;
            return soma / this.notas.length;
        }
        double soma = 0;
        int somaPeso = 0;
        for (int i = 0; i < this.notas.length; i++) { soma += this.notas[i] * this.pesos[i]; somaPeso += this.pesos[i]; }
        return somaPeso > 0 ? soma / somaPeso : 0.0;
    }

    public boolean aprovado() {
        return calculaMedia() >= MEDIA_APROVACAO;
    }

    @Override
    public String toString() {
        return this.nome + " " + this.horas + " " + calculaMedia() + " " + Arrays.toString(this.notas);
    }
}
