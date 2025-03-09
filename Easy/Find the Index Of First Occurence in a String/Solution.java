/*
 Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 */

import java.util.*;
class Solution {
    static int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length())
        return -1;
        int nl=needle.length();
        for(int i=0;i<=haystack.length()-nl;i++){
            String str = haystack.substring(i,i+nl);
            if(str.equals(needle))
            return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the haystack String: ");
        String haystack = sc.next();
        System.out.println("Enter the needle String: ");
        String needle = sc.next();
        System.out.println(strStr(haystack,needle));
        sc.close();
    }
}