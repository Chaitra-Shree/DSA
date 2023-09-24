package Searching;

/*
Index of first Occurrence in Sorted

Iterative : https://ide.geeksforgeeks.org/cx1jW3Apo9
TC: O(log n)
SC: O(1)
 */
public class IndexOfFirstOccurrence {

    public static int getFirstIndex(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n-1, mid;
        while(low <= high) {
            mid = (low+high)/2;
            if (arr[mid] < x)
                low = mid+1;
            else if (arr[mid] > x)
                high = mid-1;
            else {
                if (mid == 0 || arr[mid-1] != arr[mid])
                    return mid;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 10, 10, 10, 20, 20, 40};
        int target = 20;
        System.out.println("Index of first occurrence of target " + getFirstIndex(arr, target));
    }

}
