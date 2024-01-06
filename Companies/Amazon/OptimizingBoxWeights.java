/*
Optimizing Box Weights (example question)

An Amazon Fulfillment Associate has a set of items that need to be packed 
into two boxes. Given an integer array of the item weights (arr) to be packed, 
divide the item weights into two subsets, A and B, 
for packing into the associated boxes, 
while respecting the following conditions:

• The intersection of A and B is null.

• The union A and B is equal to the original array.

• The number of elements in subset A is minimal.

• The sum of A's weights is greater than the sum of B's weights.

Return the subset A in increasing order where the sum of A's 
weights is greater than the sum of B's weights. If more than one subset A 
exists, return the one with the maximal total weight.

Example: n = 5 and arr = [3, 7, 5, 6, 2] 

The 2 subsets in arr that satisfy the conditions for A are [5, 7] and [6, 7].

• A is minimal (size 2)

• Sum(A) = (5+7)=12 > Sum(B) (2+3+6)=11

• Sum(A) = (6+7)=13 > Sum(B) = (2+3+5)=10

• The intersection of A and B is null and their union is equal to arr.

• The subset A where the sum of its weight is maximal is [6, 7].



Example: n = 6 and arr = [4, 5, 2, 3, 1, 2] so A = [4, 5]

Example: n = 5 and arr = {10, 5, 3, 1, 20} so A = [20] because it is minimal (not A = [10, 20])

Example: n = 5 and arr = {1, 2, 3, 5, 8} so A = [5, 8] 

Example: n = 8 and arr = {1, 2, 2, 3, 4, 4, 4, 5} so A = [4, 4, 4, 5]

Example: n = 6 and arr = [1, 2, 2, 2, 3, 4] so A = [2, 2, 2, 3, 4]

Example: n = 4 and arr = [2, 2, 2, 3] so A = [2, 2, 2, 3]

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class OptimizingBoxWeights {
    
    public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
        // Example 1: Given input list arr = [1, 1, 1, 4, 1, 4, 4, 7, 8]
        // Example 2: Given input list arr = [4, 5, 2, 3, 1, 2]

        // Step 1: Calculate the total weight of the elements
        // Example 1: 1 + 1 + 1 + 1 + 4 + 4 + 4 + 7 + 8 = 31
        // Example 2: 1 + 2 + 2 + 3 + 4 + 5 = 17
        int totalWeight = arr.stream().mapToInt(Integer::intValue).sum();
        
        
        // Step 2: Sort the array in increasing order
        // Example 1: Sorted array: [1, 1, 1, 1, 4, 4, 4, 7, 8]
        // Example 2: Sorted array: [1, 2, 2, 3, 4, 5]
        Collections.sort(arr);

        List<Integer> setA = new ArrayList<>();
        
        // Step 3: Create a map to store the sum of values for each distinct element
        // Example 1: Map {1: 4, 4: 12, 7: 7, 8: 8}
        // Example 2: Map {1: 1, 2: 4, 3: 3, 4: 4, 5: 5}
        Map<Integer, Integer> valueToSumMap = new HashMap<>();

        for (Integer num : arr) {
            valueToSumMap.put(num, valueToSumMap.getOrDefault(num, 0) + num);
        }

        // Step 4: Create a list of distinct sums (values) from the map
        // Example 1: Distinct sums list: [4, 12, 7, 8]
        // Example 2: Distinct sums list: [1, 4, 3, 5]
        List<Integer> result = new ArrayList<>(valueToSumMap.values());

        // Step 5: Sort the distinct sums list in ascending order
        // Example 1: Sorted sums list: [4, 7, 8, 12]
        // Example 2: Sorted sums list: [1, 3, 4, 5]
        Collections.sort(result);
        
        // Step 6: Select elements for setA such that their sum is greater than half of totalWeight
        // Example 1: setA = [12, 8]
        // Example 2: setA = [5, 4]
        int SumSetA = 0;

        for (int i = result.size() - 1; i >= 0; i--) {
            int currentWeight = result.get(i);
            
            SumSetA += currentWeight;
            setA.add(currentWeight);
            
            totalWeight -= SumSetA;
            
            if (SumSetA > totalWeight) {
                break;
            } 
        }


        // Create a list of map entries sorted by value in descending order
        List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(valueToSumMap.entrySet());
        sortedEntries.sort((entry1, entry2) -> {
            int valueComparison = entry2.getValue().compareTo(entry1.getValue());
            if (valueComparison == 0) {
                // If values are the same, compare keys in descending order
                return entry2.getKey().compareTo(entry1.getKey());
            }
            return valueComparison;
        });


        // Step 7: Find elements from sorted entries to complete setA
        // Example 1: resultList = [4, 4, 4, 8]
        // Example 2: resultList = [5, 4]
        List<Integer> resultList = new ArrayList<>();
        int sumWeight = 0;
        

        for (Integer summedValue : setA) {
            for (Map.Entry<Integer, Integer> entry : sortedEntries) {
                int key = entry.getKey();
                int value = entry.getValue();
                int quotient = value / key;

                if (value == summedValue) {
                    int countToAdd = Math.min(quotient, (SumSetA - sumWeight) / key);
                    for (int i = 0; i < countToAdd; i++) {
                        resultList.add(key);
                        sumWeight += key;
                    }
                }
                if (sumWeight >= SumSetA) {
                    break; // Break out of the outer loop once we exceed SumSetA
                }
            }
            if (sumWeight >= SumSetA) {
                break; // Break out of the outer loop once we exceed SumSetA
            }
        }

        // Sort the final result list
        // Example 1: resultList = [4, 4, 4, 8]
        // Example 2: resultList = [4, 5]
        Collections.sort(resultList);

        return resultList;
    }



    public static void main(String[] args){
        
        // Testing various cases
        List<Integer> arr1 = Arrays.asList(3, 7, 5, 6, 2);
	    System.out.println(minimalHeaviestSetA(arr1)); // [6, 7]

        List<Integer> arr2 = Arrays.asList(4, 5, 2, 3, 1, 2);
	    System.out.println(minimalHeaviestSetA(arr2)); // [4, 5]
        
        List<Integer> arr3 = Arrays.asList(10, 5, 3, 1, 20);
	    System.out.println(minimalHeaviestSetA(arr3)); // [20]

        List<Integer> arr4 = Arrays.asList(1, 2, 3, 5, 8);
	    System.out.println(minimalHeaviestSetA(arr4)); // [5, 8]

        List<Integer> arr5 = Arrays.asList(1, 2, 2, 3, 4, 4, 4, 5);
	    System.out.println(minimalHeaviestSetA(arr5)); // [4, 4, 4, 5]

        List<Integer> arr6 = Arrays.asList(1, 2, 2, 2, 3, 4);
	    System.out.println(minimalHeaviestSetA(arr6)); // [2, 2, 2, 4]

        List<Integer> arr7 = Arrays.asList(2, 2, 2, 3);
	    System.out.println(minimalHeaviestSetA(arr7)); // [2, 2, 2]

        List<Integer> arr8 = Arrays.asList(1, 2, 2, 3, 4, 4, 4, 5);
	    System.out.println(minimalHeaviestSetA(arr8)); // [4, 4, 4, 5]
        
        List<Integer> arr9 = Arrays.asList(1, 1, 1, 1, 4, 4, 4, 7, 8);  
	    System.out.println(minimalHeaviestSetA(arr9)); // [4, 4, 4, 8]

    }
}

