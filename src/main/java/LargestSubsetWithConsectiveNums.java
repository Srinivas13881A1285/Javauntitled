import java.util.HashSet;
import java.util.Set;

/**
 * @author Srinivas_Chintakindhi
 */

public class LargestSubsetWithConsectiveNums {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 14, 4, 10, 2, 11};
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        int max = 0;
        for (int num : arr) {
            if (!set.contains(num - 1)) {
                int temp = num;

                while (set.contains(temp))
                    temp++;

                if (temp - num > max)
                    max = temp - num;
            }
        }

        System.out.println(max);

    }
}
