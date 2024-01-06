/*
Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 

*/

public class MaximumProductSubarray {

	//Time complexity: O(n) and Space complexity: O(1)
	public static int maxProduct1(int[] nums) {
		int max = nums[0];
		int min = nums[0];
		int res = nums[0];
		
		for(int i = 1; i < nums.length; i++) {
			int temp = max;
			
			max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
			min = Math.min(Math.max(temp * nums[i], min * nums[i]), nums[i]);
			
			if(max > res) {
				res = max;
			}
		}
		return res;
	}
	
	//Time complexity: O(n) and Space complexity: O(1)
	public static int maxProduct2(int[] nums) {
		int max = Integer.MIN_VALUE;
		
		int LeftProd = 1;
		int RightProd = 1;
		
		for(int i = 0; i < nums.length; i++) {
			 LeftProd *= nums[i];
			 RightProd *= nums[nums.length - i - 1];
			 
			 
			 if(max < LeftProd || max < RightProd) {
				 max = Math.max(LeftProd, RightProd);
			 }
			 
			 if(nums[i] == 0) {
				 LeftProd = 1;
			 }
			 
			 if(nums[nums.length - i - 1] == 0) {
				 RightProd = 1;
			 }
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		
		int[] nums1 = {2,3,-2,4};
		int[] nums2 = {-2,0,-1};
		int[] nums3 = {-2,-1,0};

		System.out.println("Output: " + maxProduct1(nums1));
		System.out.println("Output: " + maxProduct1(nums2));
		System.out.println("Output: " + maxProduct1(nums3));
		
		System.out.println("--------------------------------------------");
		
		System.out.println("Output: " + maxProduct2(nums1));
		System.out.println("Output: " + maxProduct2(nums2));
		System.out.println("Output: " + maxProduct2(nums3));
	}
}
