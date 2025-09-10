package tp03.ejercicio1;

public class TestArbolBinario {

    public static void main(String[] args) {
        // Nodo raíz
        ArbolBinario<String> raiz = new ArbolBinario<>("A");

        // Hijos de la raíz
        ArbolBinario<String> nodoB = new ArbolBinario<>("B");
        ArbolBinario<String> nodoC = new ArbolBinario<>("C");
        raiz.agregarHijoIzquierdo(nodoB);
        raiz.agregarHijoDerecho(nodoC);

        // Hijos de B
        ArbolBinario<String> nodoD = new ArbolBinario<>("D");
        ArbolBinario<String> nodoE = new ArbolBinario<>("E");
        nodoB.agregarHijoIzquierdo(nodoD);
        nodoB.agregarHijoDerecho(nodoE);

        // Hijo derecho de C
        ArbolBinario<String> nodoF = new ArbolBinario<>("F");
        nodoC.agregarHijoDerecho(nodoF);

        // Probamos entreNiveles
        System.out.println("Recorrido entre niveles 0 y 2:");
        raiz.entreNiveles(0, 2);

        // Probamos contar hojas
        System.out.println("Cantidad de hojas: " + raiz.contarHojas());

        // Probamos espejo
        ArbolBinario<String> espejo = raiz.espejo();
        System.out.println("Recorrido entre niveles (espejo):");
        espejo.entreNiveles(0, 2);
    }

}
