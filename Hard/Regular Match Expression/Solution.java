/*Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
Return a boolean indicating whether the matching covers the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
 

Constraints:

1 <= s.length <= 20
1 <= p.length <= 20
s contains only lowercase English letters.
p contains only lowercase English letters, '.', and '*'.
It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 
 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter s: ");
        String s = sc.nextLine();
        System.out.println("Enter p: ");
        String p = sc.nextLine();

        System.out.println(isMatch(s, p));
        sc.close();
    }
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean dp[][]=new boolean[n+1][m+1]; //empty string k liye
        dp[0][0]=true;

        //pehla column empty string k liye bhro:
        for(int i=1;i<=n;i++){
            if(p.charAt(i-1)=='*')dp[i][0]=dp[i-2][0];
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                char pch = p.charAt(i-1); //kyuki dp +1 size ki hai
                char sch = s.charAt(j-1);
                if(pch==sch||pch=='.')dp[i][j] = dp[i-1][j-1]; //char match kr rha ya dot hai: diagonal up check kro!
                else if(pch=='*'){ //star k liye 2 row upar check krenge pehle:
                    dp[i][j]=dp[i-2][j];

                    //ab prev character match krenge ya to match kre ya dot ho to 1 col back krenge 
                    char prev =p.charAt(i-2);
                    if(prev==sch||prev=='.')dp[i][j]=dp[i][j]||dp[i][j-1]; //1 col back tabhi jb prev char match aur dono mei se jo true ho wo
                }
                else dp[i][j]=false;
                
            }
        }
        return dp[n][m];
    }
}