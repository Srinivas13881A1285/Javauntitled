/**
 * @author Srinivas_Chintakindhi
 */

public class RotatedIndex {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,1,2,3};
        int originalIndex = getOriginalIndex(arr, -3, 4);
        System.out.println("originalIndex = " + originalIndex);
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
}
