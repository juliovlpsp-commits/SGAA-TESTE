package lab3;

/**
 * anotacao com tema e conteudo
 */
public class Anotacao {
    private String tema;
    private String conteudo;

    /**
     * cria anotacao
     * @param tema tema da anotacao
     * @param conteudo conteudo da anotacao
     */
    public Anotacao(String tema, String conteudo) {
        if (tema == null || tema.trim().isEmpty()) throw new IllegalArgumentException("tema nao pode ser vazio");
        if (conteudo == null || conteudo.trim().isEmpty()) throw new IllegalArgumentException("conteudo nao pode ser vazio");
        this.tema = tema;
        this.conteudo = conteudo;
    }

    public String getTema() {
        return this.tema;
    }

    public String getConteudo() {
        return this.conteudo;
    }

    @Override
    public String toString() {
        return this.tema + ": " + this.conteudo;
    }
}
