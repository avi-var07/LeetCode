/*Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Rows: ");
        int n = sc.nextInt();
        System.out.println("Enter number of Columns: ");
        int m = sc.nextInt();

        char arr[][] = new char[n][m];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)arr[i][j] = sc.next().charAt(0);

        } 
        System.out.println(numIslands(arr));
        sc.close();
    }
    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][]  = new boolean[n][m];
        int count = 0;
        for(int i= 0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]&&grid[i][j]=='1'){
                    count++;
                    dfs(visited, grid, i, j, n, m);
                }
            }
        }
        return count;
    }
    static void dfs(boolean visited[][], char grid[][], int row, int col, int n, int m){
        

        if(row<0||col<0||row>=n||col>=m||grid[row][col]=='0'||visited[row][col])return;
        visited[row][col]=true;


        dfs(visited, grid, row-1, col, n, m); //upar
        dfs(visited, grid, row+1, col, n, m);   //niche
        dfs(visited, grid, row, col-1, n, m);   //left
        dfs(visited, grid, row, col+1, n, m);   //right
    }
}