public class SearchInsertPosition {
  public int searchInsert(int[] nums, int target) {
    int start = 0,
    end = nums.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (target < nums[mid]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return end + 1;
  }
}

/*
Input: nums = [1,3,5,6], target = 5, 2
target = 5 Output= 2,
target = 2 Output: 1,
target = 0 Output: 0,
target = 7 Output: 4
Time Complexity: O(log N)
Space: O(1)
*/
