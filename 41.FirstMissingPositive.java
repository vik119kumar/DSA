class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i+1;
            }
        }
        // if array has all elements from 1 to n then return n+1
        return n+1;
    }
}

/*
Put each number at it's correct position, i.e: a[a[i]-1] = a[i]
1 at a[0], 2 at a[1]...
Time complexity: O(n) + O(n) = O(n)
Space complexity: O(1)
*/
