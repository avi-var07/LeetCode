/*You are given an n x n grid representing a field of cherries, each cell is one of three possible integers.

0 means the cell is empty, so you can pass through,
1 means the cell contains a cherry that you can pick up and pass through, or
-1 means the cell contains a thorn that blocks your way.
Return the maximum number of cherries you can collect by following the rules below:

Starting at the position (0, 0) and reaching (n - 1, n - 1) by moving right or down through valid path cells (cells with value 0 or 1).
After reaching (n - 1, n - 1), returning to (0, 0) by moving left or up through valid path cells.
When passing through a path cell containing a cherry, you pick it up, and the cell becomes an empty cell 0.
If there is no valid path between (0, 0) and (n - 1, n - 1), then no cherries can be collected.
 

Example 1:


Input: grid = [[0,1,-1],[1,0,-1],[1,1,1]]
Output: 5
Explanation: The player started at (0, 0) and went down, down, right right to reach (2, 2).
4 cherries were picked up during this single trip, and the matrix becomes [[0,1,-1],[0,0,-1],[0,0,0]].
Then, the player went left, up, up, left to return home, picking up one more cherry.
The total number of cherries picked up is 5, and this is the maximum possible.
Example 2:

Input: grid = [[1,1,-1],[1,-1,1],[-1,1,1]]
Output: 0
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 50
grid[i][j] is -1, 0, or 1.
grid[0][0] != -1
grid[n - 1][n - 1] != -1 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of grid: ");
        int n = sc.nextInt();

        int arr[][] = new int[n][n];
        System.out.println("Enter "+n*n+" elements: ");
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++)arr[i][j] = sc.nextInt();
        }
        Solution s= new Solution();
        System.out.println(s.cherryPickup(arr));
        sc.close();
    }
    //1. ek baar upar se down right krk niche jaana hai last pr n-1, n-1 
    //2. ek baar down se up jaana hai 0,0 pr
    //ab 2nd wala reverse krde to wo 1st wala hi hojayega ...kaise? dekho number of paths 1st mei aur 2nd mei same hi rhenge to time same hi jayega isliye dono sath mei chalate hai 1st se: 
    //iska mtlb dono down right to combionations:
    //down down, down right, right down, right right.

    //normal 4D dp se TLE...ab aao 3D mei convert
    //r1+c1=k and r2+c2=k....mtlb r1 and c1 steps suppose k, aur since r2 c2 ko bhi same hi time lgega to ....r1+c1-r2=c2 hojayega:
    //c2 pass krne ki zaroorat hi nhi:
    Integer dp[][][];
    public int cherryPickup(int[][] grid) {
        
        int n=grid.length;
        dp=new Integer[n][n][n];
        int ans = dfs(grid, 0,0,0, n);
        return Math.max(0, ans);
    }
    int dfs(int grid[][], int r1, int c1, int r2, int n){
        int c2 = r1+c1-r2;
        if(r1>=n||c1>=n||r2>=n||c2>=n||c2<0)return Integer.MIN_VALUE;  //maximum cherries nikalni hai n
        if(grid[r1][c1]==-1||grid[r2][c2]==-1)return dp[r1][c1][r2]=Integer.MIN_VALUE; //thorn hai nhi le skte
        
        if(dp[r1][c1][r2]!=null)return dp[r1][c1][r2];
        int ans =0;
        //agar dono same cell pe hai to yr ek hi baar pick kr skte!

        if(r1==r2&&c1==c2)ans=grid[r1][c1];
        else ans=grid[r1][c1]+grid[r2][c2];

        if(r1==n-1&&c1==n-1)return dp[r1][c1][r2]=grid[r1][c1]; //dono sath hi me pahuchenge koi bhi likh do   
        int dd = dfs(grid, r1+1, c1, r2+1, n); //both down down
        int dr = dfs(grid, r1+1, c1, r2, n); //down and right
        int dl = dfs(grid, r1, c1+1, r2+1, n); //right and down
        int rr = dfs(grid, r1, c1+1, r2, n); //right and right

        int maxi = Math.max(dd, Math.max(dr, Math.max(dl, rr)));
        if(maxi==Integer.MIN_VALUE)return dp[r1][c1][r2]=Integer.MIN_VALUE;
        return dp[r1][c1][r2]= ans+maxi;
    }   
}   