/**
 * @author Srinivas_Chintakindhi
 */

public class Test0304 {
    public static void main(String[] args) {
        String originalCompanyName = "B. Braun Medical Inc.";

        String compNameWithNoSplChars = originalCompanyName.replaceAll("[^a-zA-Z0-9 ]", "");

        String[] splitWords = compNameWithNoSplChars.split(" ");
        String refNum = "P_";

        if (splitWords.length > 1) {
            int count = 0;
            for (String s : splitWords) {
                if (s!=null && !s.equals("")) {
                    refNum += s.length() >=2 ? s.substring(0, 2).toUpperCase() : s.toUpperCase();
                    count += 1;
                    if (count == 2)
                        break;
                }
            }
        } else
            refNum += compNameWithNoSplChars.length() >= 4 ? compNameWithNoSplChars.substring(0, 4).toUpperCase() : compNameWithNoSplChars.toUpperCase();

        refNum = refNum+"_"+originalCompanyName.length();
        System.out.println("refNum = " + refNum);

    }
}
