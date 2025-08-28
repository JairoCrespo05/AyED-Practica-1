package tp02.ejercicio4;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio1.ArbolGeneral;

public class TestAnalizadorArbol {
    public static void main(String[] args) {

        // Creación del árbol de la empresa
        var raiz = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("M", 14));

        // Nivel 1
        var J = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("J", 13));
        var K = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("K", 25));
        var L = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("L", 10));

        // Hijos de la raíz (M)
        var hijosM = new ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>>();
        hijosM.agregarFinal(J);
        hijosM.agregarFinal(K);
        hijosM.agregarFinal(L);
        raiz.setHijos(hijosM);

        // Nivel 2 - Hijos de J
        var A = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("A", 4));
        var B = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("B", 7));
        var C = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("C", 5));

        var hijosJ = new ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>>();
        hijosJ.agregarFinal(A);
        hijosJ.agregarFinal(B);
        hijosJ.agregarFinal(C);
        J.setHijos(hijosJ);

        // Nivel 2 - Hijos de K
        var D = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("D", 6));
        var E = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("E", 10));
        var F = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("F", 18));

        var hijosK = new ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>>();
        hijosK.agregarFinal(D);
        hijosK.agregarFinal(E);
        hijosK.agregarFinal(F);
        K.setHijos(hijosK);

        // Nivel 2 - Hijos de L
        var G = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("G", 9));
        var H = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("H", 12));
        var I = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("I", 19));

        var hijosL = new ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>>();
        hijosL.agregarFinal(G);
        hijosL.agregarFinal(H);
        hijosL.agregarFinal(I);
        L.setHijos(hijosL);


        var analizador = new AnalizadorArbol();

        Double maxProm = analizador.devolverMaximoPromedio(raiz);

        System.out.println("El maximo Promedio en este arbol: " + raiz.getDato().MiIndentificadorEs() + " es: " + maxProm);

    }
}
