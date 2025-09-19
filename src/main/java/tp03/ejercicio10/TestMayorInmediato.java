package tp03.ejercicio10;

import tp03.ejercicio6.ArbolBinarioDeBusqueda;

public class TestMayorInmediato {
    public static void main(String[] args) {
        // Armo el árbol manualmente
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>(50);

        arbol.agregar(30);
        arbol.agregar(70);
        arbol.agregar(20);
        arbol.agregar(40);
        arbol.agregar(60);
        arbol.agregar(80);

        // Pruebas
        System.out.println("Mayor inmediato de 55: " + arbol.mayorInmediato(55)); // debería dar 60
        System.out.println("Mayor inmediato de 30: " + arbol.mayorInmediato(30)); // debería dar 40
        System.out.println("Mayor inmediato de 70: " + arbol.mayorInmediato(70)); // debería dar 80
        System.out.println("Mayor inmediato de 80: " + arbol.mayorInmediato(80)); // debería dar null o -1 (no hay mayor)
        System.out.println("Mayor inmediato de 10: " + arbol.mayorInmediato(10)); // debería dar 20

    }
}
