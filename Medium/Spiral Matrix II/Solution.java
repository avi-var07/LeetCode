/*Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:

Input: n = 1
Output: [[1]]
 

Constraints:

1 <= n <= 20

 */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of matrix: ");
        int n = sc.nextInt();

        int ans[][]=generateMatrix(n);

        System.out.println("Spiral Matrix formed is: ");

        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++)
            System.out.print(ans[i][j]+" ");

            System.out.println();
        }
        
        sc.close();
    }

    public static int[][] generateMatrix(int n) {
        int top=0, left=0, right=n-1, bottom=n-1;
        int arr[][]=new int[n][n];

        int num=1;

        while(top<=bottom&&left<=right){
            for(int i=left;i<=right;i++)
            arr[top][i]=num++;

            top++;

            for(int i = top;i<=bottom;i++)
            arr[i][right]=num++;

            right--;


            if(top<=bottom){

                for(int i = right;i>=left;i--)
                arr[bottom][i]=num++;


                bottom--;
            }
             
            if(left<=right){

                for(int i=bottom;i>=top;i--)
                arr[i][left]=num++;

                left++;

            }

        }

        return arr;
    }
}