/* You are given an n x n square matrix of integers grid. Return the matrix such that:

The diagonals in the bottom-left triangle (including the middle diagonal) are sorted in non-increasing order.
The diagonals in the top-right triangle are sorted in non-decreasing order.
 

Example 1:

Input: grid = [[1,7,3],[9,8,2],[4,5,6]]

Output: [[8,2,3],[9,6,7],[4,5,1]]*/
import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of matrix: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n*n + " elements:");
        int arr[][] = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j=0;j<n;j++)arr[i][j] = sc.nextInt();
        }

        int ans[][]=sortMatrix(arr);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)System.out.println(ans[i][j]+" ");

            System.out.println();
        }
        sc.close();
    }
    public static int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        Map<Integer, ArrayList<Integer>> map  = new HashMap<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int key = i-j;
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(grid[i][j]);
            }
        }

        for(int key: map.keySet()){
            List<Integer> diag = map.get(key);
            if(key>=0)diag.sort(Collections.reverseOrder());
            else Collections.sort(diag);
        }

        for(int i = n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int key = i-j;
                ArrayList<Integer> list = map.get(key);
                grid[i][j]=list.remove(list.size()-1);
            }
        }
        return grid;
    }
}