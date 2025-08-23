import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.println("Enter number of columns: ");
        int m= sc.nextInt();
        System.out.println("Enter " + n*m+ " elements:");
        int arr[][] = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j=0;j<m;j++)arr[i][j] = sc.nextInt();
        }
        System.out.println(checkXMatrix(arr));
        sc.close();
    }
    public static boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j||i+j==n-1){
                    if(grid[i][j]==0)return false;
                }
                else {
                    if(grid[i][j]!=0)return false;
                }
            }
        }
        return true;
    }
}