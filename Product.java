public class Product {
    private String productID;
    private String productName;
    private String category;
    private double price;

    public Product(String product[]) {
        this.productID = product[0];
        this.productName = product[1];
        this.category = product[2];
        try{
            String priceString = product[3].trim().replace("$", "");
            price = Double.parseDouble(priceString);
        } catch (NumberFormatException e){
            System.out.println("Error parsing price string");
        }
    }

    public Product(String productID, String productName, String category, double price) {
        this.productID = productID;
        this.productName = productName;
        this.category = category;
        this.price = price;
    }

    public String getProductID() { return productID; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Product ID: " + productID + "\nName: " + productName + "\nCategory: " + category + "\nPrice: " + price;
    }
}