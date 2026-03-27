/*You are given an m x n integer matrix mat and an integer k. The matrix rows are 0-indexed.

The following proccess happens k times:

Even-indexed rows (0, 2, 4, ...) are cyclically shifted to the left.


Odd-indexed rows (1, 3, 5, ...) are cyclically shifted to the right.


Return true if the final modified matrix after k steps is identical to the original matrix, and false otherwise.

 

Example 1:

Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 4

Output: false

Explanation:

In each step left shift is applied to rows 0 and 2 (even indices), and right shift to row 1 (odd index).



Example 2:

Input: mat = [[1,2,1,2],[5,5,5,5],[6,3,6,3]], k = 2

Output: true

Explanation:



Example 3:

Input: mat = [[2,2],[2,2]], k = 3

Output: true

Explanation:

As all the values are equal in the matrix, even after performing cyclic shifts the matrix will remain the same.

 

Constraints:

1 <= mat.length <= 25
1 <= mat[i].length <= 25
1 <= mat[i][j] <= 25
1 <= k <= 50 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter m: ");
        int m = sc.nextInt();
        System.out.println("Enter n: ");
        int n = sc.nextInt();

        int arr[][] = new int[m][n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++)arr[i][j] = sc.nextInt();
        }
        System.out.println("Enter k: ");
        int k =sc.nextInt();

        System.out.println(areSimilar(arr, k));
        sc.close();
    }
    public static boolean areSimilar(int[][] mat, int k) {
        int m =mat.length;
        int n =mat[0].length;
        k=k%n;
    //Brute Force
    //     int arr[][] = new int[m][n];
    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++)arr[i][j]=mat[i][j];
    //     }
    //     for(int i=0;i<m;i++){
    //         if(i%2==0)leftRotate(mat[i],k);
    //         else rightRotate(mat[i],k);
    //     }
    //     if(isSame(arr,mat))return true;
    //     return false;

    //Optimal:

    //Left rotate k baad index: (j+k)%n
    //right rotate k baad index: (j-k+n)%n

    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(i%2==0){
                if(mat[i][j]!=mat[i][(j+k)%n])return false;
            }
            else{
                if(mat[i][j]!=mat[i][(j-k+n)%n])return false;

            }
        }
    }
    return true;
    }
    // static void leftRotate(int arr[], int k){
    //     int n =arr.length;
    //     reversal(arr, 0, k-1);
    //     reversal(arr, k, n-1);
    //     reversal(arr, 0, n-1);
    // }
    // static void rightRotate(int arr[], int k){
    //     int n =arr.length;
    //     reversal(arr, 0, n-1);
    //     reversal(arr, 0, k-1);
    //     reversal(arr, k, n-1);
    // }
    // static void reversal(int arr[], int start, int end){
    //     while(start<end){
    //         int temp=arr[start];
    //         arr[start]=arr[end];
    //         arr[end]=temp;
    //         start++;
    //         end--;
    //     }
    // }
    // static boolean isSame(int arr[][], int mat[][]){
    //     for(int i=0;i<arr.length;i++){
    //         for(int j=0;j<mat[0].length;j++){
    //             if(arr[i][j]!=mat[i][j])return false;
    //         }
    //     }
    //     return true;
    // }

}