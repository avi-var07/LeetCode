/*N-th Tribonacci Number

The Tribonacci sequence Tn is defined as follows: 

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.

 

Example 1:

Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
Example 2:

Input: n = 25
Output: 1389537
 

Constraints:

0 <= n <= 37
The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.

*/


import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();

        Solution sol =new Solution();
        System.out.println(sol.tribonacci(n));
        sc.close();
    }
    Integer dp[];
    public int tribonacci(int n) {
        dp=new Integer[n+1];
        return solve(n);
    }
    int solve(int n){
        if(n==0)return dp[0]=0;
        if(n<=2)return dp[n]=1;

        if(dp[n]!=null)return dp[n];

        return dp[n]=solve(n-1)+solve(n-2)+solve(n-3);
    }
}