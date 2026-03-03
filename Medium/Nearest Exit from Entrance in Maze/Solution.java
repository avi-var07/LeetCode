/*You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.

In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.

Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.

 

Example 1:


Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
Output: 1
Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
Initially, you are at the entrance cell [1,2].
- You can reach [1,0] by moving 2 steps left.
- You can reach [0,2] by moving 1 step up.
It is impossible to reach [2,3] from the entrance.
Thus, the nearest exit is [0,2], which is 1 step away.
Example 2:


Input: maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
Output: 2
Explanation: There is 1 exit in this maze at [1,2].
[1,0] does not count as an exit since it is the entrance cell.
Initially, you are at the entrance cell [1,0].
- You can reach [1,2] by moving 2 steps right.
Thus, the nearest exit is [1,2], which is 2 steps away.
Example 3:


Input: maze = [[".","+"]], entrance = [0,0]
Output: -1
Explanation: There are no exits in this maze.
 

Constraints:

maze.length == m
maze[i].length == n
1 <= m, n <= 100
maze[i][j] is either '.' or '+'.
entrance.length == 2
0 <= entrancerow < m
0 <= entrancecol < n
entrance will always be an empty cell. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int m = sc.nextInt();
        System.out.println("Enter number of cols: ");
        int n= sc.nextInt();

        char arr[][] = new char[m][n];
        System.out.println("Enter "+m*n+" elements: ");
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++)arr[i][j] = sc.next().charAt(0);
        }

        int entry[] =new int[2];
        System.out.println("Enter start row: ");
        entry[0] = sc.nextInt();
        System.out.println("Enter start col: ");
        entry[1] = sc.nextInt();

        Solution sol = new Solution();
        System.out.println(sol.nearestExit(arr, entry));
        
        sc.close();
    }
    class Pair{
        int row, col, level;
        Pair(int row, int col, int level){
            this.row= row;
            this.col=col;
            this.level=level;
        }
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<Pair>queue = new LinkedList<>();
        int m =maze.length;
        int n =maze[0].length;
        //boolean visited[][] = new boolean[m][n];
        int sr =entrance[0];
        int sc = entrance[1];
    
        queue.add(new Pair(sr, sc, 0));
        //visited[sr][sc]=true;

        int drow[]={-1,1,0,0};
        int dcol[]={0,0,-1, 1};
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int row = p.row;
            int col =p.col;
            int level =p.level;

            if((row==0||row==m-1||col==n-1||col==0)&&!(row==sr&&col==sc))return level;
            for(int i=0;i<4;i++){
                int nrow = row+drow[i];
                int ncol = col+dcol[i];
                //if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n&&!visited[nrow][ncol]&&maze[nrow][ncol]=='.'){
                    // visited[nrow][ncol]=true;
                    // queue.add(new Pair(nrow, ncol, level+1));
               // }
                if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n&&maze[nrow][ncol]=='.'){
                    maze[nrow][ncol]='+';
                    queue.add(new Pair(nrow, ncol, level+1));
                }
            }
        }
        return -1;
    }
}