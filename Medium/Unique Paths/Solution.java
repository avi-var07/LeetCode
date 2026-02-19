/*There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

 

Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 

Constraints:

1 <= m, n <= 100
 
 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int m = sc.nextInt();
        System.out.println("Enter number of cols: ");
        int n = sc.nextInt();

        Solution s = new Solution();
        System.out.println(s.uniquePaths(m, n));
        sc.close();
    }
    Integer dp[][];
    public int uniquePaths(int m, int n) {
        dp=new Integer[m][n];
        return dfs(0, 0, m, n);
    }
    int dfs(int row, int col, int m, int n){
        if(row==m-1&&col==n-1)return 1;
        if(row>=m||col>=n)return 0;
        if(dp[row][col]!=null)return dp[row][col];
        int down=0, right=0;
        if(row<m)down += dfs(row+1, col, m, n);
        if(col<n)right += dfs(row, col+1, m, n);

        return dp[row][col]=down+right;
    }
}