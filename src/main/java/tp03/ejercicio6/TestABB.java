package tp03.ejercicio6;

import tp01.ejercicio2.ListaGenerica;

public class TestABB {
    public static void main(String[] args) {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();

        // Insertar en orden
        arbol.agregar(100);
        arbol.agregar(20);
        arbol.agregar(300);
        arbol.agregar(4);
        arbol.agregar(30);
        arbol.agregar(150);
        arbol.agregar(25);
        arbol.agregar(40);
        arbol.agregar(23);

        ArbolBinarioDeBusqueda<Integer> arbolABuscar = new ArbolBinarioDeBusqueda<>(25);

        System.out.println("Árbol creado con raíz: " + arbol.getDato());

        ListaGenerica<Integer> camino = arbol.caminoRecorrido(arbolABuscar);
        System.out.println("El camino de la raíz: " + arbol.getDato() + " Hasta el Nodo ("+arbolABuscar+") "+"Es: \n");

        camino.comenzar();
        while (!camino.fin()){
            System.out.println(camino.proximo());
        }

    }
}
