import java.util.PriorityQueue;
import java.util.Scanner;

// Task class with priority, implements Comparable
class Task implements Comparable<Task> {
    String name;
    int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int compareTo(Task other) {
        // Sort by priority ascending (lower number = higher priority)
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + "}";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- Part 1: Tasks with priority ---
        System.out.print("Enter number of tasks: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        PriorityQueue<Task> taskQueue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter task name:");
            String name = scanner.nextLine();

            System.out.println("Enter task priority (lower number = higher priority):");
            int priority = scanner.nextInt();
            scanner.nextLine();

            taskQueue.add(new Task(name, priority));
        }

        System.out.println("\nTasks sorted by priority:");
        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll());
        }


        // --- Part 2: Find K largest elements in an array ---
        System.out.print("\nEnter size of array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter value of K: ");
        int K = scanner.nextInt();

        int[] kLargest = findKLargest(arr, K);
        System.out.println("K largest elements are:");
        for (int val : kLargest) {
            System.out.print(val + " ");
        }

        scanner.close();
    }

    // Function to find K largest elements using a min-heap (PriorityQueue)
    public static int[] findKLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest to keep only k largest
            }
        }

        // Extract results from minHeap into array
        int[] result = new int[minHeap.size()];
        int idx = 0;
        while (!minHeap.isEmpty()) {
            result[idx++] = minHeap.poll();
        }

        // Optional: sort result descending (largest first)
        java.util.Arrays.sort(result);
        for (int i = 0; i < result.length / 2; i++) {
            int temp = result[i];
            result[i] = result[result.length - 1 - i];
            result[result.length - 1 - i] = temp;
        }

        return result;
    }
}
