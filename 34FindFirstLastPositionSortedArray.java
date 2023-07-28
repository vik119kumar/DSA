class FindFirstLastPositionSortedArray {
    public int findFirstIndex(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low)/2;
        if((mid == 0 || nums[mid- 1] < target) && nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target) {
            return findFirstIndex(nums, mid + 1, high, target);
        }
        return findFirstIndex(nums, low, mid - 1, target);
    }

    public int findLastIndex(int[] nums, int low, int high, int target, int n) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low)/2;
        if((mid == n-1 || target < nums[mid + 1]) && nums[mid] == target) {
            return mid;
        }
        if (target < nums[mid]) {
            return findLastIndex(nums, low, mid - 1, target, n);
        }
        return findLastIndex(nums, mid + 1, high, target, n);
    }

    public int[] searchRange(int[] nums, int target) {
        int firstIndex  = findFirstIndex(nums, 0 , nums.length-1 , target);
        int lastIndex  = findLastIndex(nums, 0 , nums.length-1 , target, nums.length);
        return new int[]{firstIndex, lastIndex};
    }
}
/*
Input: nums = [5,7,7,8,8,10], target = 5, 6, 8, 10, 12 
Output: [0,0], [-1,-1], [3,4], [5,5], [-1,-1] 

Input: nums = [], target = 0
Output: [-1,-1]

Time Complexity: O(log n) 
Space: O(log n), for recursion call stack
*/
