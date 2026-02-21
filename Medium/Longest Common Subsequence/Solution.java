/*Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.
 
 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String s: ");
        String s= sc.nextLine();
        System.out.println("Enter String t: ");
        String t= sc.nextLine();

        Solution sol = new Solution();
        System.out.println(sol.longestCommonSubsequence(s, t));
        sc.close();
    }
    //do pointer rkhenge 1 a[0] aur 1 b[0] pe:
    //agar i aur j pe character same hai to dono aage badha denge count bdha kr
    //agar different hai to 1 pointer fix krk dusra aage badha do fir jb  tk wo same jaarha thik nhi to different hone pe dusre ko fix krk pehle aage badha do

    Integer dp[][];
    public int longestCommonSubsequence(String a, String b) {
        int m  =a.length(), n = b.length();
        dp=new Integer[m][n];
        return lcs(a,b,0,0,m,n);
    }
    int lcs(String a, String b, int i, int j, int m, int n){
        if(i>=m||j>=n)return 0;
        if(dp[i][j]!=null)return dp[i][j];
        if(a.charAt(i)==b.charAt(j))return dp[i][j]=1+lcs(a,b, i+1, j+1, m, n);
        
        int one = lcs(a,b,i+1, j, m, n);
        int two = lcs(a,b,i, j+1, m, n);
        return dp[i][j]=Math.max(one, two);
    }
}