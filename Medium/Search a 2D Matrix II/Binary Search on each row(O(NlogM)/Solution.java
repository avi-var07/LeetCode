/*Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
 Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true
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
        System.out.println("Enter the target: ");
        int target = sc.nextInt();

        System.out.println(searchMatrix(arr, target));
        sc.close();
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            if(binarySearch(matrix[i], target))return true;
        }
        return false;
    }
    static boolean binarySearch(int arr[], int target){
        int low = 0, high = arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==target)return true;
            else if(arr[mid]<target)low=mid+1;
            else high = mid-1;
        }
        return false;
    }
}