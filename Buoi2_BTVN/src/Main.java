import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap n= ");
        int n = sc.nextInt();
        int[] array = new int[n];
        Utils.input(array);
        System.out.println("\n--- Menu ---");
        System.out.println("1. Tính tổng các phần tử trong mảng");
        System.out.println("2. In ra phần tử lớn nhất, nhỏ nhất trong mảng");
        System.out.println("3. Sắp xếp lại mảng theo chiều tăng dần");
        System.out.println("4. In ra số nguyên tố lớn nhất trong mảng");
        System.out.print("Nhập lựa chọn: ");
        int chose = sc.nextInt();
        switch (chose) {
            case 1:

                Utils.sum(array);
                break;
            case 2:
                Utils.max(array);
                Utils.min(array);
                break;
            case 3:
                Utils.arrange(array);
                break ;
            case 4:
                int maxPrime = Utils.soNguyenToLonNhat(array);
                if (maxPrime == -1)
                    System.out.println("Không có số nguyên tố nào trong mảng.");
                else
                    System.out.println("Số nguyên tố lớn nhất trong mảng là: " + maxPrime);
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }
}