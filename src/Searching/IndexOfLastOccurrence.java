package Searching;

/*
Index of Last Occurrence in Sorted

Iterative : https://ide.geeksforgeeks.org/online-java-compiler/524dd155-e204-4b63-a0f6-2f925edffeed
TC: O(log n)
SC: O(1)
 */
public class IndexOfLastOccurrence {

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
                if(mid == high || arr[mid] != arr[mid+1])
                    return mid;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 10, 10, 10, 20, 20, 40};
        int target = 20;
        System.out.println("Index of last occurrence of target " + getFirstIndex(arr, target));
    }

}
