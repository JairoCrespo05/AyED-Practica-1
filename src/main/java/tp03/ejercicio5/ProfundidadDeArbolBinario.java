package tp03.ejercicio5;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ProfundidadDeArbolBinario {
    private ArbolBinario<Integer> arbolBinario;

    public ProfundidadDeArbolBinario(ArbolBinario<Integer> arbolBinario) {
        this.arbolBinario = arbolBinario;
    }


    public int sumaElementosProfundidad(int p){
        ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<>(new ListaEnlazadaGenerica<>());
        int resFinal = 0;
        int profActual = 0;
        boolean calculado = false;

        if (this.arbolBinario.esVacio()){
            return 0;
        }

        cola.encolar(this.arbolBinario);
        while (!cola.esVacia()){
            int nodosXNivel = cola.tamanio();

            for (int i=0; i< nodosXNivel; i++){
                ArbolBinario<Integer> actual = cola.tope();
                cola.desencolar();

                if(profActual == p){
                    resFinal += actual.getDato();
                    calculado = true;
                }

                if (actual.tieneHijoIzquierdo() && !calculado){
                    cola.encolar(actual.getHijoIzquierdo());
                }

                if (actual.tieneHijoDerecho() && !calculado){
                    cola.encolar(actual.getHijoDerecho());
                }
            }

            profActual++;
        }

        return resFinal;
    }
}
