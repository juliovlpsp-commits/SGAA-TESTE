package lab3;

import lab3.exception.HorasInvalidasException;

/**
 * controle de sono do aluno
 */
public class ControleSono {
    private static final int DESCANSO_MINIMO = 26;
    private int horasSono;
    private int semanas;

    public ControleSono() {
        this.horasSono = 0;
        this.semanas = 0;
    }

    /**
     * define horas de sono
     * @param valor horas de sono
     */
    public void defineHorasSono(int valor) {
        if (valor < 0) throw new HorasInvalidasException("horas nao pode ser menor que zero");
        this.horasSono = valor;
    }

    /**
     * define semanas
     * @param valor numero de semanas
     */
    public void defineSemanas(int valor) {
        if (valor < 0) throw new HorasInvalidasException("semanas nao pode ser menor que zero");
        this.semanas = valor;
    }

    /**
     * verifica status
     * @return descansado ou cansado
     */
    public String getStatus() {
        if (this.semanas > 0 && (double) this.horasSono / this.semanas >= DESCANSO_MINIMO) return "descansado";
        return "cansado";
    }
}
