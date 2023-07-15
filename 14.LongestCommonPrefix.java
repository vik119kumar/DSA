import java.util.*;
 
public class LongestCommonPrefix
{
    public static String longestCommonPrefix(List<String> arr)
    {
       int n = arr.size();
       //assign first element as prefix
       String result = arr.get(0);
       
       // iterate for rest of element in string.
       for(int i = 1; i < n; i++){
            //reduce calculated prefix till we found prefix in current element
            while(arr.get(i).indexOf(result) != 0){               
                // update matched substring prefx
                result = result.substring(0, result.length()-1);

                // return in case of empty prefix
                if(result.isEmpty()){
                    return "-1";
                }
            }
        }
        return result;
    }
 
    public static void main(String[] args)
    {
        List<List<String>> input = Arrays.asList(
                Arrays.asList("flower", "flow", "flight"),
                Arrays.asList("dog", "racecar", "car")
            );
        for (int i = 0; i < input.size(); i++) {
            System.out.println(input.get(i));
            System.out.println("Longest Common Prefix is : " + longestCommonPrefix(input.get(i)));
        }
    }
}
/*
Time Complexity: O(m * N).  where m is the length of the prefix and n is the number of strings in the input array. 
Space Complexity: O(1)
*/
