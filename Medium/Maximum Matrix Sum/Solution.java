/*You are given an n x n integer matrix. You can do the following operation any number of times:

Choose any two adjacent elements of matrix and multiply each of them by -1.
Two elements are considered adjacent if and only if they share a border.

Your goal is to maximize the summation of the matrix's elements. Return the maximum sum of the matrix's elements using the operation mentioned above.

 

Example 1:


Input: matrix = [[1,-1],[-1,1]]
Output: 4
Explanation: We can follow the following steps to reach sum equals 4:
- Multiply the 2 elements in the first row by -1.
- Multiply the 2 elements in the first column by -1.
Example 2:


Input: matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]
Output: 16
Explanation: We can follow the following step to reach sum equals 16:
- Multiply the 2 last elements in the second row by -1.
 

Constraints:

n == matrix.length == matrix[i].length
2 <= n <= 250
-105 <= matrix[i][j] <= 105
 
 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter matrix size: ");
        int n = sc.nextInt();

        int arr[][] = new int[n][n];
        System.out.println("Enter "+n*n+" elements: ");
        for(int i=0;i<n;i++) {
            for(int j = 0;j<n;j++)arr[i][j] = sc.nextInt();
        }
        System.out.println(maxMatrixSum(arr));
        sc.close();
    }
    public static long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int mini = Integer.MAX_VALUE;
        long totalSum = 0;
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]<0){
                    count++;
                    totalSum+=(-1*matrix[i][j]);
                    mini=Math.min(mini, (-1* matrix[i][j]));
                }
                else{ 
                    totalSum+=matrix[i][j];
                
                    mini=Math.min(mini, matrix[i][j]);
                }
            }
        }
        if(count%2==0)return totalSum;
        
        return totalSum- (2L*mini);

    }
}