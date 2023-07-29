public class ContainerWithMostWater {
  public int maxArea(int[] height) {
    int size = height.length;
    int leftIdx = 0;
    int rightIdx = size - 1;
    int area = 0;
    while (leftIdx < rightIdx) {
      int currArea = Math.min(height[leftIdx], height[rightIdx]) * (rightIdx - leftIdx);
      area = Math.max(area, currArea);
      if (height[leftIdx] < height[rightIdx]) {
        leftIdx += 1;
      }
      else {
        rightIdx -= 1;
      }
    }
    return area;
  }
}

/*
Input: height = [1,8,6,2,5,4,8,3,7] Output: 49
Input: height = [1,1] Output: 1

Time Complexity: O(N) N is number of elements in Array
Space Complexity: O(1)
*/
