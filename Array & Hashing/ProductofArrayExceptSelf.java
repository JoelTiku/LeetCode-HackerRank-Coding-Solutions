
/*
Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
*/
import java.util.Arrays;

public class ProductofArrayExceptSelf {
	
	//Brute Force = Time complexity: O(n^2) and Space complexity: O(1)
	public static int[] productExceptSelf1(int[] nums) {
		int[] prod = new int[nums.length];
		
		for(int i = 0; i < nums.length; i++) {
			prod[i] = 1;
		}
		
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums.length; j++) {
				if(i == j) {
					continue;
				}else {
					prod[i] *= nums[j];
				}	
			}
		}
		return prod;
	}
	
	//Time complexity: O(n) and Space complexity: O(1)
	public static int[] productExceptSelf2(int[] nums) {
		int[] prod = new int[nums.length];
		
		int left = 1;
		for(int i = 0; i < nums.length; i++) {
			prod[i] = left;
			left *= nums[i];
		}
		
		int right = 1;
		for(int i = nums.length - 1; i >= 0; i--) {
			prod[i] *= right;
			right *= nums[i];
		}
		
		return prod;
		
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,4};
		System.out.println(Arrays.toString(productExceptSelf1(nums1)));
		int[] nums2 = {-1,1,0,-3,3};
		System.out.println(Arrays.toString(productExceptSelf2(nums2)));
	}
	
}
