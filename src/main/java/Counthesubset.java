import java.util.Scanner;

/**
 * @author Srinivas_Chintakindhi
 */

public class Counthesubset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int s = scanner.nextInt();

            int[] arr = new int[n];

            int sum = 0;
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
                sum += arr[j];
            }

            int product = 1;
            for (int j = 0; j < s; j++) {
                product *= sum--;
            }

            int product2 = 1;
            while(s > 0){
                product2 *= s--;
            }

            int ans = product/product2;

            int result = (ans + 7) % 10;
            System.out.println(result);
        }
    }
}
