/*
Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Example 2:
Input: nums = [1]
Output: 1

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
 
*/
public class MaximumSubarray {

	//Time complexity: O(n) and Space complexity: O(1)
	public static int maxSubArray1(int[] nums) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			max = Math.max(max, sum);
			sum = Math.max(sum, 0);
		}
		
		return max;
	}
	
	//Time complexity: O(n) and Space complexity: O(1)
	public static int maxSubArray2(int[] nums) {
		
		int max = nums[0];
        int res = nums[0];
       
        for(int i = 1;i < nums.length;i++){
            max = Math.max(max+nums[i], nums[i]);
            if(max > res)
                res = max;

        }
        return res; 
            
    }
	
	public static void main(String[] args) {
		int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray1(nums1));
		
		int[] nums2 = {5,4,-1,7,8};
		System.out.println(maxSubArray2(nums2));
	}
}
