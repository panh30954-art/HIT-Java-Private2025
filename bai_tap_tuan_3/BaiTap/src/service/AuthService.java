package service;

import model.User;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AuthService {
    private User[] users;
    private int userCount;
    private Scanner scanner;
    private UserService userService;

    public AuthService(User[] users, int userCount) {
        this.users = users;
        this.userCount = userCount;
        this.scanner = new Scanner(System.in);
        this.userService = new UserService(users, userCount);
    }

    public void login() {
        System.out.println("\n=== LOGIN ===");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println(" Username and password cannot be empty!");
            return;
        }

        for (int i = 0; i < userCount; i++) {
            User user = users[i];
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println(" Login successful! Welcome " + username);
                userMenu(user);
                return;
            }
        }
        System.out.println(" Invalid username or password!");
    }

    public void register() {
        if (userCount >= users.length) {
            System.out.println(" User database is full! Cannot register new user.");
            return;
        }

        System.out.println("\n=== REGISTER ===");

        String username = getValidatedInput("Username: ", this::isValidUsername);
        String password = getValidatedInput("Password: ", this::isValidPassword);
        String email = getValidatedInput("Email: ", this::isValidEmail);
        String phoneNumber = getValidatedInput("Phone Number: ", this::isValidPhoneNumber);

        for (int i = 0; i < userCount; i++) {
            if (users[i].getUsername().equals(username)) {
                System.out.println(" Username already exists!");
                return;
            }
        }

        User newUser = new User(username, password, email, phoneNumber);
        users[userCount] = newUser;
        userCount++;
        System.out.println(" Registration successful! User ID: " + newUser.getId());

        userService.setUserCount(userCount);
    }

    private String getValidatedInput(String prompt, Validator validator) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (validator.validate(input)) {
                return input;
            }
        }
    }

    private boolean isValidUsername(String username) {
        if (username.length() < 3) {
            System.out.println(" Username must be at least 3 characters long!");
            return false;
        }
        return true;
    }

    private boolean isValidPassword(String password) {
        if (password.length() < 6) {
            System.out.println("Password must be at least 6 characters long!");
            return false;
        }
        return true;
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!Pattern.compile(emailRegex).matcher(email).matches()) {
            System.out.println(" Invalid email format!");
            return false;
        }
        return true;
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        String phoneRegex = "^[0-9]{10,11}$";
        if (!Pattern.compile(phoneRegex).matcher(phoneNumber).matches()) {
            System.out.println(" Phone number must be 10-11 digits!");
            return false;
        }
        return true;
    }

    private void userMenu(User user) {
        while (true) {
            System.out.println("\n--- User Menu ---");
            System.out.println("1. Change Password");
            System.out.println("2. View Profile");
            System.out.println("3. Logout");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    userService.changePassword(user.getId());
                    break;
                case "2":
                    System.out.println(user.toString());
                    break;
                case "3":
                    System.out.println("Logged out successfully!");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    @FunctionalInterface
    private interface Validator {
        boolean validate(String input);
    }

    // Getter để lấy userCount mới nhất
    public int getUserCount() {
        return userCount;
    }
}