/*
Binary Search Classic
https://leetcode.com/problems/binary-search/
 */
public class BinarySearch {
    public static int search(int[] nums, int target) {
        int length = nums.length;
        int begin = 0, end = length -1, mid = 0;
        while(begin <= end) {
            mid = (begin+end)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target){
                begin = mid+1;
            }
            else
                end = mid-1;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60};
        int target = 50;
        System.out.println(search(arr, target));
    }
}