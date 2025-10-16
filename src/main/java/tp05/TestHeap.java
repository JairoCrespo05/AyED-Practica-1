package tp05;

public class TestHeap {
    public static void main(String[] args) {
        var heap = new MinHeap<Integer>();
//        var heap = new MaxHeap<Integer>();

        heap.agregar(2);
        heap.agregar(5);
        heap.agregar(3);
        heap.agregar(1);
        heap.agregar(4);
        heap.agregar(6);

        System.out.println("/////////////////ANTES DE ELIMINAR///////////");

        System.out.println("El tope es:"+heap.tope());

        heap.imprimir();

        System.out.println("/////////////////DESPUES DE ELIMINAR///////////");

        heap.eliminar();

        System.out.println("El tope es:"+heap.tope());

        heap.imprimir();
    }
}
