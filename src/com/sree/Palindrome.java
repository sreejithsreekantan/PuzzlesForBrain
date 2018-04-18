package com.sree;

/*
A palindrome is a word that reads the same backward or forward.

Write a function that checks if a given word is a palindrome. Character case should be ignored.

For example, isPalindrome("Deleveled") should return true as character case should be ignored,
resulting in "deleveled", which is a palindrome since it reads the same backward and forward.
*/

public class Palindrome {
    public static boolean isPalindrome(String word) {
        word = word.toLowerCase();

        int leftIter, rightIter;
        leftIter = 0;
        rightIter = word.length()-1;
        while (leftIter < rightIter) {
            if (word.charAt(leftIter) != word.charAt(rightIter)) {
                return false;
            }
            leftIter++;
            rightIter--;
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
        System.out.println(Palindrome.isPalindrome("deleveled"));
        System.out.println(Palindrome.isPalindrome("deleveled1"));
        System.out.println(Palindrome.isPalindrome("DeleeleD"));
    }
}