package ejercicio1;

public class TestListaDeEnterosConArreglos {
    public static void main(String[] args) {

        /// El 4to sout muestra un FALSE
        /// Esto se debe a la comparacion en Incluye que se usa "==" en vez de equals
//        var n1 = 32;
//        var n2 = 2;
//        var n3 = 57;
//        var n4 = 4400;
//        var n5 = 93;

        /// Da todo TRUE
        Integer n1 = 32;
        Integer n2 = 2;
        Integer n3 = 57;
        Integer n4 = 4400;
        Integer n5 = 93;

        /// El 4to sout muestra un FALSE
        /// Esto se debe a la comparacion en Incluye que se usa "==" en vez de equals
//        int n1 = 32;
//        int n2 = 2;
//        int n3 = 57;
//        int n4 = 4400;
//        int n5 = 93;


        ListaDeEnterosConArreglos lista = new ListaDeEnterosConArreglos();
//        lista.comenzar();

//        lista.agregarInicio(n1);
//        lista.agregarInicio(n2);
//        lista.agregarInicio(n3);
//        lista.agregarInicio(n4);
//        lista.agregarInicio(n5);

        lista.agregarFinal(n1);
        lista.agregarFinal(n2);
        lista.agregarFinal(n3);
        lista.agregarFinal(n4);
        lista.agregarFinal(n5);

        System.out.println(lista.incluye(n1));
        System.out.println(lista.incluye(n2));
        System.out.println(lista.incluye(n3));
        System.out.println(lista.incluye(n4));
        System.out.println(lista.incluye(n5));

        System.out.println("Tamanio:" + lista.tamanio());

        System.out.println(lista.elemento(1));
        System.out.println(lista.elemento(2));
        System.out.println(lista.elemento(3));
        System.out.println(lista.elemento(4));
        System.out.println(lista.elemento(5));

        System.out.println("------------------------RECURSION----------------------------");

        lista.imprimirElementosInversos();
    }
}
