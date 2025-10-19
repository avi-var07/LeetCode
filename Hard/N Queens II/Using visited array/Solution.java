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
        System.out.println("Total Possible ways are: "+totalNQueens(n));
        sc.close();
    }
    public static int totalNQueens(int n) {
        char board[][] = new char[n][n];
        for(int i=0;i<n;i++)Arrays.fill(board[i],'.');
        int leftRow[] = new int[n];
        int lowerDiagonal[] = new int[2*n-1];
        int upperDiagonal[] = new int[2*n-1];
        return solve(n,board,lowerDiagonal,upperDiagonal,leftRow, 0);
    }
    static int solve(int n, char board[][], int lowerDiagonal[], int upperDiagonal[], int leftRow[], int col){
        int count = 0;
        if(col==n)return 1;
        
        for(int row = 0;row<n;row++){
            if(leftRow[row]==0&&lowerDiagonal[row+col]==0&&upperDiagonal[n-1+col-row]==0){
                board[row][col]='Q';
                leftRow[row]=1;
                lowerDiagonal[row+col]=1;
                upperDiagonal[n-1+col-row]=1;
                count+=solve(n,board,lowerDiagonal,upperDiagonal,leftRow,col+1);
                board[row][col]='.';
                leftRow[row]=0;
                lowerDiagonal[row+col]=0;
                upperDiagonal[n-1+col-row]=0;
            }
        }
        return count;

    }
}