/*You are given a 2D integer grid of size m x n and an integer x. In one operation, you can add x to or subtract x from any element in the grid.

A uni-value grid is a grid where all the elements of it are equal.

Return the minimum number of operations to make the grid uni-value. If it is not possible, return -1.

 

Example 1:


Input: grid = [[2,4],[6,8]], x = 2
Output: 4
Explanation: We can make every element equal to 4 by doing the following: 
- Add x to 2 once.
- Subtract x from 6 once.
- Subtract x from 8 twice.
A total of 4 operations were used.
Example 2:


Input: grid = [[1,5],[2,3]], x = 1
Output: 5
Explanation: We can make every element equal to 3.
Example 3:


Input: grid = [[1,2],[3,4]], x = 2
Output: -1
Explanation: It is impossible to make every element equal.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 105
1 <= m * n <= 105
1 <= x, grid[i][j] <= 104 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int m = sc.nextInt();
        System.out.println("Enter number of cols: ");
        int n = sc.nextInt();

        int arr[][] = new int[m][n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++)arr[i][j] = sc.nextInt();
        }

        System.out.println("Enter x: ");
        int x =sc.nextInt();

        System.out.println(minOperations(arr, x));
        sc.close();
    }
    public static int minOperations(int[][] grid, int x) {
        int m=grid.length;
        int n =grid[0].length;
        
        int size= m*n;
        int arr[]= new int[size];

        int idx=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)arr[idx++]=grid[i][j];
        }
        Arrays.sort(arr);
        int moves =0;
        
        int median = arr[size/2];
        int rem =arr[0]%x;
        for(int ele: arr)if(ele%x!=rem)return -1;
        for(int ele: arr)moves+=Math.abs(ele-median)/x;

        return moves;
    }
}