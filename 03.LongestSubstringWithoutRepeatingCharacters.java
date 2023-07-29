import java.util.*;
public class LongestSubstringWithoutRepeatingCharacters {
  /**
    sliding window approach
    add character by character to current window till we found repeating char
    reduce current window start Index with max of last occurrence of this character or startof current window
    */
  public int lengthOfLongestSubstring(String s) {
    //store last position of occurrence
    Map <Character, Integer> lastIndex = new HashMap<>();

    // Result
    int maxSubStringLength = 0,
    maxSubStringStartIndex = 0;
    // store intermediate/new window start index 
    int subStringStartIndex = 0;

    for (int index = 0; index < s.length(); index++) {
      Character currChar = s.charAt(index);
      if (lastIndex.containsKey(currChar)) {
        subStringStartIndex = Math.max(subStringStartIndex, lastIndex.get(currChar) + 1);
      }
      lastIndex.put(currChar, index);

      if (index - subStringStartIndex + 1 > maxSubStringLength) {
        maxSubStringLength = index - subStringStartIndex + 1;
        maxSubStringStartIndex = subStringStartIndex;
      }
    }
    return maxSubStringLength;
    //substring value is from startIndex till length
    //s.substring(maxSubStringStartIndex, maxSubStringStartIndex+maxSubStringLength);
  }
}

/**
Input: s = "abcabcbb" Output: 3, Explanation: The answer is "abc", with the length of 3.
Input: s = "bbbbb" Output: 1, Explanation: The answer is "b", with the length of 1.
Input: s = "pwwkew" Output: 3, Explanation: The answer is "wke", with the length of 3.
Time Complexity: O(N)
Space complexity: O(N + N) (number of unique characters in string + string window without repeating characters)
*/
