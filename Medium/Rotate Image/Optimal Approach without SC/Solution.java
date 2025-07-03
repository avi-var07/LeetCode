/*You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
*/


//Approach is simple just traverse and then reverse each row!!
import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of matrix: ");
        int n = sc.nextInt();
        System.out.println("Enter " + (n*n) + " elements:");
        int arr[][] = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j=0;j<n;j++)
            arr[i][j] = sc.nextInt();
        }

        rotate(arr);

        System.out.println("After Rotating the Matrix by 90 degrees clockwise: ");

        for(int i=0;i<n;i++){
            for(int j = 0;j<n;j++)
            System.out.print(arr[i][j]+" ");

            System.out.println();
        }


        
        sc.close();
    }
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }   //Now the matrix is tranposed

        for(int i=0;i<n;i++){
            int left = 0, right = n-1;
            while(left<right){
                int temp = matrix[i][left];
                matrix[i][left]=matrix[i][right];
                matrix[i][right]=temp;
                left++;
                right--;
            }
        }   //reversing each row using two pointers.

        /*Another Reversal Approach: 
         

        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp = arr[i][j];
                arr[i][j]=arr[i][n-1-j];
                arr[n-1-j]=temp;
            }
        }
         */
    }
}