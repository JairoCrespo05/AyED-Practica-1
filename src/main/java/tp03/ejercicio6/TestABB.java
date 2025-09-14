package tp03.ejercicio6;

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

        System.out.println("Árbol creado con raíz: " + arbol.getDato());
    }
}
