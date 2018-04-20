package com.sree;

/*
Implement function countNumbers that accepts a sorted array of integers and counts the number of array elements that are less than the parameter lessThan.

For example, SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4) should return 2 because there are two array elements less than 4.
 */


public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        return countNumbers(sortedArray, 0, sortedArray.length, lessThan);
    }

    public static int countNumbers(int[] sortedArray, int left, int right, int lessThan) {
        if (sortedArray[left] >= lessThan) {
            return 0;
        }
        if (sortedArray[right-1] < lessThan) {
            return right;
        }
        int middle = (left + (right-left)/2);
        if (sortedArray[middle] < lessThan) {
            if (sortedArray[middle+1] >= lessThan ) {
                return middle+1;
            }
            else {
                return countNumbers(sortedArray, middle+1, right, lessThan);
            }
        }
        else {
            return countNumbers(sortedArray, left, middle, lessThan);
        }
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4));
    }
}