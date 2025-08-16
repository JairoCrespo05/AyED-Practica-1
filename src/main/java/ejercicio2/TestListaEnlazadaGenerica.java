package ejercicio2;

public class TestListaEnlazadaGenerica {
    public static void main(String[] args) {

        Estudiante estudiante1 = new Estudiante("julian", "alvarez", "Es1234");
        Estudiante estudiante2 = new Estudiante("martin", "palermo", "Es14");
        Estudiante estudiante3 = new Estudiante("diego", "maradona", "Es100");
        Estudiante estudiante4 = new Estudiante("facundo", "colidio", "Es2500");

        ListaEnlazadaGenerica lista = new ListaEnlazadaGenerica();

        lista.comenzar();
        lista.agregarFinal(estudiante1);
        lista.agregarFinal(estudiante2);
        lista.agregarFinal(estudiante3);
        lista.agregarFinal(estudiante4);

        System.out.println(lista);



    }
}
