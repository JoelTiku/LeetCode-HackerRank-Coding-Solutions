/*
Given array of integers, create a 2D array 
where the first element is a distinct value from the array 
the second element is that value's frequency within the array
Sort the resulting array in descending by frequency.
If multiple values have the same frequency they should be sorted ascending.
Example: arr = [3, 3, 1, 2, 1]
         result = [[1, 2], [3, 2], [2, 1]]

The getOrDefault() method is a part of the Map interface in Java. 
It is used to retrieve the value associated with a specified key from the map.
If the value does not exist return 0
Example: Map<String, Integer> map = new HashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        
        // Retrieve the value for an existing key
        int appleValue = map.getOrDefault("apple", 0);
	System.out.println("Value of 'apple': " + appleValue); // Output: Value of 'apple': 1
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortSummary{

    public static List<List<Integer>> groupSort(List<Integer> arr) {

        List<List<Integer>> outerList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < arr.size(); i++){
            int counter = map.getOrDefault(arr.get(i), 0);
            map.put(arr.get(i), counter + 1);
        }
        
 	// Using entrySet() to get the entry's of the map - getKey() or getValue()
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            List<Integer> innerList = new ArrayList<>();
            innerList.add(entry.getKey()); 	// value
            innerList.add(entry.getValue());	// frequency
            outerList.add(innerList);
        }
        
	
	// if frequencies are matching sort it ascending by value else descending order by frequency
    Comparator<List<Integer>> sortComparator = new Comparator<List<Integer>>() {
        @Override
        public int compare(List<Integer> a, List<Integer> b) {
            if (a.get(1).equals(b.get(1))) { // If the frequencies are the same
                return a.get(0).compareTo(b.get(0)); // Sort in ascending order by the integer value
            } else { 
                return b.get(1).compareTo(a.get(1)); // Otherwise, sort in descending order by the frequency
            }
        }
    };        
    
        outerList.sort(sortComparator);
        
        return outerList;

    }

    public static void main(String[] args){
        
        List<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(3);
        arr.add(1);
        arr.add(2);
        arr.add(1);

        System.out.println("arr = " + arr);
        System.out.println("result = " + groupSort(arr));
    }

}