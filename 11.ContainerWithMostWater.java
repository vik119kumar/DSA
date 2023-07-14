import java.util.*;
public class ContainerWithMostWater {
    public static int mostWaterContainer(List<Integer> arr) {
        int size = arr.size();
        int leftIdx = 0;
        int rightIdx = size -1;
        int area = 0;
        while (leftIdx < rightIdx)
        {
            int currArea = Math.min(arr.get(leftIdx), arr.get(rightIdx)) * (rightIdx - leftIdx);
            area = Math.max(area, currArea);
            if (arr.get(leftIdx) < arr.get(rightIdx)) {
                leftIdx += 1;
            }
            else {
                rightIdx -= 1;
            }
        }
        return area;
    }
    public static void main(String[] args)
    {
        List<List<Integer>> inputList = Arrays.asList(
                Arrays.asList(1, 5, 4, 3),
                Arrays.asList(3, 1, 2, 4, 5),
                Arrays.asList(1, 8, 6, 2, 5, 4, 8, 3, 7)
            );
        for (int i = 0; i < inputList.size(); i++) {
            List<Integer> input = inputList.get(i);
            System.out.println(input + " mostWater: " + mostWaterContainer(input));
        }
    }
}
