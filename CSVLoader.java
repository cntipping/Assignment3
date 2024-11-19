import java.io.BufferedReader;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;

public class CSVLoader {
    private RedBlackBST<String, Product> productTree;

    public CSVLoader() {
        productTree = new RedBlackBST<>();
    }

    /* public void load(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String productID = values[0].trim();
                String productName = values[1].trim();
                String category = values[2].trim();
                double price;

                try{
                    String priceString = values[3].trim().replace("$", "");
                    price = Double.parseDouble(priceString);
                } catch (NumberFormatException e){
                    System.out.println("Error parsing price string");
                    continue;
                }

                Product product = new Product(productID, productName, category, price);
                productTree.insert(productID, product);
            }
            System.out.println("CSV file loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    } */
    /* public void readCSV(String fileName) {
        try {
            RedBlackBST<String, Product> prodRBTree= new RedBlackBST<String, Product>();
            FileReader productCSV = new FileReader(fileName);
            CSVReader csvReader = new CSVReader(productCSV);
            String[] next;
            while ((next = csvReader.readNext()) != null){
                for(String cell : next){
                    Product product = new Product(next);
                    prodRBTree.insert(product.getProductID(), product);
                }
            }
            this.productTree = productTree;
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }*/

    public Product search(String productID) {
        return productTree.search(productID);
    }

    public void insert(String productID, Product product) {
        productTree.insert(productID, product);
    }
    public void readCSV(String fileName) {
        try (CSVReader csvReader = new CSVReader(new FileReader(fileName))) {
            String[] nextLine;

            // Skip header
            csvReader.readNext();

            while ((nextLine = csvReader.readNext()) != null) {
                // Check if there are exactly 4 columns
                if (nextLine.length != 4) {
                    System.out.println("Skipping malformed line: " + String.join(",", nextLine));
                    continue;
                }

                String productID = nextLine[0].trim();
                String productName = nextLine[1].trim();
                String category = nextLine[2].trim();
                double price;

                // Remove $ sign if present and parse the price
                try {
                    String priceString = nextLine[3].trim().replace("$", "").trim();
                    price = Double.parseDouble(priceString);
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing price string: " + nextLine[3]);
                    continue;
                }

                Product product = new Product(productID, productName, category, price);
                productTree.insert(productID, product);
            }
            System.out.println("CSV file loaded successfully.");
        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}