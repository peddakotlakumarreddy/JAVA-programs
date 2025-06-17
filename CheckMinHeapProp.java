public class CheckMinHeapProp {
    
    // Function to check if array represents a Min-Heap
    public static boolean isMinHeap(int[] arr) {
        int n = arr.length;

        // Check for every parent node
        for (int i = 0; i <= (n - 2) / 2; i++) {
            int left = 2 * i + 1;   // left child index
            int right = 2 * i + 2;  // right child index

            // If left child exists and is smaller than parent -> Not min heap
            if (left < n && arr[i] > arr[left]) {
                return false;
            }

            // If right child exists and is smaller than parent -> Not min heap
            if (right < n && arr[i] > arr[right]) {
                return false;
            }
        }

        // If no violations found, it's a min heap
        return true;
    }

    public static void main(String[] args) {
        int[] heap1 = {5, 10, 15, 20, 30};
        int[] heap2 = {10, 5, 15, 20, 30};

        System.out.println("heap1 is min heap? " + isMinHeap(heap1)); // true
        System.out.println("heap2 is min heap? " + isMinHeap(heap2)); // false
    }
}
