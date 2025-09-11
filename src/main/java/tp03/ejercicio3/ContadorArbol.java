package tp03.ejercicio3;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ContadorArbol {

    private ArbolBinario<Integer> arbolBinario;

    public ContadorArbol(ArbolBinario<Integer> arbolBinario){
        this.arbolBinario = arbolBinario;
    }


    public ListaGenerica<Integer> contarParesEnPostOrden(){
        ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
         lista.comenzar();
        return this.contarParesEnPostOrden(lista, this.arbolBinario);
    }

    private ListaGenerica<Integer> contarParesEnPostOrden(ListaGenerica<Integer> lista, ArbolBinario<Integer> arbol){

        if (arbol.esVacio()){ return null;}

        //Hijo Izquierdo
        if (arbol.tieneHijoIzquierdo()){
            contarParesEnPostOrden(lista, arbol.getHijoIzquierdo());
        }

        //Hijo Derecho
        if (arbol.tieneHijoDerecho()){
            contarParesEnPostOrden(lista, arbol.getHijoDerecho());
        }

        //Raiz
        Integer numero = arbol.getDato();
        if (numero %2 == 0){
            lista.agregarFinal(numero);
        }

        return lista;
    }

    private ListaGenerica<Integer> contarParesEnInOrden(ListaGenerica<Integer> lista, ArbolBinario<Integer> arbolBinario){

        if (arbolBinario.esVacio()){ return null;}

        //Hijo Izquierdo
        if (arbolBinario.tieneHijoIzquierdo()){
            contarParesEnPostOrden(lista, arbolBinario.getHijoIzquierdo());
        }

        //Raiz
        Integer numero = arbolBinario.getDato();
        if (numero %2 == 0){
            lista.agregarFinal(numero);
        }

        //Hijo Derecho
        if (arbolBinario.tieneHijoDerecho()){
            contarParesEnPostOrden(lista, arbolBinario.getHijoDerecho());
        }

        return lista;
    }




    public ListaGenerica<Integer> contarParesEnInOrden(){
        ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
        lista.comenzar();
        return contarParesEnInOrden(lista, this.arbolBinario);
    }


}
