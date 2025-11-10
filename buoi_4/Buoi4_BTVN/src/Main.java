import function.ProductController;
import function.SmartPhone;
import user.Laptop;
import user.Product;
import user.Smartphone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Product> products = new ArrayList<>();
    private static ProductController controller;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        products.add(new Laptop(01,"Dell","nhỏ gọn",3000.2,"16GB","intell core i5"));
        products.add(new Smartphone(05,"IPhone","nhanh" ,5000,true));
        products.add(new Laptop(03,"Lenovo","nhẹ ",1000,"123Gb","Intell core i7"));
        // Khởi tạo controller với danh sách từ Main
        controller = new ProductController(products);

        System.out.println("🛒 CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM");
        showMenu();
    }

    public static void showMenu() {
        int choice;
        do {
            System.out.println("\n=== MENU CHÍNH ===");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Xóa sản phẩm theo ID");
            System.out.println("3. Tìm sản phẩm theo ID");
            System.out.println("4. Hiển thị tất cả sản phẩm");
            System.out.println("0. Thoát");
            System.out.print(" Chọn chức năng: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    addProductMenu();
                    break;
                case 2:
                    removeProductById();
                    break;
                case 3:
                    findProductById();
                    break;
                case 4:
                    controller.displayAllProducts();
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ!");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void addProductMenu() {
        System.out.println("THÊM SẢN PHẨM ---");
        System.out.println("Chọn loại sản phẩm:");
        System.out.println("1. Laptop");
        System.out.println("2. SmartPhone");
        System.out.print("Lựa chọn: ");

        int typeChoice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Nhập mô tả: ");
        String description = scanner.nextLine();
        System.out.print("Nhập giá: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer

        switch (typeChoice) {
            case 1:
                addLaptop(name, description, price);
                break;
            case 2:
                addSmartPhone(name, description, price);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    private static void addLaptop(String name, String description, double price) {
        System.out.print("Nhập RAM: ");
        String ram = scanner.nextLine();
        System.out.print("Nhập CPU: ");
        String cpu = scanner.nextLine();

        Laptop laptop = new Laptop();
        controller.addProduct(laptop);
    }

    private static void addSmartPhone(String name, String description, double price) {
        System.out.print("Có hỗ trợ 5G? (1 - Có, 0 - Không): ");
        int fiveGChoice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        boolean has5G = (fiveGChoice == 1);

        SmartPhone phone = new SmartPhone();
        controller.addProduct(phone);
    }

    private static void removeProductById() {
        System.out.print("\nNhập ID sản phẩm cần xóa: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        controller.removeById(id);
    }

    private static void findProductById() {
        System.out.print("\nNhập ID sản phẩm cần tìm: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        Product product = controller.getById(id);
        if (product != null) {
            System.out.println("Tìm thấy sản phẩm:");
            System.out.println(product.getInfo());
        } else {
            System.out.println("Không tìm thấy sản phẩm với ID: " + id);
        }
    }
}