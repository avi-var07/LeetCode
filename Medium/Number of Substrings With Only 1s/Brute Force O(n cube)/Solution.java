/*Given a binary string s, return the number of substrings with all characters 1's. Since the answer may be too large, return it modulo 109 + 7.

 

Example 1:

Input: s = "0110111"
Output: 9
Explanation: There are 9 substring in total with only 1's characters.
"1" -> 5 times.
"11" -> 3 times.
"111" -> 1 time.
Example 2:

Input: s = "101"
Output: 2
Explanation: Substring "1" is shown 2 times in s.
Example 3:

Input: s = "111111"
Output: 21
Explanation: Each substring contains only 1's characters.
 

Constraints:

1 <= s.length <= 105
s[i] is either '0' or '1 */

import java.util.*;

class Solution{
    static int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String s = sc.nextLine();
        numSub(s);
        System.out.println(numSub(s));
        sc.close();
    }
    public static int numSub(String s) {
        int ans = 0, n=s.length();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                String sub = s.substring(i,j+1);
                if(check(sub))ans++;
            }
        }
        return ans;
    }
    static boolean check(String s){
        for(char ch: s.toCharArray())if(ch=='0')return false;
        return true;
    }
}