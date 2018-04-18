package com.sree;
/*
Write a function that, given a list and a target sum, returns zero-based indices of any two distinct elements whose sum is equal to the target sum. If there are no such elements, the function should return null.

For example, findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 12) should return a single dimensional array with two elements and contain any of the following pairs of indices:

1 and 4 (3 + 9 = 12)
2 and 3 (5 + 7 = 12)
3 and 2 (7 + 5 = 12)
4 and 1 (9 + 3 = 12)
 */
import java.util.*;

public class TwoSum {


    public static int[] findTwoSum(int[] list, int sum) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<list.length; i++){
            if (map.containsKey(list[i])) {
                return new int[] {i, map.get(list[i])};
            }
            map.put(sum-list[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 12);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}
