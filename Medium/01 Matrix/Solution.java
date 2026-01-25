/*Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two cells sharing a common edge is 1.

 

Example 1:


Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.
 

Note: This question is the same as 1765: https://leetcode.com/problems/map-of-highest-peak/ */
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
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) arr[i][j] = sc.nextInt();
        }

        int ans[][] = updateMatrix(arr);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)System.out.print(ans[i][j]+" ");

            System.out.println();
        }
        sc.close();
    }
    static class Pair{
        int row, col, dist;
        Pair(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n=mat[0].length;

        int visited[][] = new int[m][n];
        int ans[][] = new int[m][n];
        Queue<Pair>queue = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1)visited[i][j]=1;
                else{
                    queue.add(new Pair(i, j, 0));
                    visited[i][j]=0;
                }
            }
        }

        int drow[] = {-1,1,0,0};
        int dcol[] = {0,0,1,-1};
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int r = p.row;
            int c =p.col;
            int dis = p.dist;
            ans[r][c] =dis;
            for(int i=0;i<4;i++){
                int nrow = r+drow[i];
                int ncol = c+dcol[i];

                if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n&&visited[nrow][ncol]==1){
                    queue.add(new Pair(nrow, ncol, dis+1));
                    visited[nrow][ncol]=0;
                }
            }
        }

        return ans;
    }
}