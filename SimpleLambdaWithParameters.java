public class SimpleLambdaWithParameters {
    public static void main(String[] args) {
        
        // Lambda expression to add two numbers
        Adder add = (a, b) -> a + b;
        
        // Calling the lambda function with parameters
        int result = add.add(5, 10);
        
        System.out.println("The sum is: " + result);
    }
}

// Functional Interface
interface Adder {
    int add(int a, int b);
}
