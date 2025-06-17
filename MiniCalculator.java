import java.util.Scanner;

public class MiniCalculator {

    public static double add(double a, double b) { return a + b; }
    public static double subtract(double a, double b) { return a - b; }
    public static double multiply(double a, double b) { return a * b; }
    public static double divide(double a, double b) {
        if (b != 0) return a / b;
        else {
            System.out.println("Error! Division by zero.");
            return Double.NaN;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Mini Calculator!");
        System.out.println("Choose an operation (+, -, *, /):");

        String op = sc.next();  // read operation symbol

        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        double result;

        switch (op) {
            case "+":
                result = add(num1, num2);
                break;
            case "-":
                result = subtract(num1, num2);
                break;
            case "*":
                result = multiply(num1, num2);
                break;
            case "/":
                result = divide(num1, num2);
                break;
            default:
                System.out.println("Invalid operation selected.");
                return;
        }

        System.out.println("Result: " + result);
    }
}
