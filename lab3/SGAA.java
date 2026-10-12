package lab3;

import lab3.exception.AnotacaoExistenteException;
import lab3.exception.HorasInvalidasException;

/**
 * sistema de gestao academica
 */
public class SGAA {
    public static void main(String[] args) {
        System.out.println("--- controle sono ---");
        ControleSono sono = new ControleSono();
        System.out.println(sono.getStatus());
        try { sono.defineHorasSono(-5); } catch (HorasInvalidasException e) { System.out.println(e.getMessage()); }
        sono.defineHorasSono(30);
        sono.defineSemanas(1);
        System.out.println(sono.getStatus());

        System.out.println("--- registro estudo ---");
        RegistroEstudo estudo = new RegistroEstudo("LP2", 30);
        estudo.adicionaHoras(10);
        System.out.println(estudo.atingiuMeta());
        try { estudo.adicionaHoras(-3); } catch (HorasInvalidasException e) { System.out.println(e.getMessage()); }
        System.out.println(estudo);

        System.out.println("--- componente ---");
        Componente comp = new Componente("PROGRAMACAO 2");
        comp.registraHoras(4);
        try { comp.registraNota(5, 8); } catch (Exception e) { System.out.println(e.getMessage()); }
        comp.registraNota(1, 5);
        comp.registraNota(2, 6);
        System.out.println(comp.aprovado());
        System.out.println(comp);

        System.out.println("--- bloco anotacoes ---");
        BlocoAnotacoes bloco = new BlocoAnotacoes(10);
        bloco.adiciona("Classes", "classes definem tipos para objetos");
        bloco.adiciona("Tipo", "semantica de dados");
        System.out.println(bloco.imprimeAnotacoes());
        try { bloco.adiciona("Classes", "outro"); } catch (AnotacaoExistenteException e) { System.out.println(e.getMessage()); }
        System.out.println(java.util.Arrays.toString(bloco.busca("classes")));
    }
}
