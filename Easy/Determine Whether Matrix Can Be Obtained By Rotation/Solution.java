/*Given two n x n binary matrices mat and target, return true if it is possible to make mat equal to target by rotating mat in 90-degree increments, or false otherwise.
Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
Output: true
Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.

    Input: mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
Output: false
Explanation: It is impossible to make mat equal to target by rotating mat.

Input: mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
Output: true
Explanation: We can rotate mat 90 degrees clockwise two times to make mat equal target.
 

Constraints:

n == mat.length == target.length
n == mat[i].length == target[i].length
1 <= n <= 10
mat[i][j] and target[i][j] are either 0 or 1.

  */

  //Approach is maximum 4 times rotation possible( 0, 90, 180, 270). 360 is back to original. so we rotate 4 times until matches. else false;

  import java.util.*;
  
  class Solution {
      public static void main(String args[]) {
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter size of matrix: ");
          int n = sc.nextInt();
          System.out.println("Enter " + (n*n) + " elements:");
          int arr[][] = new int[n][n];
          for(int i = 0; i < n; i++){
            for(int j=0;j<n;j++)
            arr[i][j] = sc.nextInt();
          }
          System.out.println("Enter the target matrix elements: ");
          int target[][] = new int[n][n];
          for(int i = 0; i < n; i++){
            for(int j=0;j<n;j++)
            target[i][j] = sc.nextInt();
          }

          System.out.println(findRotation(arr, target));

          
          sc.close();
      }

        public static boolean findRotation(int[][] mat, int[][] target) {
        for(int i=0;i<4;i++){
            if(isSame(mat, target))return true;
            mat = rotate(mat);
        }

        return false;
    }
    static int[][] rotate(int arr[][]){
        int n = arr.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp = arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }

        for(int i=0;i<n;i++){
            int left = 0, right = n-1;

            while(left<right){

                int temp = arr[i][left];
                arr[i][left]=arr[i][right];
                arr[i][right]=temp;
                left++;
                right--;

            }
        }
        return arr;
    }
    static boolean isSame(int arr[][], int target[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++)
            if(arr[i][j]!=target[i][j])return false;
        }

        return true;
    }
  }