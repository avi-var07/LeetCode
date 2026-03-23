/*You are given a m x n matrix grid. Initially, you are located at the top-left corner (0, 0), and in each step, you can only move right or down in the matrix.

Among all possible paths starting from the top-left corner (0, 0) and ending in the bottom-right corner (m - 1, n - 1), find the path with the maximum non-negative product. The product of a path is the product of all integers in the grid cells visited along the path.

Return the maximum non-negative product modulo 109 + 7. If the maximum product is negative, return -1.

Notice that the modulo is performed after getting the maximum product.

 

Example 1:


Input: grid = [[-1,-2,-3],[-2,-3,-3],[-3,-3,-2]]
Output: -1
Explanation: It is not possible to get non-negative product in the path from (0, 0) to (2, 2), so return -1.
Example 2:


Input: grid = [[1,-2,1],[1,-2,1],[3,-4,1]]
Output: 8
Explanation: Maximum non-negative product is shown (1 * 1 * -2 * -4 * 1 = 8).
Example 3:


Input: grid = [[1,3],[0,-4]]
Output: 0
Explanation: Maximum non-negative product is shown (1 * 0 * -4 = 0).
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 15
-4 <= grid[i][j] <= 4
 
 */

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
            for(int j=0;j<n;j++)arr[i][j] = sc.nextInt();
        }

        Solution sol = new Solution();
        System.out.println(sol.maxProductPath(arr));
        sc.close();
    }
    int MOD=1000000007;
    Long maxi[][];
    Long mini[][];
    public int maxProductPath(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        maxi=new Long[m][n];
        mini=new Long[m][n];

        long ans[] = dfs(grid, m, n, 0,0);

        if(ans[0]<0)return -1;

        return (int)(ans[0]%MOD);

        //wrong wala call: return dfs(grid, m, n, 0,0);
    }
    long[] dfs(int arr[][], int m, int n, int row, int col){
        //Wrong:
        // if(row==m-1&&col==n-1)return arr[row][col];
        // if(row>=m||col>=n)return 1;
        
        // int down = 1, right=1;

        // down=(down*dfs(arr, m, n, row+1, col ))%MOD;
        // right=(right*dfs(arr, m, n, row, col+1 ))%MOD;

        // return Math.max(down, right);

        //Need to keep track for both positive and negative to find MAXI.

        //negative sign flip krk maximum bana skte
        //Current max = max( num * prevMax, num * prevMin )
        //Current min = min( num * prevMax, num * prevMin )

        if(row==m-1&&col==n-1)return new long[]{arr[row][col], arr[row][col]};

        if(maxi[row][col]!=null)return new long[]{maxi[row][col], mini[row][col]};

        long maxVal = Long.MIN_VALUE;
        long minVal = Long.MAX_VALUE;

        if(row+1<m){
            long down[] = dfs(arr, m,n, row+1, col);
            long a =down[0]*arr[row][col];
            long b=down[1]*arr[row][col];

            maxVal = Math.max(maxVal, Math.max(a,b));
            minVal = Math.min(minVal, Math.min(a,b));
        }
        if(col+1<n){
            long down[] = dfs(arr, m,n, row, col+1);
            long a =down[0]*arr[row][col];
            long b=down[1]*arr[row][col];

            maxVal = Math.max(maxVal, Math.max(a,b));
            minVal = Math.min(minVal, Math.min(a,b));
        }

        maxi[row][col]=maxVal;
        mini[row][col]=minVal;

        return new long[]{maxi[row][col], mini[row][col]};
    }
}