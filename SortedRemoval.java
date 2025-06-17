import java.util.PriorityQueue;
import java.util.Scanner;

public class SortedRemoval {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        System.out.print("Enter number of elements (N): ");
        int n = scanner.nextInt();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            queue.add(num); // Inserting element into priority queue
        }

        System.out.println("\nRemoving elements in sorted order:");
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " "); // Removes and prints the smallest element
        }

        scanner.close();
    }
}
