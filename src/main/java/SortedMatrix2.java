/**
 * @author Srinivas_Chintakindhi
 */

public class SortedMatrix2 {
    public int numberOfElementsLessthanGivenValue(int[][] mat, int val) {
        int totalRows = mat.length;
        int totalCols = mat[0].length;
        int row = 0;
        int col = totalCols - 1;

        int count = 0;

        while (row < totalRows && col >= 0) {
            if (mat[row][col] <= val) {
                row++;
                count = count + col + 1;
            } else
                col--;
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {2, 7, 5},
                {4, 9, 19},
                {6, 10, 24}
        };
        int count = new SortedMatrix2().numberOfElementsLessthanGivenValue(mat, 24);
        System.out.println("count = " + count);
    }
}
