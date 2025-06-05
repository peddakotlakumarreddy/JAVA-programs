import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaxHeapExample {
    public static void main(String[] args) {
        // Creating a max-heap using a PriorityQueue with a reverse comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements (N): ");
        int n = scanner.nextInt();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            maxHeap.add(num); // Insert into max-heap
        }

        System.out.println("\nRemoving elements in max-heap order:");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " "); // Removes and prints the largest element
        }

        scanner.close();
    }
}
