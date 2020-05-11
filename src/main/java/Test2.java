public class Test2 {
    public static void main(String[] args) {
        System.out.println(atoi("-124"));
    }

    public static int atoi(String str){
        char flag = '+';

        int i = 0;

        if(str.charAt(i)=='-'){
            flag = '-';
            i++;
        }else if(str.charAt(i)=='+'){
            flag = '+';
            i++;
        }

        int result = 0;
        while(i < str.length() && (str.charAt(i) >='0' && str.charAt(i)<='9')){
            result = result * 10 +str.charAt(i) - '0';
            i++;
        }

        return (flag == '-')?-result:result;
    }
}
