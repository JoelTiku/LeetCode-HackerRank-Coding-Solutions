import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given an integer array nums, return true if any value appears at least twice in the array, 
and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 */
public class containsDuplicate {
	
	//Brute Force = Time complexity: O(n^2) and Space complexity: O(1)
	public static boolean duplicate1(int[] nums) {
		
		for(int i = 0; i < nums.length - 1; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				
				if(nums[i] == nums[j]) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	//Time complexity: O(nlogn) and Space complexity: O(1)
	public static boolean duplicate2(int[] nums) {
		
		Arrays.sort(nums);
		
		for(int i = 0; i < nums.length - 1; i++) {
			if(nums[i] == nums[i + 1]) {
				return true;
			}
		}
		return false;
	}
	
	
	//Time complexity: O(n) and Space complexity: O(1)
	public static boolean duplicate3(int[] nums) {
		
		Set<Integer> set = new HashSet<>();
		
		for(int i = 0; i < nums.length; i++) {
			if(set.contains(nums[i])) {
				return true;
			}
			set.add(nums[i]);
		}
		
		return false;
	}
	
	
	//Time complexity: O(n) and Space complexity: O(1)
		public static boolean duplicate4(int[] nums) {
			
			Map<Integer, Boolean> map = new HashMap<>();
			
			for(int i = 0; i < nums.length; i++) {
				if(map.containsKey(nums[i])) {
					return true;
				}
				map.put(nums[i], true);
			}
			
			return false;
		}
		
		
	public static void main(String[] args) {
			int[] nums1 = {1,2,3,1}; //Output: true
			System.out.println("Array {1,2,3,1} is duplicate = " + duplicate1(nums1));

			int[] nums2 = {1,2,3,4}; //Output: false
			System.out.println("Array {1,2,3,4} is duplicate = " + duplicate2(nums2));
			
			int[] nums3 = {1,1,1,3,3,4,3,2,4,2}; //Output: true
			System.out.println("Array {1,1,1,3,3,4,3,2,4,2} is duplicate = " + duplicate3(nums3));
			System.out.println("Array {1,1,1,3,3,4,3,2,4,2} is duplicate = " + duplicate4(nums3));
	}
}
