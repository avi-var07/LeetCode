/*Given a string s, find the length of the longest substring without duplicate characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces. */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String s = sc.nextLine();
        System.out.println(lengthOfLongestSubstring(s));
        sc.close();
    }
    public static int lengthOfLongestSubstring(String s) {
    
        int n = s.length();
        int hash[] = new int[255];
        int maxLen = 0;
        for(int i=0;i<n;i++){
            Arrays.fill(hash, 0);
            for(int j=i;j<n;j++){
                if(hash[s.charAt(j)]==1)break;
                int len=j-i+1;
                if(len>maxLen)maxLen = len;
                hash[s.charAt(j)]=1;
            }
        }
        return maxLen;
    }
}