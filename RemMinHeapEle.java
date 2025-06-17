import java.util.PriorityQueue;

public class RemMinHeapEle{
    public static void main(String[] args) {
        // Create a min heap using PriorityQueue (default behavior)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Insert values into the min heap
        minHeap.offer(20);
        minHeap.offer(15);
        minHeap.offer(30);
        minHeap.offer(5);
        minHeap.offer(10);

        System.out.println("Removing elements from MinHeap:");

        // Repeatedly remove the min element and print it
        while (!minHeap.isEmpty()) {
            int min = minHeap.poll();  // removes and returns the smallest element
            System.out.println(min);
        }
    }
}
