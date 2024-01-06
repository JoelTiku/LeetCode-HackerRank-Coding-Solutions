/*
Given an integer array nums of length n, 
you want to create an array ans of length 2n 
where ans[i] == nums[i] and ans[i + n] == nums[i] 

for 0 <= i < n (0-indexed).

Specifically, ans is the concatenation of two nums arrays.

Return the array ans.

 

Example 1:

Input: nums = [1,2,1]
Output: [1,2,1,1,2,1]
Explanation: The array ans is formed as follows:
- ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
- ans = [1,2,1,1,2,1]

Example 2:

Input: nums = [1,3,2,1]
Output: [1,3,2,1,1,3,2,1]

Explanation: The array ans is formed as follows:
- ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
- ans = [1,3,2,1,1,3,2,1]


*/

import java.util.Arrays;

class concatenationOfArray{
    public static int[] getConcatenation1(int[] nums){

        int ans[] = new int[nums.length*2];
        
        for(int i = 0; i < nums.length; i++){
            ans[i] = nums[i];
            ans[nums.length + i] = nums[i];
        }

        return ans;
        
    }

    public static int[] getConcatenation2(int[] nums){

        int ans[] = new int[nums.length*2];
        
        for(int i = 0; i < ans.length; i++){
            if(i < nums.length){
                ans[i] = nums[i];
            }else{
                ans[i] = nums[i - nums.length];
            }
        }

        return ans;
        
    }

    /*
    0 % 4 = 1
    1 % 4 = 1
    2 % 4 = 2
    3 % 4 = 3
    4 % 4 = 0
    5 % 4 = 1
    6 % 4 = 2
    7 % 4 = 3
    8 % 4 = 0
    */

    public static int[] getConcatenation3(int[] nums){

        int ans[] = new int[nums.length*2];

        for(int i = 0; i < ans.length; i++){
            ans[i] = nums[i % nums.length];
        }

        return ans;
    }
    
    public static void main(String args[]){
        int nums1[] = {1, 2, 1};
        // output: [1, 2, 1, 1, 2, 1]
        System.out.println(Arrays.toString(getConcatenation1(nums1)));
        
        int nums2[] = {1, 3, 2, 1};
        // output: [1, 3, 2, 1, 1, 3, 2, 1]
        System.out.println(Arrays.toString(getConcatenation1(nums2)));
        
        int nums3[] = {1, 2};
        // output: [1, 2, 1, 2]
        System.out.println(Arrays.toString(getConcatenation1(nums3)));
    }
}