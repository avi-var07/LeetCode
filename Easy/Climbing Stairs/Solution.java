/*You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();
        
        Solution s = new Solution();
        System.out.println(s.climbStairs(n));
        sc.close();
    }
    Integer dp[];
    public int climbStairs(int n) {
        dp= new Integer[n+1];
        return dfs_tab(n);
    }
    // int dfs(int n, int idx){
    //     if(idx==n)return 1; //pahuch gaye;
    //     if(idx>n)return 0; //ye way nhi hai

    //     if(dp[idx]!=null)return dp[idx];
    //     int oneStep = dfs(n, idx+1);
    //     int twoStep = dfs(n, idx+2);

    //     return dp[idx]=oneStep+twoStep;
    // }

    int dfs_tab(int n){
        for(int i=n;i>=0;i--){
            if(i==n){
                dp[i]=1;
                continue;
            }
            int oneStep = dp[i+1];
            int twoStep = 0;
            if(i+2<=n)twoStep=dp[i+2];

            dp[i]=oneStep+twoStep;
        }
        return dp[0];
    }
}