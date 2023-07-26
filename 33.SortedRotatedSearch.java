public class SortedRotatedSearch {
    private static int sortedRotatedSearch(int arr[], int left, int right, int val) {
        if (left > right) {
            return -1;
        }
        
        int mid = left + (right - left)/2;
        if (arr[mid] == val) {
            return mid;
        }
        
        /**
         left or right side must be ordered normally, find that side and use it figure out which side to search to find x
         */
        if (arr[left] < arr[mid]) {
            //Left is normally ordered
            if (arr[left] <= val && val <= arr[mid]) {
                return sortedRotatedSearch(arr, left, mid - 1, val);
            }
            return sortedRotatedSearch(arr, mid + 1, right, val);
        }
        
        if (arr[mid] < arr[right]) {
            //Right is normally ordered
            if (arr[mid] <= val && val <= arr[right]) {
                return sortedRotatedSearch(arr, mid + 1, right, val);
            }
            return sortedRotatedSearch(arr, left, mid - 1, val);
        }
        if (arr[left] == arr[mid]) {//Left half has all repeats
            if (arr[mid] != arr[right]) {//If right is different, search it
                return sortedRotatedSearch(arr, mid+ 1, right, val); // search right
            }
            //search both halves
            int result= sortedRotatedSearch(arr, left, mid - 1, val); // Search left
            if (result == -1) {
                return sortedRotatedSearch(arr, mid+ 1, right, val); // Search right
            }
            return result;
        }
        return -1;
    }

    public static void main(String []args) {
        int arr1[] = { 10, 15, 20, 0, 5};
        int left = 0;
        System.out.println(sortedRotatedSearch(arr1, 0, arr1.length-1, 0));
        int arr2[] = { 4,5,6,7,0,1,2};
        System.out.println(sortedRotatedSearch(arr2, 0, arr2.length-1, 2));
        int arr3[] = { 3, 3, 0, 1, 2, 3 };
        System.out.println(sortedRotatedSearch(arr3, 0, arr3.length-1, 3));
        System.out.println(sortedRotatedSearch(arr3, 0, arr3.length-1, 31));
    }
}

/**
 * Time Complexity: O(log N), N is size of array.
 * Space: O(logN) (recursive stack space).
 */
