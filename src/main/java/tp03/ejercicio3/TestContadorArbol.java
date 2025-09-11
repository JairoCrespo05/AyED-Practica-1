package tp03.ejercicio3;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class TestContadorArbol {
    public static void main(String[] args) {
        // Raíz
        ArbolBinario<Integer> raiz = new ArbolBinario<>(10);

        // Hijos de la raíz
        ArbolBinario<Integer> nodo5 = new ArbolBinario<>(5);
        ArbolBinario<Integer> nodo20 = new ArbolBinario<>(20);
        raiz.agregarHijoIzquierdo(nodo5);
        raiz.agregarHijoDerecho(nodo20);

        // Hijos de 5
        ArbolBinario<Integer> nodo3 = new ArbolBinario<>(3);
        ArbolBinario<Integer> nodo7 = new ArbolBinario<>(7);
        nodo5.agregarHijoIzquierdo(nodo3);
        nodo5.agregarHijoDerecho(nodo7);

        // Hijo derecho de 20
        ArbolBinario<Integer> nodo30 = new ArbolBinario<>(30);
        nodo20.agregarHijoDerecho(nodo30);

        // 🔹 Recorrido entre niveles
        System.out.println("Recorrido entre niveles (0 a 2):");
        raiz.entreNiveles(0, 2);

        // 🔹 Cantidad de hojas
        System.out.println("Cantidad de hojas: " + raiz.contarHojas());

        // 🔹 Árbol espejo
        ArbolBinario<Integer> espejo = raiz.espejo();
        System.out.println("Recorrido entre niveles del espejo:");
        espejo.entreNiveles(0, 2);

        //Contador Arbol InOrder
        var contador = new ContadorArbol(raiz);
        ListaGenerica<Integer> listaInOrdr = contador.contarParesEnInOrden();
        System.out.println("La lista de pares InOrden es:");
        listaInOrdr.comenzar();
        while (!listaInOrdr.fin()){
            System.out.println(listaInOrdr.proximo());
        }

        //Contador Arbol PostOrder
        var contador2 = new ContadorArbol(raiz);
        ListaGenerica<Integer> listaPostOrdr = contador.contarParesEnPostOrden();
        System.out.println("La lista de pares PostOrden es:");
        listaPostOrdr.comenzar();
        while (!listaPostOrdr.fin()){
            System.out.println(listaPostOrdr.proximo());
        }

    }
}
