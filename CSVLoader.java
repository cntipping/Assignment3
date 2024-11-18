import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class CSVLoader {
    public void load(String filePath, ProductController controller){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            br.readLine();
            while ((line = br.readLine()) != null){
                String[] values = line.split(",");
                String productID = values[0].trim();
                String name = values[1].trim();
                String category = values[2].trim();
                String price = values[3].trim();
                Product product = new Product(productID, name, category, Double.parseDouble(price));
                controller.insertProduct(product);
            }
            System.out.println("Successfully loaded products from CSV file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
