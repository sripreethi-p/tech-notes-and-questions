package com.dsa.algorithms.problems.leetcode;

public class FindTheClosestPalindrome564 {

    /*
    Given a string n representing an integer, return the closest integer (not including itself), which is a palindrome.
    If there is a tie, return the smaller one.
    The closest is defined as the absolute difference minimized between two integers.

    Example 1:
        Input: n = "123"
        Output: "121"
    Example 2:
        Input: n = "1"
        Output: "0"
    Explanation: 0 and 2 are the closest palindromes, but we return the smallest which is 0.
     */

//    public String nearestPalindromic(String n) {
//       long number = Long.parseLong(n);
//       if(number<=10) {
//           return String.valueOf(number-1);
//       }
//       if(number==11) {
//           return "9";
//       }
//
//       int length = n.length();
//       int mid = length/2;
//       StringBuilder result = new StringBuilder();
//       result.append(n);
//
//       int palindromeIndex = isPalindrome(n, length, mid);
//
//       if(palindromeIndex == -2) {
//           for (int i=mid; i<length; i++) {
//               result.setCharAt(i, result.charAt(length-i-1));
//           }
//       }
//       else if(palindromeIndex==-1) {
//           int midChar = Integer.parseInt(String.valueOf(result.charAt(mid)));
//           int midClosest = midChar+1;
//           if(result.charAt(mid)!='0') {
//               midClosest = midChar-1;
//           }
//           result.setCharAt(mid, String.valueOf(midClosest).charAt(0));
//           result.setCharAt(length-mid-1, String.valueOf(midClosest).charAt(0));
//       }
//       else if(palindromeIndex==)
//
//
//    }

    private int isPalindrome(String n, int length, int mid) {
        int palindrome = -1;
        boolean isNine = n.charAt(mid) == '9';

        for (int i=mid; i<length; i++) {
            if(n.charAt(i)!=n.charAt(length-i-1)) {
                return -2;
            }
            if(n.charAt(i)=='9' && isNine) {
                palindrome=length-i-1;
            }
            else {
                isNine=false;
            }
        }
        return palindrome;
    }
}
