import java.util.*;
public class TwoSum {
  public boolean twoSum1(int[] nums, int target) {
    //return true if pair exist else false (it works on sorted array)
    int start = 0,
    end = nums.length - 1;
    Arrays.sort(nums);
    while (start < end) {
      int currSum = nums[start] + nums[end];
      if (currSum == target) {
        return true;
      } else if (currSum < target) {
        start++;
      } else {
        end--;
      }
    }
    return false;
  }
  public int[] twoSum(int[] nums, int target) {
    //return pair index using hashmap if exist else [-1, -1]]
    Map < Integer,
    Integer > map = new HashMap < >();
    int size = nums.length;
    for (int i = 0; i < size; i++) {
      int requiredSum = target - nums[i];
      if (map.containsKey(requiredSum)) {
        return new int[] {
          map.get(requiredSum),
          i
        };
      } else {
        map.put(nums[i], i);
      }
    }
    return new int[] { - 1,
      -1
    };
  }
}

/*
Input: nums = [2,7,11,15], target = 9 Output: [0,1]
Input: nums = [3,2,4], target = 6 Output: [1,2]
Input: nums = [3,3], target = 6 Output: [0,1]

Time Complexity: O(N) N is length of array
Space: O(N), hash map
*/
