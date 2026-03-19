/*Given a 2D character matrix grid, where grid[i][j] is either 'X', 'Y', or '.', return the number of submatrices that contain:

grid[0][0]
an equal frequency of 'X' and 'Y'.
at least one 'X'.
 

Example 1:

Input: grid = [["X","Y","."],["Y",".","."]]

Output: 3

Explanation:



Example 2:

Input: grid = [["X","X"],["X","Y"]]

Output: 0

Explanation:

No submatrix has an equal frequency of 'X' and 'Y'.

Example 3:

Input: grid = [[".","."],[".","."]]

Output: 0

Explanation:

No submatrix has at least one 'X'.

 

Constraints:

1 <= grid.length, grid[i].length <= 1000
grid[i][j] is either 'X', 'Y', or '.'.
 
 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int m = sc.nextInt();
        System.out.println("Enter number of cols: ");
        int n = sc.nextInt();

        char arr[][] = new char[m][n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++)arr[i][j] = sc.next().charAt(0);
        }

        System.out.println(numberOfSubmatrices(arr));
        sc.close();
    }
    public static int numberOfSubmatrices(char[][] grid) {
        //similiar to 3070
        int m =grid.length;
        int n =grid[0].length;

        int x[][] = new int[m][n];
        int y[][] = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int xval = grid[i][j]=='X'?1:0;
                int yval = grid[i][j]=='Y'?1:0;

                int upX = (i-1>=0)?x[i-1][j]:0;
                int prevX = (j-1>=0)?x[i][j-1]:0;
                int diagX = (i-1>=0&&j-1>=0)?x[i-1][j-1]:0;

                x[i][j] = xval+upX+prevX-diagX;
                int upY = (i-1>=0)?y[i-1][j]:0;
                int prevY = (j-1>=0)?y[i][j-1]:0;
                int diagY = (i-1>=0&&j-1>=0)?y[i-1][j-1]:0;

                y[i][j] = yval+upY+prevY-diagY;

            }
        }

        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(x[i][j]==y[i][j]&&x[i][j]>0)ans++;
            }
        }
        return ans;
    }
}