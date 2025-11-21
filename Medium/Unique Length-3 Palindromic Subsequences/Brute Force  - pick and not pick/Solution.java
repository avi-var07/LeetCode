/*Given a string s, return the number of unique palindromes of length three that are a subsequence of s.

Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.

A palindrome is a string that reads the same forwards and backwards.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
 

Example 1:

Input: s = "aabca"
Output: 3
Explanation: The 3 palindromic subsequences of length 3 are:
- "aba" (subsequence of "aabca")
- "aaa" (subsequence of "aabca")
- "aca" (subsequence of "aabca")
Example 2:

Input: s = "adc"
Output: 0
Explanation: There are no palindromic subsequences of length 3 in "adc".
Example 3:

Input: s = "bbcbaba"
Output: 4
Explanation: The 4 palindromic subsequences of length 3 are:
- "bbb" (subsequence of "bbcbaba")
- "bcb" (subsequence of "bbcbaba")
- "bab" (subsequence of "bbcbaba")
- "aba" (subsequence of "bbcbaba")
 

Constraints:

3 <= s.length <= 105
s consists of only lowercase English letters. */

import java.util.*;

class Solution{
    Set<String>set = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");

        String s = sc.nextLine();
        Solution so  = new Solution();
        System.out.println(so.countPalindromicSubsequence(s));

        sc.close();
    }
    public int countPalindromicSubsequence(String s) {
        solver(s, 0, "");

        return set.size();
    }
    void solver(String s, int index, String str){
        if(str.length()==3){
            if(str.charAt(0)==str.charAt(2))set.add(str);
            return;
        }
        if(index==s.length()||str.length()>3)return;
        solver(s,index+1,str+s.charAt(index));
        solver(s,index+1,str);
    }
}