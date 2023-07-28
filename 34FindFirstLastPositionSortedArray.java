public class FindFirstLastPositionSortedArray {
  public int findFirstIndex(int[] nums, int low, int high, int target) {
    if (low > high) {
      return - 1;
    }
    int mid = low + (high - low) / 2;
    if ((mid == 0 || nums[mid - 1] < target) && nums[mid] == target) {
      return mid;
    }
    if (nums[mid] < target) {
      return findFirstIndex(nums, mid + 1, high, target);
    }
    return findFirstIndex(nums, low, mid - 1, target);
  }

  public int findLastIndex(int[] nums, int low, int high, int target, int n) {
    if (low > high) {
      return - 1;
    }
    int mid = low + (high - low) / 2;
    if ((mid == n - 1 || target < nums[mid + 1]) && nums[mid] == target) {
      return mid;
    }
    if (target < nums[mid]) {
      return findLastIndex(nums, low, mid - 1, target, n);
    }
    return findLastIndex(nums, mid + 1, high, target, n);
  }

  public int[] searchRange(int[] nums, int target) {
    int firstIndex = findFirstIndex(nums, 0, nums.length - 1, target);
    int lastIndex = findLastIndex(nums, 0, nums.length - 1, target, nums.length);

    return new int[] {
      firstIndex,
      lastIndex
    };
  }
}
/*
Input: nums = [5,7,7,8,8,10]
target = 5 Output: [0,0]
target = 6 Output: [-1,-1]
target = 8 Output: [3,4]
target = 10 Output: [5,5]
target = 12 Output: [-1,-1]

Input: nums = [], target = 0
Output: [-1,-1]

Time Complexity: O(log n)
Space: O(log n), for recursion call stack
*/
