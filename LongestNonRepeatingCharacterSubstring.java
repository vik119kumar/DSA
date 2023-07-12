import java.util.*;
public class Find {
    /**
    sliding window approach
    add character by character to current window till we found repeating char
    reduce current window start Index with max of last occurrence of this character or startof current window
    */
    public static String longestNonRepeatingCharacterSubstring(String str)
    {
        //store last position of occurrence
        Map<Character, Integer> lastIndex = new HashMap<>();
 
        // Result
        int maxSubStringLength = -1, maxSubStringStartIndex = 0;
        // store intermediate/new window start index 
        int subStringStartIndex = 0;
        
        for (int index = 0; index < str.length(); index++) {
            Character currChar = str.charAt(index);
            if (lastIndex.containsKey(currChar)) {
                subStringStartIndex = Math.max(subStringStartIndex, lastIndex.get(currChar) + 1);
            }
            lastIndex.put(currChar, index);

            if (index - subStringStartIndex + 1 > maxSubStringLength) {
                maxSubStringLength = index - subStringStartIndex + 1;
                maxSubStringStartIndex = subStringStartIndex;
            }
        }
        
        // return substring from startIndex till length
        return str.substring(maxSubStringStartIndex, maxSubStringStartIndex+maxSubStringLength);
    }
 
    public static void main(String[] args)
    {
        String str = "abcabcbb";
        System.out.println("Input string: " + str);
 
        String len = longestNonRepeatingCharacterSubstring(str);
        System.out.println("longest non-repeating character substring: " + len);
    }
}
