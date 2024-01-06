/*
 Input: nums = [11, 7, 15, 2], target = 9
 Output: [0,1]
 Output: Because nums[1] + nums[3] == 9, we return [1, 3].
 */

import java.util.Map;
import java.util.HashMap;

public class TwoSum {
	
	//Brute Force = Time complexity: O(n^2) and Space complexity: O(1)
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return (new int[] {i, j});
                }
            }
        }
        return null;
    }
    
    //Two-pass Hash Table = Time complexity: O(n) and Space complexity: O(n)
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            //map(key, value)
            map.put(nums[i], i);
        }
        
        
        for(int i = 0; i < nums.length; i++){
            
            int key = target - nums[i];
            if(map.containsKey(key) && map.get(key) != i){
                return (new int[] {i, map.get(key)});
            }
        }
        
        return null;

    }
    
    //One-pass Hash Table = Time complexity: O(1) and Space complexity: O(n)
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            
            int key = target - nums[i];
            if(map.containsKey(key) && map.get(key) != i){
                return (new int[] {i, map.get(key)});
            }
            map.put(nums[i], i);
        }
        
        return null;

    }
    
    public static void main(String[] args) {
    	int[] nums1 = {11, 7, 15, 2};
    	int target1 = 9;

    	TwoSum Sum1 = new TwoSum(); 
    	int [] arr = Sum1.twoSum(nums1, target1);
    	System.out.println("num[" + arr[0] + "] + " + "num[" + arr[1] + "]" + " = " + target1);
    	
    	int[] nums2 = {5, 8, 2, 3};
    	int target2 = 8;
    	
    	TwoSum Sum2 = new TwoSum(); 
    	int [] arr2 = Sum2.twoSum1(nums2, target2);
    	System.out.println("num[" + arr2[0] + "] + " + "num[" + arr2[1] + "]" + " = " + target2);
    	
    	int[] nums3 = {11, 4, 3, 52};
    	int target3 = 7;
    	
    	int [] arr3 = twoSum2(nums3, target3);
    	System.out.println("num[" + arr3[0] + "] + " + "num[" + arr3[1] + "]" + " = " + target3);
    }
}
