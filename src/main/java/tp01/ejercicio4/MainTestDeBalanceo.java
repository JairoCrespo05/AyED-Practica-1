package tp01.ejercicio4;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio3.PilaGenerica;

public class MainTestDeBalanceo {
    public static void main(String[] args) {

        var test = new TestDeBalanceo(new PilaGenerica<>(new ListaEnlazadaGenerica<Character>()));

        System.out.println(test.esBalanceado(""));
        System.out.println(test.esBalanceado("()"));
        System.out.println(test.esBalanceado("{"));
        System.out.println(test.esBalanceado("[}"));


    }
}
