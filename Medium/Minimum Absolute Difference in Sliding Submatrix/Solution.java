/*You are given an m x n integer matrix grid and an integer k.

For every contiguous k x k submatrix of grid, compute the minimum absolute difference between any two distinct values within that submatrix.

Return a 2D array ans of size (m - k + 1) x (n - k + 1), where ans[i][j] is the minimum absolute difference in the submatrix whose top-left corner is (i, j) in grid.

Note: If all elements in the submatrix have the same value, the answer will be 0.

A submatrix (x1, y1, x2, y2) is a matrix that is formed by choosing all cells matrix[x][y] where x1 <= x <= x2 and y1 <= y <= y2.
 

Example 1:

Input: grid = [[1,8],[3,-2]], k = 2

Output: [[2]]

Explanation:

There is only one possible k x k submatrix: [[1, 8], [3, -2]].
Distinct values in the submatrix are [1, 8, 3, -2].
The minimum absolute difference in the submatrix is |1 - 3| = 2. Thus, the answer is [[2]].
Example 2:

Input: grid = [[3,-1]], k = 1

Output: [[0,0]]

Explanation:

Both k x k submatrix has only one distinct element.
Thus, the answer is [[0, 0]].
Example 3:

Input: grid = [[1,-2,3],[2,3,5]], k = 2

Output: [[1,2]]

Explanation:

There are two possible k × k submatrix:
Starting at (0, 0): [[1, -2], [2, 3]].
Distinct values in the submatrix are [1, -2, 2, 3].
The minimum absolute difference in the submatrix is |1 - 2| = 1.
Starting at (0, 1): [[-2, 3], [3, 5]].
Distinct values in the submatrix are [-2, 3, 5].
The minimum absolute difference in the submatrix is |3 - 5| = 2.
Thus, the answer is [[1, 2]].
 

Constraints:

1 <= m == grid.length <= 30
1 <= n == grid[i].length <= 30
-105 <= grid[i][j] <= 105
1 <= k <= min(m, n) */
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

        System.out.println("Enter k: ");
        int k =sc.nextInt();

        int ans[][] = minAbsDiff(arr, k);

        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++)System.out.print(ans[i][j]+" ");

            System.out.println();
        }

        sc.close();
    }
    public static int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n =grid[0].length;

        int ans[][] = new int[m-k+1][n-k+1];
        for(int i=0;i<=m-k;i++){
            for(int j=0;j<=n-k;j++){ //m-k and k-k tk isliye taaki out of bound na jaaye
                Set<Integer>set =new TreeSet<>();
                for(int x=i;x<i+k;x++){
                    for(int y=j;y<j+k;y++)set.add(grid[x][y]);
                }

                int mini = Integer.MAX_VALUE;
                Integer prev=null; //TreeSet mei index se access nhi kr skte!
                for(int ele: set){
                    if(prev!=null)mini=Math.min(mini, ele-prev);
                    prev=ele;
                }

                ans[i][j]=mini==Integer.MAX_VALUE?0:mini;
            }
        }
        return ans;
    }
}