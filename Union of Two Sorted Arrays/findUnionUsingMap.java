//Brute force - using TreeMap

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.*;

public class findUnionUsingMap {
    public static List<Integer> findUnionUsingMap(int[] arr1, int[] arr2, int m, int n) {
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            freq.put(arr1[i], freq.getOrDefault(arr1[i], 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            freq.put(arr2[i], freq.getOrDefault(arr2[i], 0) + 1);
        }
        List<Integer> union = new ArrayList<>();
        for (int key : freq.keySet()) {
            union.add(key);
        }
        return union;
    }

    public static void main(String[] args) {
        // Define size of first array
        int m = 10;
        // Define size of second array
        int n = 7;
        // Initialize first array
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // Initialize second array
        int[] arr2 = {2, 3, 4, 4, 5, 11, 12};
        // Create object of Solution class
        
        // Call FindUnion method
        List<Integer> Union = findUnionUsingMap(arr1, arr2, m, n);
        // Print output message
        System.out.println("Union of arr1 and arr2 is ");
        // Print all elements of union
        for (int val : Union)
            System.out.print(val + " ");
    }
}
