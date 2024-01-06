/*
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. 
For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time 
results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.


Algorithm

Find the mid element of the array.

If mid element > first element of array this means that we need to look for the 
inflection point on the right of mid.

If mid element < first element of array this that we need to look for the 
inflection point on the left of mid.


Example 1:
Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.

Example 2:
Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

Example 3:
Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 

In binary search we find out the mid point and decide to either search on the left or right 
depending on some condition.

Since the given array is sorted, we can make use of binary search. However, the array is rotated. 
So simply applying the binary search won't work here.

In this question we would essentially apply a modified version of binary search where the condition 
that decides the search direction would be different than in a standard binary search.
*/
public class FindMinimuminRotatedSortedArray {

	//Time complexity: O(logN) and Space complexity: O(1)
	public static int findMin1(int[] nums) {
		
		int left = 0;
		int right = nums.length - 1;
		int min = Integer.MAX_VALUE;
		
		while(left <= right) {
			
			int mid = (left + right)/2;
			
			if(nums[mid] >= nums[left]) {
				min = Math.min(min, nums[left]);
				left = mid + 1;
			}
			else{
				min = Math.min(min, nums[mid]);
				right = mid - 1;
			}
			
		}
		return min;
	}
	
	//Time complexity: O(logN) and Space complexity: O(1)
	public static int findMin2(int[] nums) {
		
		int left = 0;
		int right = nums.length - 1;
		
		if(nums.length == 1 || nums[right] > nums[left]){
			return nums[left];
		}
		
		while(left <= right) {
			int mid = (left + right)/2;
			
			if(nums[mid] > nums[mid + 1]) {
				return nums[mid + 1];
			}
			
			if(nums[mid - 1] > nums[mid]) {
				return nums[mid];
			}
			
			if(nums[mid] >= nums[left]) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		
		return -1;
	}
	
	public static int findMin3(int[] nums) {
		// If the list has just one element then return that element.
		if (nums.length == 1) {
		  return nums[0];
		}
	
		// initializing left and right pointers.
		int left = 0, right = nums.length - 1;
	
		// if the last element is greater than the first element then there is no rotation.
		// e.g. 1 < 2 < 3 < 4 < 5 < 7. Already sorted array.
		// Hence the smallest element is first element. A[0]
		if (nums[right] > nums[0]) {
		  return nums[0];
		}
		
		// Binary search way
		while (right >= left) {
		  // Find the mid element
		  int mid = left + (right - left) / 2;
	
		  // if the mid element is greater than its next element then mid+1 element is the smallest
		  // This point would be the point of change. From higher to lower value.
		  if (nums[mid] > nums[mid + 1]) {
			return nums[mid + 1];
		  }
	
		  // if the mid element is lesser than its previous element then mid element is the smallest
		  if (nums[mid - 1] > nums[mid]) {
			return nums[mid];
		  }
	
		  // if the mid elements value is greater than the 0th element this means
		  // the least value is still somewhere to the right as we are still dealing with elements
		  // greater than nums[0]
		  if (nums[mid] > nums[0]) {
			left = mid + 1;
		  } else {
			// if nums[0] is greater than the mid value then this means the smallest value is somewhere to
			// the left
			right = mid - 1;
		  }
		}
		return -1;
	  }

	  
	public static void main(String[] args) {
		
		int[] nums1 = {3,4,5,1,2};
		System.out.println(findMin1(nums1));
		
		int[] nums2 = {4,5,6,7,0,1,2};
		System.out.println(findMin1(nums2));
		
		int[] nums3 = {3,1,2};
		System.out.println(findMin2(nums3));
		
		int[] nums4 = {11,13,15,17};
		System.out.println(findMin3(nums4));
		
	}
}
