import java.util.Scanner;

public class Test {

    // Complete the separateNumbers function below.
    static void separateNumbers(String s) {
        boolean isValid = false;
        long startNum = -1;

        for (int i = 1; i <= s.length() / 2; i++) {
            long testFirstNum = Long.parseLong(s.substring(0, i));

            startNum = testFirstNum;

            String buildSeq = Long.toString(testFirstNum);

            while (buildSeq.length() < s.length()) {
                buildSeq += Long.toString(++testFirstNum);
            }

            if (buildSeq.equals(s)) {
                isValid = true;
                break;
            }
        }

        if (isValid)
            System.out.println("YES " + startNum);
        else
            System.out.println("NO");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            separateNumbers(s);
        }

        scanner.close();
    }
}
