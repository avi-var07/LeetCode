/*You are given a 0-indexed m x n integer matrix grid and an integer k. You are currently at position (0, 0) and you want to reach position (m - 1, n - 1) moving only down or right.

Return the number of paths where the sum of the elements on the path is divisible by k. Since the answer may be very large, return it modulo 109 + 7.

 

Example 1:


Input: grid = [[5,2,4],[3,0,5],[0,7,2]], k = 3
Output: 2
Explanation: There are two paths where the sum of the elements on the path is divisible by k.
The first path highlighted in red has a sum of 5 + 2 + 4 + 5 + 2 = 18 which is divisible by 3.
The second path highlighted in blue has a sum of 5 + 3 + 0 + 5 + 2 = 15 which is divisible by 3.
Example 2:


Input: grid = [[0,0]], k = 5
Output: 1
Explanation: The path highlighted in red has a sum of 0 + 0 = 0 which is divisible by 5.
Example 3:


Input: grid = [[7,3,4,9],[2,3,6,2],[2,3,7,0]], k = 1
Output: 10
Explanation: Every integer is divisible by 1 so the sum of the elements on every possible path is divisible by k.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 5 * 104
1 <= m * n <= 5 * 104
0 <= grid[i][j] <= 100
1 <= k <= 50 */

import java.util.*;

class Solution{
    Integer dp[][][];
    int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int m = sc.nextInt();
        System.out.println("Enter number of column: ");
        int n = sc.nextInt();

        int arr[][] = new int[m][n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)arr[i][j] = sc.nextInt();
        } 
        System.out.println("Enter k: ");
        int k = sc.nextInt();
        
        Solution s = new Solution();
        int ans= s.numberOfPaths(arr, k);

        System.out.println(ans);
        sc.close();
    }
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n=grid[0].length;
        dp = new Integer[m][n][k];
        return solve(grid, k, 0,0,0,m,n);
    }
    int solve(int [][]arr, int k, int r, int c, int sum, int m, int n){
        if(r>=m||c>=n)return 0;
        sum+=arr[r][c];
        int mod = sum%k;
        if(dp[r][c][mod]!=null)return dp[r][c][mod];
        if(r==m-1&&c==n-1)return dp[r][c][mod]=(mod==0?1:0);
        long down = solve(arr, k, r+1,c,sum,m, n);
        long right = solve(arr,k,r,c+1,sum,m,n);
        
        return dp[r][c][mod] = (int)((down+right)%MOD);
    }
}