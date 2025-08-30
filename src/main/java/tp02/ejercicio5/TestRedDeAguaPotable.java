package tp02.ejercicio5;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio1.ArbolGeneral;

public class TestRedDeAguaPotable {
    public static void main(String[] args) {

        // Crear la raíz
        var A = new ArbolGeneral<String>("A");

        // Nivel 1
        var B = new ArbolGeneral<String>("B");
        var C = new ArbolGeneral<String>("C");
        var D = new ArbolGeneral<String>("D");
        var E = new ArbolGeneral<String>("E");

        // Hijos de A
        var hijosA = new ListaEnlazadaGenerica<ArbolGeneral<String>>();
        hijosA.agregarFinal(B);
        hijosA.agregarFinal(C);
        hijosA.agregarFinal(D);
        hijosA.agregarFinal(E);
        A.setHijos(hijosA);

        // Nivel 2 - Hijos de C
        var F = new ArbolGeneral<String>("F");
        var G = new ArbolGeneral<String>("G");
        var hijosC = new ListaEnlazadaGenerica<ArbolGeneral<String>>();
        hijosC.agregarFinal(F);
        hijosC.agregarFinal(G);
        C.setHijos(hijosC);

        // Nivel 3 - Hijo de G
        var L = new ArbolGeneral<String>("L");
        var hijosG = new ListaEnlazadaGenerica<ArbolGeneral<String>>();
        hijosG.agregarFinal(L);
        G.setHijos(hijosG);

        // Nivel 2 - Hijos de D
        var H = new ArbolGeneral<String>("H");
        var I = new ArbolGeneral<String>("I");
        var J = new ArbolGeneral<String>("J");
        var K = new ArbolGeneral<String>("K");
        var hijosD = new ListaEnlazadaGenerica<ArbolGeneral<String>>();
        hijosD.agregarFinal(H);
        hijosD.agregarFinal(I);
        hijosD.agregarFinal(J);
        hijosD.agregarFinal(K);
        D.setHijos(hijosD);

        // Nivel 3 - Hijos de J
        var M = new ArbolGeneral<String>("M");
        var N = new ArbolGeneral<String>("N");
        var hijosJ = new ListaEnlazadaGenerica<ArbolGeneral<String>>();
        hijosJ.agregarFinal(M);
        hijosJ.agregarFinal(N);
        J.setHijos(hijosJ);


        var redAgua = new RedDeAguaPotable();

        var minimoCaudal = redAgua.minimoCaudal(1000, A);

        System.out.println("El minimo Caudal del Arbol: " + A.getDato() + " es: " + minimoCaudal);


        System.out.println("La Altura del Arbol: " + A.getDato() + " es: " + A.altura());


    }
}
