# Given array of integers, create a 2D array 
# where the first element is a distinct value from the array 
# the second element is that value's frequency within the array
# Sort the resulting array in descending by frequency.
# If multiple values have the same frequency they should be sorted ascending.
# Example: arr = [3, 3, 1, 2, 1]
#          result = [[1, 2], [3, 2], [2, 1]]

# The getOrDefault() method is a part of the Map interface in Java. 
# It is used to retrieve the value associated with a specified key from the map.
# If the value does not exist return 0
# Example: Map<String, Integer> map = new HashMap<>();
#         map.put("apple", 1);
#         map.put("banana", 2);
        
#         Retrieve the value for an existing key
#         int appleValue = map.getOrDefault("apple", 0);
# 	System.out.println("Value of 'apple': " + appleValue); // Output: Value of 'apple': 1


def SortSummary(arr):

    freq_map = {}

    for num in arr:
        if num in freq_map:
            freq_map[num] += 1
        else:
            freq_map[num] = 1
    
    # print(freq_map)    # {3: 2, 1: 2, 2: 1}

    # Step 2: Convert the dictionary into a list of lists
    # For example, if the dictionary is {3: 2, 1: 2, 2: 1}, 
    # this becomes [[3, 2], [1, 2], [2, 1]]

    pairs = []
    for key, val in freq_map.items():
        pairs.append([key, val])

    # Step 3: Sort the pairs
    # First by frequency in descending order, then by the actual number in ascending order

    # How does the sorting work?
    # 1. By Frequency: First, it sorts the pairs by frequency (the second element in the sublist) 
    # in descending order, because we negated this value (-x[1]).

    # 2. By Value: If two frequencies are the same, it moves on to sorting by the actual numbers 
    # (the first element in the sublist) in ascending order.
    pairs.sort(key=lambda x: (-x[1], x[0]))  # x[1] is the frequency, and x[0] is the number

    return pairs


arr = [3, 3, 1, 2, 1]
print("arr = ", arr)
print("sorted result = ", SortSummary(arr))


# arr =  [3, 3, 1, 2, 1]
# sorted result =  [[1, 2], [3, 2], [2, 1]]