import java.util.*;
public class ATOI {
    public static int atoi(String str) {
        // if string is invalid return 0
        if (str == null) {
            return 0;
        }
        str = str.trim(); // remove whitespace
        if (str.length() < 1) {
            return 0;
        }
        double result = 0;
        // sign = 1 for +ve and -1 for -ve
        int sign = 1, index = 0;
        if (str.charAt(index) == '-') {
            sign = -1;
        } else if (str.charAt(index) == '+') {
            // if +ve sign do nothing
        }
        index++;
        while (index < str.length()) {
            char currChar = str.charAt(index);
            if (!(currChar >= '0' && currChar <= '9')) {
                return 0;
            }
            result = result * 10 + (currChar - '0');
            index++;
        }
        
        result = result * sign;
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }
    
    public static void main(String[] args)
    {
        String input[] = new String[]{null, "", " ", "-123", " +234", "12345678901234567", "-1234567890098765432"};
        for (int i = 0; i < input.length; i++) {
            System.out.println("ATOI:(\"" + input[i] + "\") = " + atoi(input[i]));
        }
    }
}
