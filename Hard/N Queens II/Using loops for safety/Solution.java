/*The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 

Example 1:


Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 9 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Queens: ");
        int n = sc.nextInt();
        System.out.println("Total number of solutions: "+totalNQueens(n));

        
        sc.close();
    }
    public static int totalNQueens(int n) {
        char board[][] = new char[n][n];
        List<List<String>>ans = new ArrayList<>();

        for(int i=0;i<n;i++)Arrays.fill(board[i],'.');
        return solve(n,ans,board,0);

    }
    static int solve(int n, List<List<String>>ans, char board[][], int col){
        int count = 0;
        if(col==n)return 1;
        for(int row = 0;row<n;row++){
            if(isSafe(row,col,board,n)){
               
                board[row][col]='Q';
                count+=solve(n, ans, board, col+1);
                board[row][col]='.';
            }
        }
        return count;
    }
    static boolean isSafe(int row, int col, char board[][], int n){
        for(int j=0;j<col;j++)if(board[row][j]=='Q')return false;
        
        int i = row, j=col;
        while(i>=0&&j>=0){
            if(board[i][j]=='Q')return false;
            i--;
            j--;
        }
        while(row<n&&col>=0){
            if(board[row][col]=='Q')return false;
            row++;
            col--;

        }
        return true;

    }
}