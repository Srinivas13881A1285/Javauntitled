import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Srinivas_Chintakindhi
 */

public class FindAllDuplicates {
    public List<Integer> findAllDuplicates(int[] arr) {
        Set<Integer> resultSet = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;

            if (arr[index] < 0) {
                resultSet.add(Math.abs(arr[i]));
            } else {
                arr[index] = -arr[index];
            }
        }

        return new ArrayList<>(resultSet);
    }

    public static void main(String[] args) {
        List<Integer> allDuplicates = new FindAllDuplicates().findAllDuplicates(new int[]{4, 2, 2, 1, 2, 4, 1});
        allDuplicates.forEach(System.out::println);
    }
}
