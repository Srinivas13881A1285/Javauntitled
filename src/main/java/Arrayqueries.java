import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Srinivas_Chintakindhi
 */

public class Arrayqueries {
    static int[] arr;
    static Pattern pattern = Pattern.compile("\\d+");

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = scanner.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int rotations = 0;
        int q = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < q; i++) {
            String query = scanner.nextLine();
            if (query.startsWith("Increment")) {
                int readVal = getIncrementnPos(query);
                int originalIndex = getOriginalIndex(arr, rotations, readVal - 1);
                arr[originalIndex] = arr[originalIndex] + 1;
            } else if (query.startsWith("Update")) {
                List<Integer> nums = getUpdateVals(query);
                int readPos = nums.get(0);
                int readVal = nums.get(1);
                int originalIndex = getOriginalIndex(arr, rotations, readPos - 1);
                arr[originalIndex] = readVal;
            } else if (query.startsWith("?")) {
                int readIndex = getPrintIndex(query);
                int originalIndex = getOriginalIndex(arr, rotations, readIndex - 1);
                System.out.println(arr[originalIndex]);
            } else if (query.startsWith("Left")) {
                rotations -= 1;
            } else if (query.startsWith("Right")) {
                rotations += 1;
            }
        }

    }

    private static int getOriginalIndex(int[] arr, int rotations, int readIndex) {
        int originalIndex = 0;
        int n = arr.length;

        if (rotations < 0) {
            rotations = -rotations;
            originalIndex = (readIndex + rotations) % n;
        } else {
            if (readIndex - rotations >= 0)
                originalIndex = readIndex - rotations;
            else
                originalIndex = n + (readIndex - rotations);
        }

        return originalIndex;
    }

    private static int getPrintIndex(String query) {
        Matcher matcher = pattern.matcher(query);
        int index = 0;
        while (matcher.find()) {
            index = Integer.valueOf(matcher.group());
        }
        System.out.println("Read Print Index " + index);
        return index;
    }

    private static List<Integer> getUpdateVals(String query) {
        Matcher matcher = pattern.matcher(query);
        List<Integer> nums = new ArrayList<>();
        while (matcher.find()) {
            int val = Integer.valueOf(matcher.group());
            nums.add(val);
        }
        return nums;
    }

    private static int getIncrementnPos(String query) {
        int incr = 0;
        Matcher matcher = pattern.matcher(query);
        while (matcher.find()) {
            incr = Integer.valueOf(matcher.group());
        }
        return incr;
    }


    private static int[] applyRotations(int[] arr, int rotations) {
        if (rotations > 0)
            applyRightRotations(arr, rotations);
        else if (rotations < 0)
            applyLeftRotaions(arr, rotations);
        return arr;
    }

    private static int[] applyLeftRotaions(int[] arr, int rotations) {
        int[] newArr = new int[arr.length * 2];

        int i;
        for (i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        int j = i;

        for (i = 0; i < arr.length; i++) {
            newArr[j++] = arr[i];
        }

        int startIndex = rotations % arr.length;
        int[] rotatedArr = new int[arr.length];

        for (int k = 0; k < rotatedArr.length; k++) {
            rotatedArr[k] = newArr[startIndex++];
        }

        return rotatedArr;
    }

    private static int[] applyRightRotations(int[] arr, int rotations) {
        int[] newArr = new int[arr.length * 2];

        int i;
        for (i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        int j = i;

        for (i = 0; i < arr.length; i++) {
            newArr[j++] = arr[i];
        }

        int startIndex = arr.length - (rotations % arr.length);
        int[] rotatedArr = new int[arr.length];

        for (int k = 0; k < rotatedArr.length; k++) {
            rotatedArr[k] = newArr[startIndex++];
        }

        return rotatedArr;
    }
}
