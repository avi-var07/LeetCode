/*Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.
 

Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
Example 2:

Input: s = "abcde", goal = "abced"
Output: false
 

Constraints:


1 <= s.length, goal.length <= 100
s and goal consist of lowercase English letters.*/

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter start String: ");
        String s = sc.nextLine();
        System.out.println("Enter Goal String: ");
        String goal = sc.nextLine();

        System.out.println(rotateString(s, goal));
        sc.close();
    }
    public static boolean rotateString(String s, String goal) {
        String combined = s+s;
        if(goal.length()!=s.length())return false;
        if(combined.indexOf(goal)!=-1)return true;
        return false;
    }
}