/*The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
 

Constraints:

1 <= n <= 9 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of queens: ");
        int n = sc.nextInt();

        List<List<String>>result = solveNQueens(n);
        for(var ele: result)System.out.print(ele+" ");

        sc.close();
    }
    public static List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        List<List<String>>ans = new ArrayList<>();

        for(int i=0;i<n;i++)Arrays.fill(board[i],'.');
        solve(n,ans,board,0);
        return ans;

    }
    static void solve(int n, List<List<String>>ans, char board[][], int col){

        if(col==n){
            List<String>solution = new ArrayList<>();
            for(int i=0;i<n;i++)solution.add(new String(board[i]));

            ans.add(solution);
            return;
        }
        for(int row = 0;row<n;row++){
            if(isSafe(row,col,board,n)){
               
                board[row][col]='Q';
                solve(n, ans, board, col+1);
                board[row][col]='.';
            }
        }
    }
    static boolean isSafe(int row, int col, char board[][], int n){
        for(int j=0;j<col;j++)if(board[row][j]=='Q')return false;
        //leftUpper:-
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