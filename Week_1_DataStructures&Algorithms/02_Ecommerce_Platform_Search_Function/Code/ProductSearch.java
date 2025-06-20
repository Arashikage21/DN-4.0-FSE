import java.util.Arrays;
import java.util.Scanner;

class Product {
    int id;
    String name;
    String category;

    public Product(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product ID: " + id + ", Name: " + name + ", Category: " + category;
    }
}

public class ProductSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Product[] products = readProductsFromUser(scanner);

        // Sort products by ID for binary search
        Arrays.sort(products, (p1, p2) -> Integer.compare(p1.id, p2.id));

        System.out.print("\nEnter the Product ID to search: ");
        int searchId = scanner.nextInt();

        searchAndDisplayResult(products, searchId);

        scanner.close();
    }

    // Method to read product details from user
    public static Product[] readProductsFromUser(Scanner scanner) {
        System.out.print("Enter number of products: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Product[] products = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Product " + (i + 1) + " ---");

            System.out.print("Enter Product ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Product Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Category: ");
            String category = scanner.nextLine();

            products[i] = new Product(id, name, category);
        }

        return products;
    }

    // Method to perform both linear and binary search and print results
    public static void searchAndDisplayResult(Product[] products, int productId) {
        Product linearResult = linearSearch(products, productId);
        System.out.println("\n--- Linear Search ---");
        if (linearResult != null) {
            System.out.println("Product Found: " + linearResult);
        } else {
            System.out.println("Product not found.");
        }

        Product binaryResult = binarySearch(products, productId);
        System.out.println("\n--- Binary Search ---");
        if (binaryResult != null) {
            System.out.println("Product Found: " + binaryResult);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Linear search
    public static Product linearSearch(Product[] products, int id) {
        for (Product p : products) {
            if (p.id == id) {
                return p;
            }
        }
        return null;
    }

    // Binary search
    public static Product binarySearch(Product[] products, int id) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (products[mid].id == id)
                return products[mid];
            else if (products[mid].id < id)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null;
    }
}
