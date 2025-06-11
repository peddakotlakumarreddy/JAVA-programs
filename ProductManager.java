import java.util.*;

class Product {
    private String name;
    private double price;
    private double rating;

    public Product(String name, double price, double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Price: $" + price + ", Rating: " + rating;
    }
}

public class ProductManager {
    public static void main(String[] args) {
        Map<String, Product> products = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Product Manager Menu =====");
            System.out.println("1. Add Product");
            System.out.println("2. Search Product");
            System.out.println("3. Display All Products");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();

                    if (products.containsKey(name)) {
                        System.out.println("Product already exists. Try updating it instead.");
                        break;
                    }

                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Rating (0.0 to 5.0): ");
                    double rating = scanner.nextDouble();
                    scanner.nextLine(); // consume newline

                    products.put(name, new Product(name, price, rating));
                    System.out.println("Product added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Product Name to Search: ");
                    String searchName = scanner.nextLine();
                    Product product = products.get(searchName);
                    if (product != null) {
                        System.out.println("Product Found: " + product);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3:
                    if (products.isEmpty()) {
                        System.out.println("No products available.");
                    } else {
                        System.out.print("Sort by price Ascending or Descending? (A/D): ");
                        String order = scanner.nextLine().trim().toUpperCase();

                        List<Product> productList = new ArrayList<>(products.values());

                        if (order.equals("A")) {
                            productList.sort(Comparator.comparingDouble(Product::getPrice));
                        } else if (order.equals("D")) {
                            productList.sort(Comparator.comparingDouble(Product::getPrice).reversed());
                        } else {
                            System.out.println("Invalid choice, showing unsorted list.");
                        }

                        System.out.println("\nAll Products:");
                        for (Product p : productList) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting Product Manager. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
