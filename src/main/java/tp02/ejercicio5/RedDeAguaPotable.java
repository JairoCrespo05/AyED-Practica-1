package tp02.ejercicio5;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp01.ejercicio3.ColaGenerica;
import tp02.ejercicio1.ArbolGeneral;

public class RedDeAguaPotable {

    public RedDeAguaPotable(){

    }


    public double minimoCaudal(double caudal, ArbolGeneral<String> arbol){
        double minimoCaudal = caudal;

        if(arbol.esVacio()) return minimoCaudal;

        if (arbol.esHoja())  return caudal;

        if(arbol.tieneHijos()){
              ListaGenerica<ArbolGeneral<String>> hijos = arbol.getHijos();

              int divisionEquitativa = hijos.tamanio();
              double caudalPorHijo = caudal / divisionEquitativa;

              hijos.comenzar();
              while (!hijos.fin()){

                  ArbolGeneral<String> hijoActual = hijos.proximo();

                  double caudalHijo = minimoCaudal(caudalPorHijo, hijoActual);

                  System.out.println("Nodo " + hijoActual.getDato() + " recibe " + caudalPorHijo);

                  if(caudalHijo < minimoCaudal){
                      minimoCaudal = caudalHijo;
                  }
              }
        }
        return minimoCaudal;
    }


}
