public class RemoveDuplicates {
    private static int removeDuplicates(int arr[]) {
        if (arr.length == 0) {
            return 0;
        }
        int size = arr.length;
        int uniqueElementIndex = 0;
        for (int i = 0; i< size-1; i++) {
            if (arr[i] != arr[i+1]) {
                arr[uniqueElementIndex++] = arr[i];
            }
        }
        arr[uniqueElementIndex++] = arr[size-1];
        return uniqueElementIndex;
    }
    
    public static void main(String []args) {
        int arr1[] = {1,2,3,4};
        System.out.println(removeDuplicates(arr1));
        int arr2[] = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(arr2));
        int arr3[] = {0,0,0,0,0,0,0};
        System.out.println(removeDuplicates(arr3));
    }
}

/**
As array is sorted we can compare current element with the next then copy it only if both are not equal
Time Complexity: O(N) N is length of array
Space Complexity:O(1)
*/
