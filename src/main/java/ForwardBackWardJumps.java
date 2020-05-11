import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ForwardBackWardJumps {
    public static void main(String[] args) {
        int i = minimumJumps(10, new int[]{4, 6}, 4, 1);
        if (i == 0)
            System.out.println("no");
        else {
            System.out.println("yes");
            System.out.println(i);
        }
    }

    static int minimumJumps(int X, int[] arr, int k1, int k2) {
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());

        if(set.contains(X))
            return 0;

        if(k1 > X)
            return 0;

        int pos = 0;
        pos += k1;

        if (set.contains(pos))
            return 0;

        int numOfJumps = 1;

        System.out.println("step -> " +pos);
        boolean lastWasBackWardJump = false;

        while (pos < X) {

            if (!set.contains(pos + k1) && pos + k1 <= X) {
                pos += k1;
                lastWasBackWardJump = false;
            }
            else {
                if (!set.contains(pos - k2) && !lastWasBackWardJump)
                    pos -= k2;
                else
                    return 0;

                lastWasBackWardJump = true;
            }

            numOfJumps += 1;
            System.out.println("step -> " +pos);
        }

        if (pos == X)
            return numOfJumps;
        else
            return 0;
    }
}
