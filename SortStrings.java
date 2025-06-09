import java.util.Arrays;

public class SortStrings {
    public static void main(String[] args) {
        String[] strings = {"banana", "apple", "orange", "grape"};

        // Sort the array alphabetically
        Arrays.sort(strings);

        // Print the sorted array
        System.out.println("Sorted array:");
        for (String str : strings) {
            System.out.println(str);
        }
    }
}