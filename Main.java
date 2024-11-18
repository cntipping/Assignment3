import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        ProductController controller = new ProductController();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter path to CSV file: ");
        String filePath = scanner.nextLine();
        controller.loadProducts(filePath);

        while (true) {
            System.out.println("Options: [1] Search for Product by ID [2] Exit Program");
            System.out.println("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter product ID to search: ");
                String productID = scanner.nextLine();
                controller.searchProduct(productID);
            } else if (choice == 2) {
                break;
            } else {
                System.out.println("Invalid choice");
            }
            scanner.close();
        }
    }
}