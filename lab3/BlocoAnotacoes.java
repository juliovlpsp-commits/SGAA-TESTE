package lab3;

import java.util.Arrays;
import lab3.exception.AnotacaoExistenteException;

/**
 * bloco de anotacoes
 */
public class BlocoAnotacoes {
    private Anotacao[] bloco;
    private int qtd;
    private int pos;

    public BlocoAnotacoes(int capacidade) {
        if (capacidade <= 0) throw new IllegalArgumentException("capacidade deve ser maior que zero");
        this.bloco = new Anotacao[capacidade];
        this.qtd = 0;
        this.pos = 0;
    }

    /**
     * adiciona anotacao
     * @param tema tema da anotacao
     * @param conteudo conteudo da anotacao
     */
    public void adiciona(String tema, String conteudo) {
        if (temAnotacao(tema)) throw new AnotacaoExistenteException("anotacao ja existe: " + tema);
        Anotacao anotacao = new Anotacao(tema, conteudo);
        this.bloco[this.pos] = anotacao;
        this.pos = (this.pos + 1) % this.bloco.length;
        if (this.qtd < this.bloco.length) this.qtd++;
    }

    public void adicionaAnotacao(String tema, String conteudo) {
        adiciona(tema, conteudo);
    }

    public String[] pegaAnotacoes() {
        String[] resultado = new String[this.qtd];
        for (int i = 0; i < this.qtd; i++) resultado[i] = this.bloco[posReal(i)].toString();
        return resultado;
    }

    public int conta() {
        return this.qtd;
    }

    public int contaAnotacoes() {
        return conta();
    }

    public String imprimeAnotacoes() {
        StringBuilder sb = new StringBuilder();
        sb.append("- ").append(conta()).append(" anotacao(s) cadastrada(s)\n- ");
        String[] anotacoes = pegaAnotacoes();
        for (int i = 0; i < anotacoes.length; i++) { if (i > 0) sb.append(" | "); sb.append(anotacoes[i].replaceAll(":.*", "")); }
        return sb.toString();
    }

    public boolean temAnotacao(String tema) {
        if (tema == null) return false;
        for (int i = 0; i < this.qtd; i++) if (this.bloco[posReal(i)].getTema().equalsIgnoreCase(tema)) return true;
        return false;
    }

    /**
     * busca por conteudo
     * @param chave palavra a buscar
     * @return temas encontrados
     */
    public String[] busca(String chave) {
        if (chave == null || chave.isEmpty()) return new String[0];
        String termo = chave.toLowerCase();
        String[] encontrados = new String[this.qtd];
        int total = 0;
        for (int i = 0; i < this.qtd; i++) {
            Anotacao a = this.bloco[posReal(i)];
            if (a.getConteudo().toLowerCase().contains(termo)) encontrados[total++] = a.getTema();
        }
        String[] resultado = Arrays.copyOf(encontrados, total);
        Arrays.sort(resultado, String.CASE_INSENSITIVE_ORDER);
        return resultado;
    }

    private int posReal(int pos) {
        if (this.qtd < this.bloco.length) return pos;
        return (this.pos + pos) % this.bloco.length;
    }
}
