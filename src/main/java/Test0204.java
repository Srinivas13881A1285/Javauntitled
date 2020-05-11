import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author Srinivas_Chintakindhi
 */

public class Test0204 {
    public static void main(String[] args) throws IOException {
        Object[] objects = Files.lines(Paths.get("/home/srinivas/Documents/work/Feeds/.txt")).toArray();
        //System.out.println(Arrays.toString(objects));

        final Pattern pattern = Pattern.compile("<job>(.+?)</job>", Pattern.DOTALL);

        for (Object st : objects) {
            final Matcher matcher = pattern.matcher((CharSequence) st);
            String originalCompanyName = "";
            if(matcher.find())
                originalCompanyName = matcher.group(1);

            String compNameWithNoSplChars = originalCompanyName.replaceAll("[^a-zA-Z0-9 ]", "");

            String[] splitWords = compNameWithNoSplChars.split(" ");
            String refNum = "P_";


            if (splitWords.length > 1) {
                int count = 0;
                for (String s : splitWords) {
                    if (s!=null && !s.equals("")) {
                        refNum += s.substring(0, 2).toUpperCase();
                        count += 1;
                        if (count == 2)
                            break;
                    }
                }
            } else {
                refNum += compNameWithNoSplChars.length() >= 4 ? compNameWithNoSplChars.substring(0, 4).toUpperCase() : compNameWithNoSplChars.toUpperCase();
            }


            refNum = refNum + "_" + originalCompanyName.length();

            System.out.println(originalCompanyName+"   ------------------------>  "+refNum);
        }






    }
}
