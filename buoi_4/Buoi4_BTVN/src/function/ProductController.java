package function;

import user.Laptop;
import user.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductController {
    private List<Product> products;
    public ProductController(List<Product> products) {
        this.products = new ArrayList<>(products);
        syncProductIds();
    }

    // Đồng bộ ID cho tất cả sản phẩm
    private void syncProductIds() {
        for (int i = 0; i < this.products.size(); i++) {
            this.products.get(i).setId(i + 1);
        }
    }

    public void addProduct(Product product) {
        products.add(product);
        syncProductIds();
    }

    public void addProduct(String type, String name, String description, double price) {
        Product product;
        switch (type.toLowerCase()) {
            case "laptop":
                product = new Laptop();
                break;
            case "smartphone":
                product = new SmartPhone();
                break;
            default:
                product = new Product();
        }
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        addProduct(product);
    }

    public boolean removeById(int id) {
        boolean removed = products.removeIf(product -> product.getId() == id);
        if (removed) {
            syncProductIds();
        }
        return removed;
    }

    public Product getById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        System.out.println("\n=== ALL PRODUCTS ===");
        for (Product product : products) {
            System.out.println(product.getInfo());
        }
    }

    public void displayProductById(int id) {
        Product product = getById(id);
        if (product != null) {
            System.out.println("\n=== PRODUCT FOUND ===");
            System.out.println(product.getInfo());
        } else {
            System.out.println("Product with ID " + id + " not found.");
        }
    }
}

