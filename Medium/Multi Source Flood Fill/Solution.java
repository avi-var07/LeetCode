/*You are given two integers n and m representing the number of rows and columns of a grid, respectively.

You are also given a 2D integer array sources, where sources[i] = [ri, ci, color​​​​​​​i] indicates that the cell (ri, ci) is initially colored with colori. All other cells are initially uncolored and represented as 0.

At each time step, every currently colored cell spreads its color to all adjacent uncolored cells in the four directions: up, down, left, and right. All spreads happen simultaneously.

If multiple colors reach the same uncolored cell at the same time step, the cell takes the color with the maximum value.

The process continues until no more cells can be colored.

Return a 2D integer array representing the final state of the grid, where each cell contains its final color.

 

Example 1:

Input: n = 3, m = 3, sources = [[0,0,1],[2,2,2]]

Output: [[1,1,2],[1,2,2],[2,2,2]]

Explanation:

The grid at each time step is as follows:

​​​​​​​

At time step 2, cells (0, 2), (1, 1), and (2, 0) are reached by both colors, so they are assigned color 2 as it has the maximum value among them.

Example 2:

Input: n = 3, m = 3, sources = [[0,1,3],[1,1,5]]

Output: [[3,3,3],[5,5,5],[5,5,5]]

Explanation:

The grid at each time step is as follows:



Example 3:

Input: n = 2, m = 2, sources = [[1,1,5]]

Output: [[5,5],[5,5]]

Explanation:

The grid at each time step is as follows:

​​​​​​​

Since there is only one source, all cells are assigned the same color.

 

Constraints:

1 <= n, m <= 105
1 <= n * m <= 105
1 <= sources.length <= n * m
sources[i] = [ri, ci, colori]
0 <= ri <= n - 1
0 <= ci <= m - 1
1 <= colori <= 106​​​​​​​
All (ri, ci​​​​​​​) in sources are distinct. */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.println("Enter number of cols: ");
        int m = sc.nextInt();

        System.out.println("Enter sources length: " );
        int l = sc.nextInt();
        int arr[][] = new int[l][3];
        System.out.println("Enter "+l+" elements: ");
        for(int i=0;i<l;i++) {
            System.out.println("Enter row: ");
            arr[i][0] = sc.nextInt();
            System.out.println("Enter col: ");
            arr[i][1] = sc.nextInt();
            System.out.println("Enter color: ");
            arr[i][2] = sc.nextInt();
        }

        int ans[][] = colorGrid(n, m, arr);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)System.out.print(ans[i][j]+" ");

            System.out.println();
        }

        sc.close();
    }
    public static int[][] colorGrid(int n, int m, int[][] sources) {
        int ans[][] = new int [n][m];
        Queue<int[]>queue = new LinkedList<>();
        int dist[][] = new int[n][m];

        for(int i=0;i<n;i++)Arrays.fill(dist[i], Integer.MAX_VALUE);
        for(int ele[]: sources){
            int row= ele[0];
            int col=ele[1];
            int color=ele[2];

            ans[row][col]=color;
            queue.add(new int[]{row, col, color, 0});
            dist[row][col]=0;
        }

        int drow[] = {-1,1, 0,0};
        int dcol[] = {0, 0, -1, 1};
        while(!queue.isEmpty()){
            int ele[] = queue.poll();
            int row = ele[0];
            int col =ele[1];
            int color=ele[2];
            int level = ele[3];
            for(int i=0;i<4;i++){
                int nrow = row+drow[i];
                int ncol = col +dcol[i];

                if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m){
                    //first time
                    if(dist[nrow][ncol]>level+1){
                        dist[nrow][ncol]=level+1;
                        ans[nrow][ncol]=color;
                        queue.add(new int[]{nrow, ncol, color, level+1});
                    }
                    //already hai to maxi lo
                    else if(dist[nrow][ncol]==level+1){
                        if(ans[nrow][ncol]<color){
                            ans[nrow][ncol]=color;
                            queue.add(new int[]{nrow, ncol, color, level+1});
                        }
                    }
                }
            }

        }
        return ans;
    }
}