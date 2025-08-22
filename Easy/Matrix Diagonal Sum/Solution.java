/*Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.

  */
import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.println("Enter number of columns: ");
        int m = sc.nextInt();
        System.out.println("Enter " + n*m + " elements:");
        int arr[][] = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j=0;j<m;j++)arr[i][j] = sc.nextInt();
        }
        System.out.println("Diagonal sum is: "+diagonalSum(arr));
        sc.close();
    }
    public static int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=mat[i][i];
            if(i!=n-1-i)sum+=mat[i][n-1-i];
        }
        

        return sum;
    }
}