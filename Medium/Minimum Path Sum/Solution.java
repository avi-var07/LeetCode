/*Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

 

Example 1:


Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 200 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int m = sc.nextInt();
        
        System.out.println("Enter number of cols: ");
        int n = sc.nextInt();

        int arr[][] = new int[m][n];
        System.out.println("Enter "+m*n+" elements: ");
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++)arr[i][j] = sc.nextInt();
        }
        Solution s = new Solution();
        System.out.println(s.minPathSum(arr));

        sc.close();
    }
     Integer dp[][];
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp=new Integer[m][n];
        return solve(grid, m, n, 0,0);
    }
    int solve(int arr[][], int m, int n, int row, int col){
        
        if(row==m-1&&col==n-1)return arr[row][col];
        if(row>=m||col>=n)return Integer.MAX_VALUE;
        if(dp[row][col]!=null)return dp[row][col];
        int down=0;
        int right =0;

        if(row<m&&col<n)down+=solve(arr, m, n, row+1, col);
        if(col<n&&row<m)right+=solve(arr, m, n, row, col+1);

        return dp[row][col]=arr[row][col]+Math.min(down, right);
    }
}