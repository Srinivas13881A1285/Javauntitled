import java.util.PriorityQueue;

public class PQ {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(10);
        minHeap.add(9);
        minHeap.add(8);
        minHeap.add(20);
        minHeap.add(30);

        minHeap.removeIf(e -> e == 8);
        minHeap.removeIf(e -> e == 20);

        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
        System.out.println(minHeap);
    }
}
