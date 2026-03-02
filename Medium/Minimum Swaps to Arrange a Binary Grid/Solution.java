/*Given an n x n binary grid, in one step you can choose two adjacent rows of the grid and swap them.

A grid is said to be valid if all the cells above the main diagonal are zeros.

Return the minimum number of steps needed to make the grid valid, or -1 if the grid cannot be valid.

The main diagonal of a grid is the diagonal that starts at cell (1, 1) and ends at cell (n, n).

 

Example 1:


Input: grid = [[0,0,1],[1,1,0],[1,0,0]]
Output: 3
Example 2:


Input: grid = [[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,1,1,0]]
Output: -1
Explanation: All rows are similar, swaps have no effect on the grid.
Example 3:


Input: grid = [[1,0,0],[1,1,0],[1,1,1]]
Output: 0
 

Constraints:

n == grid.length == grid[i].length
1 <= n <= 200
grid[i][j] is either 0 or 1 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();

        int arr[][] = new int[n][n];
        System.out.println("Enter "+n*n+" elements: ");
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++)arr[i][j] = sc.nextInt();
        }
        System.out.println(minSwaps(arr));
        sc.close();
    }
    public static int minSwaps(int[][] grid) {
        int n = grid.length;
        int endZeroes[] =new int[n]; //har row ka trailing zeroes store krenge
        for(int i=0;i<n;i++){
            int j=n-1;
            int count=0;
            while(j>=0&&grid[i][j]==0){
                count++;
                j--;
            }
            endZeroes[i]=count;
        }
        int swaps=0;
        for(int i=0;i<n;i++){
            int need = n-i-1; //har row ka need nikalenge
            int j=i;
            while(j<n&&endZeroes[j]<need)j++; //jaise hi need poori hui usse swap krdenge
            
            if(j==n)return -1; //impossible need satisfy hi nhi kr paari
            swaps+=j-i; //no of swaps

            //ab swap endZeroes mei reflect bhi to krna pdega:

            //bubble sort logic:
            while(j>i){
                int temp =endZeroes[j];
                endZeroes[j]=endZeroes[j-1];
                endZeroes[j-1]=temp;
                j--;
            }
        }
        return swaps;
    }
}