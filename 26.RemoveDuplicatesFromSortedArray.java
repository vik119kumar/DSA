public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int size = nums.length;
        int uniqueElementIndex = 0;
        for (int i = 0; i< size-1; i++) {
            if (nums[i] != nums[i+1]) {
                nums[uniqueElementIndex++] = nums[i];
            }
        }
        nums[uniqueElementIndex++] = nums[size-1];
        return uniqueElementIndex;
    }
}

/*
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]

As array is sorted we can compare current element with the next then copy it only if both are not equal
Time Complexity: O(N) N is length of array
Space Complexity:O(1)
*/
