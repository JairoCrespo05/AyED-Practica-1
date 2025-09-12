package tp03.ejercicio5;

import tp03.ejercicio1.ArbolBinario;

public class TestProfundidadDeArbolLleno {
    public static void main(String[] args) {
        // Nivel 2 (hojas)
        ArbolBinario<Integer> nodo4 = new ArbolBinario<>(4);
        ArbolBinario<Integer> nodo2 = new ArbolBinario<>(2);
        ArbolBinario<Integer> nodo6 = new ArbolBinario<>(6);
        ArbolBinario<Integer> nodo1 = new ArbolBinario<>(1);

        // Nivel 1
        ArbolBinario<Integer> nodo3 = new ArbolBinario<>(3);
        nodo3.agregarHijoIzquierdo(nodo4);
        nodo3.agregarHijoDerecho(nodo2);

        ArbolBinario<Integer> nodo7 = new ArbolBinario<>(7);
        nodo7.agregarHijoIzquierdo(nodo6);
        nodo7.agregarHijoDerecho(nodo1);

        // Raíz
        ArbolBinario<Integer> raiz = new ArbolBinario<>(5);
        raiz.agregarHijoIzquierdo(nodo3);
        raiz.agregarHijoDerecho(nodo7);

        // Ahora ya tenés un árbol binario lleno de Integer
        System.out.println("Árbol binario lleno creado con raíz = " + raiz.getDato());

        var calculadoraEnProf = new ProfundidadDeArbolBinario(raiz);
        int prof = 1;

        System.out.println("La suma de los numeros en el nivel ("+ prof +") es: "+ calculadoraEnProf.sumaElementosProfundidad(prof));
    }
}
