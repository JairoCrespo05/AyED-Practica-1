package tp02.ejercicio3;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp02.ejercicio1.ArbolGeneral;

public class TestRecorridos {
    public static void main(String[] args) {
            ListaGenerica<Integer> nrosImpares = new ListaEnlazadaGenerica<Integer>();

            // Árbol de prueba
            var arbolPadre = new ArbolGeneral<Integer>(1);
            var hijo1 = new ArbolGeneral<Integer>(2);
            var hijo2 = new ArbolGeneral<Integer>(3);
            var hijo3 = new ArbolGeneral<Integer>(4);

            // Hijos de hijo1
            var nieto1 = new ArbolGeneral<Integer>(5);
            var nieto2 = new ArbolGeneral<Integer>(6);
            var nieto3 = new ArbolGeneral<Integer>(7);

            var hijosDeHijo1 = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
            hijosDeHijo1.agregarFinal(nieto1);
            hijosDeHijo1.agregarFinal(nieto2);
            hijosDeHijo1.agregarFinal(nieto3);
            hijo1.setHijos(hijosDeHijo1);

            // Hijo de hijo3
            var nieto4 = new ArbolGeneral<Integer>(8);
            var hijosDeHijo3 = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
            hijosDeHijo3.agregarFinal(nieto4);
            hijo3.setHijos(hijosDeHijo3);

            // Hijos de la raíz
            var hijos = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
            hijos.agregarFinal(hijo1);
            hijos.agregarFinal(hijo2);
            hijos.agregarFinal(hijo3);
            arbolPadre.setHijos(hijos);

            var recorrido = new RecorridosAG();

            // Probar PreOrden
            System.out.println("PreOrden:");
            nrosImpares = recorrido.numerosImparesMayoresQuePreOrden(arbolPadre, 0);
            imprimir(nrosImpares);

            // Probar PostOrden
            System.out.println("PostOrden:");
            nrosImpares = recorrido.numerosImparesMayoresQuePostOrden(arbolPadre, 0);
            imprimir(nrosImpares);

            // Probar InOrden (generalizado)
            System.out.println("InOrden:");
            nrosImpares = recorrido.numerosImparesMayoresQueInOrden(arbolPadre, 0);
            imprimir(nrosImpares);

            // Probar Por Niveles
            System.out.println("Por Niveles:");
            nrosImpares = recorrido.numerosImparesMayoresQuePorNiveles(arbolPadre, 0);
            imprimir(nrosImpares);
    }

    private static void imprimir(ListaGenerica<Integer> lista) {
        lista.comenzar();
        while (!lista.fin()) {
            System.out.print(lista.proximo() + " ");
        }
        System.out.println();
    }

}
