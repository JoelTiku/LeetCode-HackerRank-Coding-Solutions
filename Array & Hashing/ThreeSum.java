/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:
Input: nums = []
Output: []

Example 3:
Input: nums = [0]
Output: []
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum1(int[] nums) {

        Arrays.sort(nums);

        // create a list containing integer arrays like [[-1,-1,2],[-1,0,1]]
        ArrayList<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int j = i + 1;
            int k = nums.length - 1;

            // to eliminate sets containing duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (j < k) {

                // to eliminate sets containing duplicate triplets
                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }

                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    ArrayList<Integer> list = new ArrayList<>();

                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);

                    res.add(list);
                    j++;
                    k--;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {

        ThreeSum threeSum = new ThreeSum();

        int[] nums1 = { -1, 0, 1, 2, -1, -4 };
        System.out.println("Input: nums = " + nums1 + " and Output: " + threeSum.threeSum1(nums1));

        int[] nums2 = { -2, 0, 0, 2, 2 };
        System.out.println("Input: nums = " + nums1 + " and Output: " + threeSum.threeSum1(nums2));

        int[] nums3 = { 0 };
        System.out.println("Input: nums = " + nums1 + " and Output: " + threeSum.threeSum1(nums3));
    }
}
