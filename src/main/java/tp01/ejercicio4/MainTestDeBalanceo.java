package tp01.ejercicio4;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio3.PilaGenerica;

public class MainTestDeBalanceo {
    public static void main(String[] args) {

        var test = new TestDeBalanceo(new PilaGenerica<>(new ListaEnlazadaGenerica<Character>()));


        var s1 = "";
        var s2 = "()";
        var s3 = "{";
        var s4 = "}";
        var s5 = "[}";
        var s6 = "(((";
        var s7 = "{[()]}";
        var s8 = "{( ) [ ( ) ] }";
        var s9 = "( [ ) ]";
        var s10 = "([]}";
        var s11 = "({[]}[{}])";
        var s12 = "";


        System.out.println(test.estaBalanceado(s1) + " --> " + s1);
        System.out.println(test.estaBalanceado(s2) + " --> " + s2);
        System.out.println(test.estaBalanceado(s3) + " --> " + s3 );
        System.out.println(test.estaBalanceado(s4) + " --> " + s4 );
        System.out.println(test.estaBalanceado(s5) + " --> " + s5 );
        System.out.println(test.estaBalanceado(s6) + " --> " + s6 );
        System.out.println(test.estaBalanceado(s7) + " --> " + s7 );
        System.out.println(test.estaBalanceado(s8) + " --> " + s8 );
        System.out.println(test.estaBalanceado(s9) + " --> " + s9 );
        System.out.println(test.estaBalanceado(s10) + " --> " + s10 );
        System.out.println(test.estaBalanceado(s11) + " --> " + s11 );
        System.out.println(test.estaBalanceado(s12) + " --> " + s12 );


    }
}
