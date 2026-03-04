/*Given an m x n binary matrix mat, return the number of special positions in mat.

A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).

 

Example 1:


Input: mat = [[1,0,0],[0,0,1],[1,0,0]]
Output: 1
Explanation: (1, 2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.
Example 2:


Input: mat = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
Explanation: (0, 0), (1, 1) and (2, 2) are special positions.
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 100
mat[i][j] is either 0 or 1. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int m = sc.nextInt();
        System.out.println("Enter number of cols: ");
        int n= sc.nextInt();

        int arr[][] = new int[m][n];
        System.out.println("Enter "+m*n+" elements: ");
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++)arr[i][j] = sc.nextInt();
        }
        System.out.println(numSpecial(arr));
        sc.close();
    }
    public static int numSpecial(int[][] mat) {
        int m =mat.length;
        int n = mat[0].length;
        
        int count =0;
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(mat[i][j]==1){
        //             if(checkRow(mat, i, j, m, n)&&checkCol(mat, i, j, m, n))count++;
        //         }
        //     }
        // }
        int rowCount[] = new int[m];
        int colCount[] = new int[n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    if(rowCount[i]==1&&colCount[j]==1)count++;
                }
            }
        }
        return count;
    }
    // static boolean checkRow(int arr[][], int row, int col, int m, int n){
    //     for(int i=0;i<n;i++){
    //         if(i==col)continue;
    //         else if(arr[row][i]==1)return false;
    //     }
    //     return true;
    // }
    // static boolean checkCol(int arr[][], int row, int col, int m, int n){
    //     for(int i=0;i<m;i++){
    //         if(i==row)continue;
    //         else if(arr[i][col]==1)return false;
    //     }
    //     return true;
    // }
}