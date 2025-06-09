public class BubbleSortWithSwapCount {

    // Method to perform bubble sort and count swaps
    public static int bubbleSortWithSwapCount(int[] arr) {
        int n = arr.length;
        int swapCount = 0;
        boolean swapped;

        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop for comparing adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapCount++;
                    swapped = true;
                }
            }

            // If no swaps occurred in this pass, the array is sorted
            if (!swapped)
                break;
        }

        return swapCount;
    }

    // Method to print the array
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};

        System.out.println("Original array:");
        printArray(arr);

        int totalSwaps = bubbleSortWithSwapCount(arr);

        System.out.println("Sorted array:");
        printArray(arr);

        System.out.println("Total number of swaps: " + totalSwaps);
    }
}
