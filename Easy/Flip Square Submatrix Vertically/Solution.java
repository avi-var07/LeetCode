/*You are given an m x n integer matrix grid, and three integers x, y, and k.

The integers x and y represent the row and column indices of the top-left corner of a square submatrix and the integer k represents the size (side length) of the square submatrix.

Your task is to flip the submatrix by reversing the order of its rows vertically.

Return the updated matrix.

 

Example 1:


Input: grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], x = 1, y = 0, k = 3

Output: [[1,2,3,4],[13,14,15,8],[9,10,11,12],[5,6,7,16]]

Explanation:

The diagram above shows the grid before and after the transformation.

Example 2:

​​​​​​​
Input: grid = [[3,4,2,3],[2,3,4,2]], x = 0, y = 2, k = 2

Output: [[3,4,4,2],[2,3,2,3]]

Explanation:

The diagram above shows the grid before and after the transformation.

 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
1 <= grid[i][j] <= 100
0 <= x < m
0 <= y < n
1 <= k <= min(m - x, n - y) */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int m= sc.nextInt();
        System.out.println("Enter number of cols: ");
        int n= sc.nextInt();

        int arr[][] = new int[m][n];
        System.out.println("Enter "+m*n+" elements: ");
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++)arr[i][j] = sc.nextInt();
        }
        
        System.out.println("Enter x: ");
        int x =sc.nextInt();
        System.out.println("Enter y: ");
        int y =sc.nextInt();
        
        System.out.println("Enter k: ");
        int k =sc.nextInt();
        
        int ans[][]  =reverseSubmatrix(arr, x, y, k);
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++)System.out.print(ans[i][j]+" ");

            System.out.println();
        }
        
        sc.close();
    }
    public static int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int sRow =x, eRow=x+k-1;

        while(sRow<eRow){
            for(int j=y;j<y+k;j++){
                int temp = grid[sRow][j];
                grid[sRow][j]=grid[eRow][j];
                grid[eRow][j]=temp;
            }
            sRow++;
            eRow--;
        }
        return grid;
    }
}