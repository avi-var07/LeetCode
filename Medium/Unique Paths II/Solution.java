/*You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 109.

 

Example 1:


Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
Example 2:


Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
 

Constraints:

m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 1. */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int m = sc.nextInt();
        System.out.println("Enter number of cols: ");
        int n = sc.nextInt();

        int arr[][] = new int[m][n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++)arr[i][j] = sc.nextInt();
        }

        Solution s = new Solution();
        System.out.println(s.uniquePathsWithObstacles(arr));
        sc.close();
    }
    Integer dp[][];
    public int uniquePathsWithObstacles(int[][] arr) {
        int m =arr.length;
        int n = arr[0].length;

        dp=new Integer[m][n];
        if(arr[0][0]==1)return 0;
        return dfs(0,0,arr, m, n);
    }
    int dfs(int row, int col, int grid[][], int m, int n){
        if(row==m-1&&col==n-1)return 1;
        if(grid[row][col]==1)return 0;
        if(row>=m||col>=n)return 0;

        if(dp[row][col]!=null)return dp[row][col];
        int drow[] = {1,0};
        int dcol[] = {0, 1};
        int ans =0;
        for(int i=0;i<2;i++){
            int nrow = row+drow[i];
            int ncol = col+dcol[i];

            if(nrow<m&&ncol<n&&grid[nrow][ncol]==0)ans+=dfs(nrow, ncol, grid, m, n);
        }
        return dp[row][col]=ans;
    }
} 