/*You are given two integers m and n, representing the number of rows and columns of a grid.

Construct any m x n grid consisting only of the characters '.' and '#', where:

'.' represents a free cell.
'#' represents an obstacle cell.
A valid path is a sequence of free cells that:

Starts at the top-left cell (0, 0).
Ends at the bottom-right cell (m - 1, n - 1).
Moves only:
Right, from (i, j) to (i, j + 1), or
Down, from (i, j) to (i + 1, j).
Return any grid such that there is exactly one valid path from the top-left cell to the bottom-right cell.

 

Example 1:

Input: m = 2, n = 3

Output: ["..#","#.."]

Explanation:



The only valid path is: (0,0) → (0,1) → (1,1) → (1,2)

Example 2:

Input: m = 3, n = 3

Output: ["..#","#..","##."]

Explanation:



The only valid path is: (0,0) → (0,1) → (1,1) → (1,2) → (2,2)

Example 3:

Input: m = 1, n = 4

Output: ["...."]

Explanation:

The only valid path is: (0,0) → (0,1) → (0,2) → (0,3)

 

Constraints:

1 <= m, n <= 25 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int m= sc.nextInt();
        System.out.println("Enter number of cols: ");
        int n = sc.nextInt();

        String ans[] = createGrid(m, n);
        for(String ele: ans)System.out.println(ele+" ");        

        sc.close();
    }
    public static String[] createGrid(int m, int n) {

        //brute:
        // String mat[][] = new String[m][n];
        
        // for(int i=0;i<n;i++)mat[0][i]=".";
        // for(int i=0;i<m;i++)mat[i][n-1]=".";

        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++)if(mat[i][j]==null)mat[i][j]="#";
        // }
        // String ans[]=  new String[m];
        // for(int i=0;i<m;i++){
        //     StringBuilder sb = new StringBuilder();

        //     for(int j=0;j<n;j++)sb.append(mat[i][j]);

        //     ans[i]=sb.toString();
        // }
        
        // return ans;

        //optimal:

        String ans[] = new String[m];
        for(int i=0;i<m;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                if(i==0||j==n-1)sb.append(".");
                else sb.append("#");
            }

            ans[i]=sb.toString();
        }
        return ans;
    }
}