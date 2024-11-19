import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CSVLoader csvLoader = new CSVLoader();
        Scanner scanner = new Scanner(System.in);

        // Load products from CSV file
        System.out.print("Enter the path to the CSV file: ");
        // /Users/ceciliatipping/IdeaProjects/A3/amazon-product-data.csv
        String fileName = scanner.nextLine();
        csvLoader.readCSV(fileName);

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("[1] Search for a product by ID");
            System.out.println("[2] Insert a new product");
            System.out.println("[3] Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Search for a product by ID
                    System.out.print("Enter Product ID to search: ");
                    String searchID = scanner.nextLine();
                    Product product = csvLoader.search(searchID);
                    if (product != null) {
                        System.out.println("Product found: " + product);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 2:
                    // Insert a new product
                    System.out.print("Enter Product ID: ");
                    String productID = scanner.nextLine();

                    // Check if product ID already exists
                    if (csvLoader.search(productID) != null) {
                        System.out.println("Error: Product with this ID already exists.");
                        break;
                    }

                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter Product Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter Product Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    Product newProduct = new Product(productID, productName, category, price);
                    csvLoader.insert(productID, newProduct);
                    System.out.println("Product inserted successfully!");
                    break;

                case 3:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}