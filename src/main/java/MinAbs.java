import java.util.Arrays;

public class MinAbs {
    static int minimumAbsolute(int[] arr){
        Arrays.sort(arr);
        int minVal = Integer.MAX_VALUE;

        for(int i = 1; i < arr.length;i++){
            int diff = arr[i] - arr[i - 1];
            minVal = Math.min(minVal,Math.abs(diff));
        }

        return minVal;
    }

    public static void main(String[] args) {
        int i = minimumAbsolute(new int[]{1,-3,71,68,17});
        System.out.println("i = " + i);
    }
}
