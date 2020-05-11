/**
 * @author Srinivas_Chintakindhi
 */

public class ClimbStairs {
    public static void main(String[] args) {
        int n = 3;

        int ans = ways(n);
        System.out.println("ways = " + ans);
    }

    static int ways(int n) {
        if (n == 0)
            return 1;

        if (n < 0)
            return 0;

        int ans = ways(n - 1) + ways(n - 2);

        return ans;
    }
}
