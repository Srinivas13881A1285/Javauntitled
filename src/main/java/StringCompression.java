/**
 * @author Srinivas_Chintakindhi
 */

public class StringCompression {
    public String compress(String s) {
        String result = "";
        int sum = 1;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                sum += 1;
            } else {
                result = result + s.charAt(i) + sum;
                sum = 1;
            }
        }

        result = result + s.charAt(s.length() - 1) + sum;

        return result.length() < s.length() ? result : s;
    }

    public static void main(String[] args) {
        String aaabbbccc = new StringCompression().compress("aabbbbbb");
        System.out.println("aaabbbccc = " + aaabbbccc);
    }
}
