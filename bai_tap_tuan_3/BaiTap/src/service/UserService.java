package service;

import model.User;
import java.util.Scanner;

public class UserService {
    private User[] users;
    private int userCount;
    private Scanner scanner;

    public UserService(User[] users, int userCount) {
        this.users = users;
        this.userCount = userCount;
        this.scanner = new Scanner(System.in);
    }

    public void changePassword(String userId) {
        System.out.println("\n=== CHANGE PASSWORD ===");

        User user = findUserById(userId);
        if (user == null) {
            System.out.println(" User not found!");
            return;
        }

        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        System.out.print("Confirm new password: ");
        String confirmPassword = scanner.nextLine();

        if (newPassword.length() < 6) {
            System.out.println(" Password must be at least 6 characters long!");
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            System.out.println(" Passwords do not match!");
            return;
        }

        user.setPassword(newPassword);
        System.out.println(" Password changed successfully!");
    }

    private User findUserById(String userId) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getId().equals(userId)) {
                return users[i];
            }
        }
        return null;
    }

    // Setter để cập nhật userCount
    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }
}