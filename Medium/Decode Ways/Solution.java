/*You have intercepted a secret message encoded as a string of numbers. The message is decoded via the following mapping:

"1" -> 'A'

"2" -> 'B'

...

"25" -> 'Y'

"26" -> 'Z'

However, while decoding the message, you realize that there are many different ways you can decode the message because some codes are contained in other codes ("2" and "5" vs "25").

For example, "11106" can be decoded into:

"AAJF" with the grouping (1, 1, 10, 6)
"KJF" with the grouping (11, 10, 6)
The grouping (1, 11, 06) is invalid because "06" is not a valid code (only "6" is valid).
Note: there may be strings that are impossible to decode.

Given a string s containing only digits, return the number of ways to decode it. If the entire string cannot be decoded in any valid way, return 0.

The test cases are generated so that the answer fits in a 32-bit integer.

 

Example 1:

Input: s = "12"

Output: 2

Explanation:

"12" could be decoded as "AB" (1 2) or "L" (12).

Example 2:

Input: s = "226"

Output: 3

Explanation:

"226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

Example 3:

Input: s = "06"

Output: 0

Explanation:

"06" cannot be mapped to "F" because of the leading zero ("6" is different from "06"). In this case, the string is not a valid encoding, so return 0.

 

Constraints:

1 <= s.length <= 100
s contains only digits and may contain leading zero(s). */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String s = sc.nextLine();
        Solution sol = new Solution();
        System.out.println(sol.numDecodings(s));
        sc.close();
    }
    Integer dp[];
    public int numDecodings(String s) {
        int n =s.length();
        dp=new Integer[n+1];
        return solve(s, 0, n);
    }
    int solve(String s, int index, int n){
        if(index>=n)return dp[index]=1;
        if(s.charAt(index)=='0')return dp[index]=0;

        if(dp[index]!=null)return dp[index];
        int pickOne = solve(s, index+1, n);
        int pickTwo=0;

        if(index+1<n){
            int num = (s.charAt(index)-'0')*10+(s.charAt(index+1)-'0');

            if(num<=26)pickTwo += solve(s, index+2, n);
        }
        return dp[index]=pickOne+pickTwo;
    }
}