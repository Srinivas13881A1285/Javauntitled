public class MinimumNumber {
    public static void main(String[] args) {
        System.out.println(minimumNumber(11,"#HackerRank"));
    }

    static int minimumNumber(int n, String password) {
        int digits = 0;
        int upperCase = 0;
        int lowerCase = 0;
        int specialChar = 0;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c))
                digits += 1;
            else if (Character.isUpperCase(c))
                upperCase += 1;
            else if (Character.isLowerCase(c))
                lowerCase += 1;
            else
                specialChar += 1;
        }


        int numOfCharsToAdd = 0;

        if (digits == 0)
            numOfCharsToAdd += 1;

        if (upperCase == 0)
            numOfCharsToAdd += 1;

        if (lowerCase == 0)
            numOfCharsToAdd += 1;

         if (specialChar == 0)
            numOfCharsToAdd += 1;

        if(password.length()+numOfCharsToAdd < 6)
            numOfCharsToAdd += 6 - (password.length() + numOfCharsToAdd);

        return numOfCharsToAdd;

    }
}
