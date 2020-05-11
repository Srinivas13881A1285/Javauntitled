import java.util.ArrayList;
import java.util.List;

/**
 * @author Srinivas_Chintakindhi
 */

public class MissingAndDuplicate {
    public static List<List<Integer>> findAllMissingAndDuplicateValues(int[] arr) {
        if (arr.length == 0) {
            return new ArrayList<>();
        }

        int i = 0;
        while (i < arr.length) {
            if (arr[i] != arr[arr[i] - 1]) {
                int otherIndex = arr[i] - 1;
                swap(arr, i, otherIndex);
            } else
                i++;
        }

        List<Integer> missingValues = new ArrayList<>();
        List<Integer> duplicateValues = new ArrayList<>();

        for (int j = 0; j < arr.length; j++) {
            if (j + 1 != arr[j]) {
                missingValues.add(j + 1);
                duplicateValues.add(arr[j]);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(missingValues);
        result.add(duplicateValues);

        return result;
    }


    public static void swap(int[] A, int i, int j) {
        int x = A[i];
        A[i] = A[j];
        A[j] = x;
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 4, 4, 3, 2};
        System.out.println(new MissingAndDuplicate().findAllMissingAndDuplicateValues(arr));
    }
}
