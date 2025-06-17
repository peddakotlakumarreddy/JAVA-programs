import java.util.PriorityQueue;

public class MinHeap{
    public static void main(String[] args) {
        // Create a min heap using PriorityQueue (default behavior)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Insert values into the min heap
        minHeap.offer(20);
        minHeap.offer(15);
        minHeap.offer(30);
        minHeap.offer(5);
        minHeap.offer(10);

        // Print the elements of the min heap
        System.out.println("MinHeap elements (not necessarily sorted):");
        for (Integer val : minHeap) {
            System.out.print(val + " ");
        }
        System.out.println();

        // To print in sorted order, poll elements from the min heap
        System.out.println("MinHeap elements in ascending order:");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
    }
}

