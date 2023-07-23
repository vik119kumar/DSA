public class RemoveElement {
    private static int removeElement(int arr[], int val) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                arr[count++] = arr[i];
            }
        }
        return count;
    }
    
    public static void main(String []args) {
        int arr1[] = {1,2,3,4};
        System.out.println(removeElement(arr1, 1));
        int arr2[] = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeElement(arr2, 2));
        int arr3[] = {0,0,0,0,0,0,0};
        System.out.println(removeElement(arr3, 0));
    }
}

/**
 * Time Complexity: O(N) N is length of array
 * Space Complexity: O(1)
 */
