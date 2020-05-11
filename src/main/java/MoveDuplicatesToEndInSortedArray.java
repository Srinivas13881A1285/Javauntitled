import java.util.Arrays;

/**
 * @author Srinivas_Chintakindhi
 */

public class MoveDuplicatesToEndInSortedArray {
    public static int getUniqueNumberLengthWithRemovingDuplicates(int[] arr) {
        if (arr.length <= 1)
            return arr.length;

        int start = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1])
                arr[start++] = arr[i];
        }

        System.out.println(Arrays.toString(arr));

        return start;
    }

    public static void main(String[] args) {

        int arr[] = {1, 4, 4, 4, 5, 6, 7, 7, 8};

        System.out.println(new MoveDuplicatesToEndInSortedArray().
                getUniqueNumberLengthWithRemovingDuplicates(arr));

    }
}
