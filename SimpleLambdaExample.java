public class SimpleLambdaExample {
    public static void main(String[] args) {
        
        // Using lambda expression to implement a simple functional interface
        Greet greet = () -> System.out.println("Hello, World!");
        
        // Calling the method
        greet.sayHello();
    }
}

// Functional Interface with a single abstract method
interface Greet {
    void sayHello();
}
