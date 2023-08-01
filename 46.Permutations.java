import java.util. * ;
class Solution {
  private void swap(List < Integer > nums, int firstPos, int secondPos) {
    int tmp = nums.get(firstPos);
    nums.set(firstPos, nums.get(secondPos));
    nums.set(secondPos, tmp);
  }
  private void permute(List < Integer > nums, int l, int r, List < List < Integer >> result) {
    if (l == r) {
      result.add(new ArrayList < >(nums));
    } else {
      for (int i = l; i <= r; i++) {
        swap(nums, l, i);
        permute(nums, l + 1, r, result);
        swap(nums, l, i);
      }
    }
  }
  public List < List < Integer >> permute(int[] nums) {
    List < Integer > list = Arrays.stream(nums).boxed().collect(Collectors.toList());
    List < List < Integer >> result = new ArrayList < >();
    permute(list, 0, nums.length - 1, result);
    return result;
  }
}

/*
Time Complexity: O(N * N!) there are N! permutations and it requires O(N) time to print a permutation.
Auxiliary Space: O(N) space required to store intermediate result.
*/
