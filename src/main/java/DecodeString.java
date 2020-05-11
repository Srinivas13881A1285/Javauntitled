import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> countsStack = new Stack<>();
        Stack<String> trackCharsStack = new Stack<>();

        int index = 0;
        String trackChars = "";

        while (index < s.length()) {


            if (Character.isDigit(s.charAt(index))) {

                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + s.charAt(index) - '0';
                    index++;
                }

                countsStack.push(count);

            } else if (s.charAt(index) == '[') {

                trackCharsStack.push(trackChars);
                trackChars = "";
                index++;

            } else if (s.charAt(index) == ']') {

                StringBuilder sb = new StringBuilder(trackCharsStack.pop());
                int count = countsStack.pop();

                for (int i = 0; i < count; i++) {
                    sb.append(trackChars);
                }

                trackChars = sb.toString();
                index++;

            } else {
                trackChars += s.charAt(index);
                index++;
            }
        }
        return trackChars;
    }
}
