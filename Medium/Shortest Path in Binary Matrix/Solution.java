/*Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

 

Example 1:


Input: grid = [[0,1],[1,0]]
Output: 2
Example 2:


Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4
Example 3:

Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1 */

import java.util.*;

class Solution{
   static class Pair{
    int row, col, dist;

    Pair(int row, int col, int dist){
        this.row= row;
        this.col=col;
        this.dist = dist;
    }
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[][] = new int[n][n];
        System.out.println("Enter "+n*n+" elements: ");
        for(int i=0;i<n;i++) {
            
            for(int j=0;j<n;j++)arr[i][j] = sc.nextInt();
        }
        System.out.println(shortestPathBinaryMatrix(arr));
        sc.close();
    }
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n =grid.length;

        if(grid[0][0]==1||grid[n-1][n-1]==1)return -1;
        Queue<Pair>queue = new LinkedList<>();

        queue.add(new Pair(0,0,1));

        int drow[] = {-1,-1,0,1,1,1,0,-1};
        int dcol[]={0,1,1,1,0,-1,-1,-1};

        boolean visited[][] = new boolean[n][n];

        visited[0][0]=true;
        while(!queue.isEmpty()){
            Pair p  =queue.poll();
            int r= p.row;
            int c=p.col;
            int d =p.dist;

            if(r==n-1&&c==n-1)return d;
            for(int i=0;i<8;i++){
                int nrow =r+drow[i];
                int ncol =c+dcol[i];
                

                if(nrow>=0&&nrow<n&&ncol>=0&&ncol<n&&!visited[nrow][ncol]&&grid[nrow][ncol]==0){
                    visited[nrow][ncol]=true;
                    queue.add(new Pair(nrow, ncol, d+1));
                }
            }
        }
        return -1;
    }
}