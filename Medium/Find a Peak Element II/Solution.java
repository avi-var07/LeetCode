/*
A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.

Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].

You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.
Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
Output: [1,1]
Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 500
1 <= mat[i][j] <= 105
No two adjacent cells are equal. */
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
            for(int j = 0;j<m;j++)
            arr[i][j] = sc.nextInt();
        }

        int ans[] = findPeakGrid(arr);
        System.out.println("Peak element is at Index: "+ans[0]+","+ans[1]);
        sc.close();
    }

    public static int[] findPeakGrid(int[][] mat) {
        int ans[] = {-1, -1};
        int low = 0, high = mat[0].length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int maxInd = findMaxi(mat, mat.length, mat[0].length, mid);
            int left = (mid-1>=0)?mat[maxInd][mid-1]:-1;
            int right = (mid+1<=mat[0].length-1)?mat[maxInd][mid+1]:-1;

            if(mat[maxInd][mid]>left&&mat[maxInd][mid]>right){
                ans[0]=maxInd;
                ans[1]=mid;
                break;
            }
            else if(mat[maxInd][mid]>left)low=mid+1;
            else high=mid-1;
        }
        return ans;
    }
    static int findMaxi(int arr[][], int n, int m, int col){
        int maxi = -1, ind= -1;
        for(int i=0;i<n;i++){
            if(arr[i][col]>maxi){
                maxi=arr[i][col];
                ind = i;
            }
        }
        return ind;
    }
}