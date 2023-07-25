public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        //assign first element as prefix
        String result = strs[0];
        
        // iterate for rest of element in string.
        for(int i = 1; i < n; i++){
            //reduce calculated prefix till we found prefix in current element
            while(strs[i].indexOf(result) != 0){               
                // update matched substring prefx
                result = result.substring(0, result.length()-1);

                // return in case of empty prefix
                if(result.isEmpty()){
                    return "";
                }
            }
        }
        return result;
    }
}
/*
Example 1
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2
Input: strs = ["dog","racecar","car"]
Output: ""

Time Complexity: O(m * n).  where m is the length of the prefix and n is the number of strings in the input array. 
Space Complexity: O(1)
*/
