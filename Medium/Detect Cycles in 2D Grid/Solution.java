/*Given a 2D array of characters grid of size m x n, you need to find if there exists any cycle consisting of the same value in grid.

A cycle is a path of length 4 or more in the grid that starts and ends at the same cell. From a given cell, you can move to one of the cells adjacent to it - in one of the four directions (up, down, left, or right), if it has the same value of the current cell.

Also, you cannot move to the cell that you visited in your last move. For example, the cycle (1, 1) -> (1, 2) -> (1, 1) is invalid because from (1, 2) we visited (1, 1) which was the last visited cell.

Return true if any cycle of the same value exists in grid, otherwise, return false.

 

Example 1:



Input: grid = [["a","a","a","a"],["a","b","b","a"],["a","b","b","a"],["a","a","a","a"]]
Output: true
Explanation: There are two valid cycles shown in different colors in the image below:

Example 2:



Input: grid = [["c","c","c","a"],["c","d","c","c"],["c","c","e","c"],["f","c","c","c"]]
Output: true
Explanation: There is only one valid cycle highlighted in the image below:

Example 3:



Input: grid = [["a","b","b"],["b","z","b"],["b","b","a"]]
Output: false
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 500
grid consists only of lowercase English letters. */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of row: ");
        int m = sc.nextInt();
        System.out.println("Enter number of col: ");
        int n = sc.nextInt();

        char arr[][] = new char[m][n];
        System.out.println("Enter "+m*n+" elements: ");
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++)arr[i][j] = sc.next().charAt(0);
        }
        System.out.println(containsCycle(arr));
        sc.close();
    }
    public static boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]){
                    if(bfs(vis, grid, i, j, m, n))return true;
                }
            }
        }

        return false;
        
    }
    // static boolean dfs(boolean vis[][], char grid[][], int row, int col, int prow, int pcol, int m, int n){
        
    //     int drow[] = {-1,1,0,0};
    //     int dcol[] = {0,0,-1,1};
        
    //     vis[row][col]=true;

    //     for(int i=0;i<4;i++){
    //         int nrow=row+drow[i];
    //         int ncol = col+dcol[i];

    //         if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n){
    //             if(grid[nrow][ncol]==grid[row][col]){
    //                 if(!vis[nrow][ncol]){
    //                     if(dfs(vis, grid, nrow, ncol, row, col, m, n))return true;
    //                 }
    //                 else if(nrow!=prow||ncol!=pcol)return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    static boolean bfs(boolean vis[][], char grid[][], int row, int col, int m, int n){
        
        int drow[] = {-1,1,0,0};
        int dcol[] = {0,0,-1,1};
        //int parent[][] = new int[m][n];
        //for(int i=0;i<m;i++)Arrays.fill(parent[i], -1);
        Queue<int[]>queue = new LinkedList<>();
        // queue.add(new int[]{row, col});
        queue.add(new int[]{row, col, -1, -1});
        vis[row][col]=true;
        //parent[row][col]=-1;
        while(!queue.isEmpty()){
            int ele[] = queue.poll();
            int r =ele[0];
            int c = ele[1];

            int prow = ele[2];
            int pcol=ele[3];

            for(int i=0;i<4;i++){
                int nrow= r+drow[i];
                int ncol=c+dcol[i];

                if(nrow>=0&&ncol>=0&&nrow<m&&ncol<n){
                    if(grid[nrow][ncol]==grid[r][c]){
                        if(!vis[nrow][ncol]){
                            queue.add(new int[]{nrow, ncol, r, c});
                            vis[nrow][ncol]=true;
                        }
                        else if(nrow!=prow||ncol!=pcol)return true;
                    }
                    else continue;
                }
            }
        }
        return false;
    }
}