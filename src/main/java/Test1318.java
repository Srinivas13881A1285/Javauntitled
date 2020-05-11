import java.util.Scanner;

/**
 * @author Srinivas_Chintakindhi
 */

public class Test1318 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] queries = new String[10];

        for (int i = 0; i < queries.length; i++) {
            queries[i] = scanner.nextLine();
        }

        boolean isRotate = false;

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            //rot

            if(query.startsWith("Left") || query.startsWith("Right")){
                isRotate = true;
            }else{
                isRotate = false;
            }



        }

    }
}
