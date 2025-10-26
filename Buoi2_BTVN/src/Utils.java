import java.util.Scanner;

public class Utils {
    public static void input(int [] array ) {

        Scanner sc = new Scanner(System.in);


        System.out.print(" \n nhap mang ");
        for ( int i = 0 ; i < array.length ; i++) {
            array[i] = sc.nextInt() ;
        }
    }



    public static void sum(int []array ) {
        int sum = 0 ;
        for ( int i = 0 ; i < array.length ; i++){
            sum+= array[i] ;
        }
        System.out.println("tổng của dãy là " + sum );

    }

    public static void max(int []array) {
        int max = array[0] ;
        for( int i = 1 ; i < array.length ; i++){
            if (array[i] > max )
                max = array[i] ;
        }
        System.out.println("số lớn nhất trong dãy là:" + max);

    }
    public static void min(int []array) {
        int min = array[0] ;
        for( int i = 1 ; i < array.length ; i++){
            if (array[i] < min )
                min = array[i] ;
        }
        System.out.println("số nhỏ nhất trong dãy là:" + min);

    }

    public static void arrange(int []array) {
        int a = 0 ;
        for ( int i = 0 ; i < array.length ; i++){
            for ( int j = i+1 ; j < array.length ; j++){
                if( array[i] > array[j]){
                    a = array[i] ;
                    array[i] = array[j] ;
                    array[j] = a;
                }
            }
        }
        System.out.print("\n mảng đc sắp xếp là:");
        for ( int i = 0 ; i < array.length ; i++){
            System.out.print(array[i] + " ");

        }


    }

    public static boolean laSoNguyenTo(int b) {
        if (b < 2) return false;
        for (int i = 2; i <= Math.sqrt(b); i++) {
            if (b % i == 0)
                return false;
        }
        return true;
    }


    public static int soNguyenToLonNhat(int[] array) {
        int maxPrime = -1;
        for (int num : array) {
            if (laSoNguyenTo(num) && num > maxPrime) {
                maxPrime = num;
            }
        }
        return maxPrime;
    }
}





