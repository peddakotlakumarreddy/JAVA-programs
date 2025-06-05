import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianFromDataStream {
    private PriorityQueue<Integer> maxHeap; // smaller half
    private PriorityQueue<Integer> minHeap; // larger half

    public MedianFromDataStream() {
        maxHeap = new PriorityQueue<>((a,b) -> b - a); // max heap
        minHeap = new PriorityQueue<>(); // min heap
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // Balance heaps so that the size difference is at most 1
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            // even number of elements
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFromDataStream medianFinder = new MedianFromDataStream();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter the elements one by one:");

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            medianFinder.addNum(num);
            System.out.println("Current median: " + medianFinder.findMedian());
        }

        scanner.close();
    }
}
