import model.User;
import service.AuthService;

public class Main {
    // Định nghĩa kích thước tối đa của mảng
    private static final int MAX_USERS = 100;

    public static void main(String[] args) {
        // Khởi tạo mảng tĩnh với kích thước cố định
        User[] users = new User[MAX_USERS];

        // Khởi tạo 5 user mẫu
        users[0] = new User("panh", "123456", "zau0@email.com", "0123456789");
        users[1] = new User("dieu", "password123", "john@email.com", "0987654321");
        users[2] = new User("hoa", "securepass", "jane@email.com", "0112233445");
        users[3] = new User("quyen", "mikepass", "mike@email.com", "0998877665");
        users[4] = new User("lien", "sarah123", "sarah@email.com", "0334455667");

        int userCount = 5; // Số lượng user hiện tại

        AuthService authService = new AuthService(users, userCount);
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println(" Welcome to User Management System!");

        while (true) {
            System.out.println("\n--- Menu Auth ---");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    authService.login();
                    break;
                case "2":
                    authService.register();
                    // Cập nhật userCount sau khi đăng ký
                    userCount = authService.getUserCount();
                    break;
                case "3":
                    System.out.println("Thank you for using our system! Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! Please choose 1-3.");
            }
        }
    }
}