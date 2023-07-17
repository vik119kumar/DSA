import java.util.*;

public class LongestPalindromeSubstring {
    private static int startIndex = 0, subStringLength = 1;
    
    public static void main(String[] args) {
        String input = "babad";
        System.out.println("LongestPlaindromeSubstring:\n" + "input: " + input + "\noutput: " + longestPlaindromeSubstring(input));
    }
    
    // expand from center
    static String longestPlaindromeSubstring(String str) {
        int n = str.length();
        int low, high;
        for (int i = 0; i < n; i++) {
            //find even length substring
            low = i - 1;
            high = i;
            findPalindromeSubString(str, low, high, n);
            
            //find odd length substring
            low = i - 1;
            high = i + 1;
            findPalindromeSubString(str, low, high, n);
        }
        return str.substring(startIndex, startIndex + subStringLength);
    }
    
    static void findPalindromeSubString(String str, int low, int high, int n) {
        while ( low >= 0 && high < n && str.charAt(low) == str.charAt(high)) {
            int currSubStringLength = high - low + 1;
            if (currSubStringLength > subStringLength) {
                startIndex = low;
                subStringLength = currSubStringLength;
            }
            low--;
            high++;
        }
    }
}
/**
Time complexity: O(N^2), where N is the length of the input string
Auxiliary Space: O(1)
*/
