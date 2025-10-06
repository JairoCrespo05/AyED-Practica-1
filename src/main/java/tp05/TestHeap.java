package tp05;

public class TestHeap {
    public static void main(String[] args) {
        var heap = new MinHeap<Integer>();
        heap.agregar(2);
        heap.agregar(5);
        heap.agregar(3);
        heap.agregar(1);
        heap.agregar(4);
        heap.agregar(6);


        heap.imprimir();
    }
}
