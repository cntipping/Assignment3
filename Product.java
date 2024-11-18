public class Product {
    private String productId;
    private String name;
    private String category;
    private double price;

    public Product(String productId, String name, String category, double price) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    private double parsePrice(String price) {
        return Double.parseDouble(price.replace("$", " "));
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return "ProductID: " + productId + ", Name: " + name + ", Category: " + category + ", Price: $" + price;
    }
}
