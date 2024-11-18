public class ProductController {
    private RedBlackBST<String, Product> productTree = new RedBlackBST<>();

    public void insertProduct(Product product) {
        productTree.put(product.getProductId(), product);
        System.out.println("Inserted product: " + product.getProductId());
    }

    public Product searchProduct(String productId) {
        Product product = productTree.get(productId);
        if (product != null) {
            System.out.println("Product not found for ID: " + productId);
        } else {
            System.out.println("Product found for ID: " + productId);
        }
        return product;
    }

    public void loadProducts(String filePath) {
        CSVLoader loader = new CSVLoader();
        loader.load(filePath, this);
    }
}
