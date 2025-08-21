package tp01.ejercicio3;

import tp01.ejercicio2.ListaEnlazadaGenerica;

public class TestColaYPilaGnerica {
    public static void main(String[] args) {

        /**
         * Testeo de la estructura Cola
         */

        var cola = new ColaGenerica<Integer>(new ListaEnlazadaGenerica<>());

        cola.encolar(12);
        cola.encolar(13);
        cola.encolar(14);

        System.out.println(cola.tope());

        cola.desencolar();
        cola.desencolar();
//        cola.desencolar();

        System.out.println("-----------------MODIFICACION----------------------");
        System.out.println(cola.tope());

        /**
         * Testeo de la estructura Pila
         */

        var pila = new PilaGenerica<Integer>(new ListaEnlazadaGenerica<>());

        pila.apilar(12);
        pila.apilar(13);
        pila.apilar(14);


        System.out.println(pila.tope());

        System.out.println(pila.desapilar());
        System.out.println(pila.desapilar());
//        System.out.println(pila.desapilar());


        System.out.println("-----------------MODIFICACION----------------------");
        System.out.println(pila.tope());

    }
}
