/*You are given an m x n matrix grid of positive integers. Your task is to determine if it is possible to make either one horizontal or one vertical cut on the grid such that:

Each of the two resulting sections formed by the cut is non-empty.
The sum of the elements in both sections is equal.
Return true if such a partition exists; otherwise return false.

 

Example 1:

Input: grid = [[1,4],[2,3]]

Output: true

Explanation:



A horizontal cut between row 0 and row 1 results in two non-empty sections, each with a sum of 5. Thus, the answer is true.

Example 2:

Input: grid = [[1,3],[2,4]]

Output: false

Explanation:

No horizontal or vertical cut results in two non-empty sections with equal sums. Thus, the answer is false.

 

Constraints:

1 <= m == grid.length <= 105
1 <= n == grid[i].length <= 105
2 <= m * n <= 105
1 <= grid[i][j] <= 105 */
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
        
        System.out.println(canPartitionGrid(arr));
        
        sc.close();
    }
    public static boolean canPartitionGrid(int[][] grid) {
        int m =grid.length;
        int n =grid[0].length;
        long total =0;
        long row[] = new long[m]; //rowsum
        long col[] = new long[n];   //colSum
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                total+=grid[i][j];
                row[i]+=grid[i][j];
                col[j]+=grid[i][j];
            }
        }
        if(total%2==1)return false; //split nhi hopayega equal halves mei to kaise hi possible hoga?

        //horizontal cut:
       long upper=0;
        for(int i=0;i<=m-2;i++){
            upper += row[i];
            if(total-upper==upper)return true;
        }
        //vertical sum
        long left=0;
        for(int i=0;i<=n-2;i++){
            left += col[i];
            if(total-left==left)return true;
        }
        return false;
    }
}