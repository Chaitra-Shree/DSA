package ArraysAndHashing;

public class NextPermutation {

    /**
     * Brute force:
     * 1. Calculate all the permutations in a sorted manner
     * 2. Perform a linear search
     * 3. Print the next element if it is not the last element, else print the first element
     *
     * This would be in exponential time
     *
     *   Video sol: https://www.youtube.com/watch?v=JDOXKqF60RQ
     *
     * Optimal approach: Coded below:
     *    TC: O(3N)
     *    SC: O(1) No extra space taken
     */

    public void nextPermute(int[] nums) {
        int n = nums.length;
        int index = -1;
        for(int i = n-2 ; i > 0 ; i--) {
            if(nums[i] < nums[i+1]) {
                index = i;
                break;
            }
        }

        if(index == -1) {
            return;
        }

        for(int i = n-1 ; i > index ; i--) {
            if(nums[i] > nums[index]) {
                swap(i, index, nums);
                break;  // v imp.
            }
        }
        reverse(index+1, n-1, nums);
    }


    public void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void reverse(int start, int end, int[] nums) {
        while(start < end) {
            swap(start, end, nums);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 1, 5, 4, 3, 0, 0};
        NextPermutation np = new NextPermutation();
        np.nextPermute(nums);
        for(int num: nums)
            System.out.print(num + " ");
    }
}
