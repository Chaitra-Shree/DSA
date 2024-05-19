package Recursion;

/**
 *  https://leetcode.com/problems/permutations/
 *  https://www.youtube.com/watch?v=YK78FU5Ffjw
 *  https://www.youtube.com/watch?v=f2ic2Rsc9pU&t=879s
 *
 *  Brute force : TC: O(n! * n) ; SC: O(n) -> for the recursive call, O(n) for ds and O(n) for ans and o(n) for visited.
 *  Optimal : TC: O(n! * n) ; SC: O(n) for recursive call and o(n!) to store the answer, other than that , there is no extra space.
 */

import java.util.ArrayList;
import java.util.List;

public class Permutation{

    // Brute Force

    public ArrayList<ArrayList<Integer>> permuteBruteForce(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        ArrayList<Integer> ds = new ArrayList<>(n);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        recurrPermuteBruteForce(nums, ds, visited, ans);
        return ans;
    }

    public void recurrPermuteBruteForce(int[] nums, ArrayList<Integer> ds, boolean[] visited, ArrayList<ArrayList<Integer>> ans) {
        int n = nums.length;
        if(ds.size() == n) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = 0 ; i < n ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                ds.add(nums[i]);
                recurrPermuteBruteForce(nums, ds, visited, ans);
                ds.remove(ds.size() - 1);
                visited[i] = false;
            }
        }
    }


    // Optimal

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recurrPermute(0, nums, ans);
        return ans;
    }

    public void recurrPermute(int index, int[] nums, List<List<Integer>> ans) {
        int n = nums.length;
        List<Integer> ds = new ArrayList<>();
        if(index == n) {
            for(int i = 0 ; i < n ; i++) {
                ds.add(nums[i]);
            }

            ans.add(new ArrayList<>(ds));
        }

        for(int i = index ; i < n ; i++ ) {
            swap(i, index, nums);
            recurrPermute(index+1, nums, ans);
            swap(index, i, nums);
        }
    }

    public void swap(int a , int b , int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Permutation p = new Permutation();
        ArrayList<ArrayList<Integer>> ans = p.permuteBruteForce(nums);
        for(ArrayList<Integer> al : ans) {
            System.out.println(al);
        }

        List<List<Integer>> ans2 = p.permute(nums);
        for(List<Integer> al : ans2) {
            System.out.println(al);
        }
    }

}

