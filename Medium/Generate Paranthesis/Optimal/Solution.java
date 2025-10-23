/*Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length: ");
        int n = sc.nextInt();
        List<String>ans = generateParenthesis(n);
        
        for(var ele: ans)System.out.print(ele+" ");
        
        sc.close();
    }
    public static List<String> generateParenthesis(int n) {
        List<String>ans = new ArrayList<>();

        solve(n, ans, "", 0, 0);
        return ans;
    }
    static void solve(int n, List<String>ans, String curr, int open, int close){
        if(curr.length()==2*n){
            ans.add(curr);
            return;
        }
        if(open<n)solve(n,ans, curr+"(", open+1, close);
        if(close<open)solve(n,ans, curr+")", open, close+1);
    }
}