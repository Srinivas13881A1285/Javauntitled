/**
 * @author Srinivas_Chintakindhi
 */

public class Test3103 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {


            int a = i;
            int result = a & 1;
            if(result == 1) {
                System.out.println(a+" is odd");
            } else
                System.out.println(a+" is even");
        }

        countsetBits(13);
        countSetBitsFast(13);
    }

    public static int countsetBits(int n){
        int count = 0;
        while(n > 0){
            count += (n & 1);
            n = n >> 1;
        }
        System.out.println("no of set bits are "+count);
        return count;
    }

    public static int countSetBitsFast(int n){
        int count = 0;
        while(n !=0){
            count++;
            n = n & (n - 1);
        }
        System.out.println("no of set bits fast "+count);
        return count;
    }

}
