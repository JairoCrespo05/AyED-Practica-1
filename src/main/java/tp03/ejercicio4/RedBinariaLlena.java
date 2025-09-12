package tp03.ejercicio4;

import tp03.ejercicio1.ArbolBinario;

public class RedBinariaLlena {
    private ArbolBinario<Integer> arbolBinario;

    public RedBinariaLlena(ArbolBinario<Integer> arbolBinario){
        this.arbolBinario = arbolBinario;
    }

    public int retardoReenvio(){
        return retardoReenvio(this.arbolBinario);
    }


    private int retardoReenvio(ArbolBinario<Integer> arbol) {
        if (arbol.esVacio()) {
            return 0;
        }

        int dato = arbol.getDato();
        if (arbol.esHoja()) {
            return dato;
        }

        int datoHIzq = 0;
        if (arbol.tieneHijoIzquierdo()) {
            datoHIzq = dato + retardoReenvio(arbol.getHijoIzquierdo());
        }
        int datoHDer = 0;
        if (arbol.tieneHijoDerecho()) {
            datoHDer = dato + retardoReenvio(arbol.getHijoDerecho());
        }

        return datoHIzq > datoHDer ? datoHIzq : datoHDer;

    }
}
