/*You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

 

Example 1:


Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1. */
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
        System.out.println(maxAreaOfIsland(arr));

        sc.close();
    }
    public static int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        int ans =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int area = dfs(visited, grid, i, j, n, m);
                    ans=Math.max(ans, area);
                }
                else visited[i][j]=true;
            }
        }
        return ans;
    }
    static int dfs(boolean visited[][], int grid[][], int row, int col, int n, int m){
        visited[row][col]=true;
        int drow[]={-1,1,0,0};
        int dcol[]={0,0,1,-1};
        int count=1;
        for(int i=0;i<4;i++){
            int nrow = row+drow[i];
            int ncol = col+dcol[i];
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n&&!visited[nrow][ncol]&&grid[nrow][ncol]==1)count+=dfs(visited, grid, nrow, ncol, n, m);
            
        }
        return count;
    }
}