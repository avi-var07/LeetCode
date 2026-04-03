/*You are given an m x n grid. A robot starts at the top-left corner of the grid (0, 0) and wants to reach the bottom-right corner (m - 1, n - 1). The robot can move either right or down at any point in time.

The grid contains a value coins[i][j] in each cell:

If coins[i][j] >= 0, the robot gains that many coins.
If coins[i][j] < 0, the robot encounters a robber, and the robber steals the absolute value of coins[i][j] coins.
The robot has a special ability to neutralize robbers in at most 2 cells on its path, preventing them from stealing coins in those cells.

Note: The robot's total coins can be negative.

Return the maximum profit the robot can gain on the route.

 

Example 1:

Input: coins = [[0,1,-1],[1,-2,3],[2,-3,4]]

Output: 8

Explanation:

An optimal path for maximum coins is:

Start at (0, 0) with 0 coins (total coins = 0).
Move to (0, 1), gaining 1 coin (total coins = 0 + 1 = 1).
Move to (1, 1), where there's a robber stealing 2 coins. The robot uses one neutralization here, avoiding the robbery (total coins = 1).
Move to (1, 2), gaining 3 coins (total coins = 1 + 3 = 4).
Move to (2, 2), gaining 4 coins (total coins = 4 + 4 = 8).
Example 2:

Input: coins = [[10,10,10],[10,10,10]]

Output: 40

Explanation:

An optimal path for maximum coins is:

Start at (0, 0) with 10 coins (total coins = 10).
Move to (0, 1), gaining 10 coins (total coins = 10 + 10 = 20).
Move to (0, 2), gaining another 10 coins (total coins = 20 + 10 = 30).
Move to (1, 2), gaining the final 10 coins (total coins = 30 + 10 = 40).
 

Constraints:

m == coins.length
n == coins[i].length
1 <= m, n <= 500
-1000 <= coins[i][j] <= 1000 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int m = sc.nextInt();
        System.out.println("Enter number of cols: ");
        int n= sc.nextInt();

        int arr[][] = new int[m][n];
        System.out.println("Enter "+m*n+" elements: ");
        for(int i=0;i<m;i++) {
            for(int j=0;i<n;i++)arr[i][j] = sc.nextInt();
        }

        System.out.println(maximumAmount(arr));
        sc.close();
    }
    public static int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;

        int[][][] dp = new int[m][n][3];

        // initialize with very small value
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        for(int k = 0; k < 3; k++){
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){

                    int val = coins[i][j];

                    if(i == 0 && j == 0){
                        if(val < 0 && k > 0) dp[i][j][k] = 0;
                        else dp[i][j][k] = val;
                        continue;
                    }

                    int best = Integer.MIN_VALUE;

                    if(i > 0) best = Math.max(best, dp[i-1][j][k]);
                    if(j > 0) best = Math.max(best, dp[i][j-1][k]);

                    if(best != Integer.MIN_VALUE){
                        dp[i][j][k] = best + val;
                    }

                    if(val < 0 && k > 0){
                        int best2 = Integer.MIN_VALUE;
                        if(i > 0) best2 = Math.max(best2, dp[i-1][j][k-1]);
                        if(j > 0) best2 = Math.max(best2, dp[i][j-1][k-1]);

                        if(best2 != Integer.MIN_VALUE){
                            dp[i][j][k] = Math.max(dp[i][j][k], best2);
                        }
                    }
                }
            }
        }

        return Math.max(dp[m-1][n-1][0],
               Math.max(dp[m-1][n-1][1], dp[m-1][n-1][2]));
    }
}