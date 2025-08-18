/*You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

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
            for(int j = 0;j<m;j++)arr[i][j] = sc.nextInt();
        }

        System.out.println("Enter target to search: ");
        int target = sc.nextInt();

        System.out.println(searchMatrix(arr, target));
        sc.close();
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]<=target&&matrix[i][matrix[0].length-1]>=target)return binarySearch(matrix[i], target);
        }
        return false;
    }
    static boolean binarySearch(int arr[], int target){
        int low= 0, high = arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==target)return true;
            else if(arr[mid]>target)high=mid-1;
            else low=mid+1;
        }
        return false;
    }
}