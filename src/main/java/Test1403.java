import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Srinivas_Chintakindhi
 */

public class Test1403 {

    static int[] arr;
    public static void main(String[] args) {
//        String s = "Increment 104";
//
//        Pattern pattern = Pattern.compile("\\d+");
//        Matcher matcher = pattern.matcher(s);
//
//        List<Integer> num = new ArrayList<>();
//
//        while (matcher.find()) {
//            String posStr = matcher.group();
//            int pos = Integer.valueOf(posStr);
//            num.add(pos);
//        }
//
//        for (Integer integer : num) {
//            System.out.println("s = " + integer);
//        }

        arr = new int[]{1,2,3,4};
        arr = new Test1403().rotate(arr);
        System.out.println(Arrays.toString(arr));
    }

    private  int[] rotate(int[] arr) {
        int[] newArr = new int[arr.length * 2];

        int i;
        for ( i = 0; i <arr.length; i++) {
            newArr[i] = arr[i];
        }

        int j = i;

        for (i = 0; i < arr.length; i++) {
            newArr[j++] = arr[i];
        }

        System.out.println(Arrays.toString(newArr));

        int rotations = 2;
        int startIndex = arr.length - rotations;
        int[] rotatedArr = new int[arr.length];

        for (int k = 0; k < rotatedArr.length; k++) {
            rotatedArr[k] = newArr[startIndex++];
        }
        arr = rotatedArr;
        System.out.println(Arrays.toString(rotatedArr));
        System.out.println(Arrays.toString(arr));

        return rotatedArr;
    }
}
