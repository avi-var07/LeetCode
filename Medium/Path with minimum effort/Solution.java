/*You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

 

Example 1:



Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
Output: 2
Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
Example 2:



Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
Output: 1
Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].
Example 3:


Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
Output: 0
Explanation: This route does not require any effort.
 

Constraints:

rows == heights.length
columns == heights[i].length
1 <= rows, columns <= 100
1 <= heights[i][j] <= 106 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int m =sc.nextInt();
        System.out.println("Enter number of cols: ");
        int n = sc.nextInt();

        int arr[][] = new int[m][n];
        System.out.println("Enter "+m*n+" elements: ");
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++)arr[i][j] = sc.nextInt();
        }
        Solution sol = new Solution();
        System.out.println(sol.minimumEffortPath(arr));
        sc.close();
    }
    class Pair{
        int row, col, wt;
        Pair(int row, int col, int wt){
            this.row=row;
            this.col=col;
            this.wt=wt;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n=heights[0].length;
        int dist[][] = new int[m][n];
        for(int i=0;i<m;i++)Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0]=0;
        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b)->a.wt-b.wt);
        pq.add(new Pair(0,0, 0));
      
        int drow[]={-1,1,0,0};
        int dcol[]={0,0,1,-1};
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int r1 = p.row;
            int c1=p.col;
            int effort =p.wt;
            if(r1==m-1&&c1==n-1)return effort;

            for(int i=0;i<4;i++){
                int nrow = r1+drow[i];
                int ncol =c1+dcol[i];
                if(nrow>=0&&ncol>=0&&nrow<m&&ncol<n){
                    int diff = Math.abs(heights[nrow][ncol]-heights[r1][c1]);
                    int newEffort = Math.max(effort, diff);
                    if(newEffort<dist[nrow][ncol]){
                        dist[nrow][ncol]=newEffort;
                        pq.add(new Pair(nrow, ncol, newEffort));
                    }
                }
            }
        }
        return 0;
    }
}