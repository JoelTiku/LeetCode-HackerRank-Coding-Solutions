/*
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index

For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, 


return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1
*/

public class SearchingRotatedSortedArray {

    /*
     * There are three cases where the target value will lie.
     * CASE : 1 where target will be in right half and mid will be in left half.
     * CASE : 2 where target will be in left half and mid will be in right half.
     * CASE : 3 where target and mid both will be in same half.
     * 
     * TIME COMPLEXITY : O(log n)
     * SPACE COMPLEXITY : O(1)
     */

    public static int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            // Case : 1 nums = [4,5,6,7,0,1,2], target = 0 (0 < 2 && 7 > 2 then target is on
            // right half)
            if (target <= nums[right] && nums[mid] > nums[right]) {
                left = mid + 1;
            }

            // Case : 2 nums = [4,5,0,1,2,3], target = 5 (5 > 3 && 0 < 3 then target is on
            // left half)
            else if (target > nums[right] && nums[mid] < nums[right]) {
                right = mid - 1;
            }
            
            // Case : 3
            else {
                if (nums[mid] == target) {
                    return mid;
                } else if (target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }

        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        return searchRotate(nums, target, 0, nums.length - 1);
    }

    public int searchRotate(int[] nums, int target, int left, int right) {

        // exceptional case: array has only one element
        if (left == right && nums[left] != target)
            return -1;

        // check if the array is sorted, if sorted, using search sorted search
        if (nums[left] <= nums[right]) {
            return searchSorted(nums, target, left, right);
        }

        // if not sorted, divide the array by half, one part must be sorted
        // if target within the sorted half, search using the sorted search
        // if target not in the rotated half, call self recursively until the target
        // fall in the sorted half
        int mid = (left + right) / 2;
        if (nums[left] <= nums[mid]) {// front part is sorted
            if (nums[left] <= target && target <= nums[mid]) {
                return searchSorted(nums, target, left, mid);
            } else {
                return searchRotate(nums, target, mid + 1, right);
            }
        } else {
            if (nums[mid] <= target && target <= nums[right]) {// back part is sorted
                return searchSorted(nums, target, mid, right);
            } else {
                return searchRotate(nums, target, left, mid - 1);
            }
        }

    }

    // search a sorted array by sliding window
    public int searchSorted(int[] nums, int target, int left, int right) {
        while (left < right) {

            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                left = mid + 1;
            if (nums[mid] > target)
                right = mid - 1;
        }
        if (left == right && nums[left] == target)
            return left;
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = { 4, 5, 6, 7, 0, 1, 2 };
        int target1 = 0;
        System.out.println("nums = [4,5,6,7,0,1,2] and target = 0 then output = " + search1(arr1, target1));

        int[] arr2 = { 4, 5, 6, 7, 0, 1, 2 };
        int target2 = 3;
        System.out.println("nums = [4,5,6,7,0,1,2] and target = 3 then output = " + search1(arr2, target2));

        SearchingRotatedSortedArray find = new SearchingRotatedSortedArray();
        int[] arr3 = { 4, 5, 0, 1, 2, 3 };
        int target3 = 5;
        System.out.println("nums = [4,5,0,1,2,3] and target = 5 then output = " + find.search2(arr3, target3));
    }
}
