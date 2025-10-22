/*Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 

Follow up: Could you use search pruning to make your solution faster with a larger board? */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int m = sc.nextInt();
        
        System.out.println("Enter number of columns: ");
        int n = sc.nextInt();
        

        char arr[][] = new char[m][n];
        System.out.println("Enter "+m*n+" elements: ");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)arr[i][j] = sc.next().charAt(0);
        } 
        System.out.println("Enter word to search: ");
        sc.nextLine();
        String word = sc.nextLine();
        System.out.println(exist(arr, word));
        sc.close();
    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int visited[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(generate(board, word,""+board[i][j], i, j, m, n, visited ))return true;
                }
            }
        }
        return false;

    }
    static boolean generate(char board[][], String word, String path, int i, int j, int m, int n, int visited[][]){
        if(path.equals(word))return true;

        if(path.length()>=word.length())return false;
        visited[i][j]=1;
        
        if(i+1<m&&visited[i+1][j]==0&&word.charAt(path.length())==board[i+1][j])if(generate(board, word, path+board[i+1][j], i+1,j,m, n,visited))return true;
        if(j+1<n&&visited[i][j+1]==0&&word.charAt(path.length())==board[i][j+1])if(generate(board, word, path+board[i][j+1], i,j+1,m, n,visited))return true;
        if(j-1>=0&&visited[i][j-1]==0&&word.charAt(path.length())==board[i][j-1])if(generate(board, word, path+board[i][j-1], i,j-1,m, n,visited))return true;
        if(i-1>=0&&visited[i-1][j]==0&&word.charAt(path.length())==board[i-1][j])if(generate(board, word, path+board[i-1][j], i-1,j,m, n,visited))return true;
        
        visited[i][j]=0;
        return false;

    }
}