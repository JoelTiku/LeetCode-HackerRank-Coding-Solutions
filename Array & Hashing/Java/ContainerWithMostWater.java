/*
You are given an integer array height of length n. 
There are n vertical lines drawn such that the two endpoints 
of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, 
such that the container contains the most water.
Return the maximum amount of water a container can store.

Area = minimum{height 1, height 2} * width

For example if [4,3,2,6] is the given heights array, 
we start by comparing the 0th and 1st index elements, 
i.e.  heights (4,3). So, Area = minimum{4,3}*1 = 3*1 which is equal to 3 
(calculated using the above area formula). Then we check for heights at 0th and 2nd index 
i.e. (4,2) for which Area = minimum{4,2}*2 = 2. 
Similarly we check all the possible combinations (4,6), (3,2), (3,6), (2,6) and 
finally return the maximum area obtained out of all the combinations as the result.

minimum{4,3}*1 = 3     minimum{3,2}*1 = 2     minimum{2,6}*1 = 2
minimum{4,2}*2 = 4     minimum{3,6}*2 = 6
minimum{4,6}*3 = 12

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49

Example 2:
Input: height = [1,1]
Output: 1

Example 3:
Input: height = [4,3,2,1,4]
Output: 16

Example 4:
Input: height = [1,2,1]
Output: 2
 */

 import java.util.Arrays;

public class ContainerWithMostWater {
    // Brute Force - Time complexity: O(n^2) and Space complexity: O(1)
    public int maxArea1(int[] height) {

        int maxarea = 0;

        for (int left = 0; left < height.length; left++) {
            for (int right = left + 1; right < height.length; right++) {
                int width = right - left;
                maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * width);
            }
        }
        return maxarea;
    }

    public int maxArea2(int[] height) {
        // Two Pointer Approach - Time complexity: O(n) and Space complexity: O(1)
        int maxarea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int width = right - left;
            maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * width);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxarea;
    }

    public static void main(String[] args){

        ContainerWithMostWater cmax = new ContainerWithMostWater();

        int[] height1 = {1,8,6,2,5,4,8,3,7};
        System.out.println("Input: height = " + Arrays.toString(height1) + " and Output: " + cmax.maxArea1(height1));

        int[] height2 = {4,3,2,6};
        System.out.println("Input: height = " + Arrays.toString(height2) + " and Output: " + cmax.maxArea1(height2));

        int[] height3 = {4,3,2,1,4};
        System.out.println("Input: height = " + Arrays.toString(height3) + " and Output: " + cmax.maxArea1(height3));

        int[] height4 = {1,2,1};
        System.out.println("Input: height = " + Arrays.toString(height4) + " and Output: " + cmax.maxArea1(height4));
    }
}
