import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of row: ");
        int m = sc.nextInt();
        System.out.println("Enter number of col: ");
        int n = sc.nextInt();

        char arr[][] = new char[m][n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++)arr[i][j] = sc.next().charAt(0);
        }

        solve(arr);
        sc.close();
    }
    public static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        //first row and last row:       

        boolean visited[][] = new boolean[m][n];
        for(int i=0;i<n;i++){
            if(!visited[0][i]&&board[0][i]=='O')dfs(0,i, visited, board, m,n);
            if(!visited[m-1][i]&&board[m-1][i]=='O')dfs(m-1,i,visited, board, m,n);
        }

        for(int i=0;i<m;i++){
            if(!visited[i][0]&&board[i][0]=='O')dfs(i,0,visited,board,m,n);
            if(!visited[i][n-1]&&board[i][n-1]=='O')dfs(i,n-1,visited,board,m,n);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]&&board[i][j]=='O')board[i][j]='X';
            }
        }
    }
    static void dfs(int row, int col, boolean visited[][], char arr[][], int m, int n){
        visited[row][col]=true;
        int drow[] = {-1,1,0,0};
        int dcol[] = {0,0,1,-1};
        for(int i=0;i<4;i++){
            int nrow = row+drow[i];
            int ncol = col+dcol[i];

            if(nrow>=0&&ncol>=0&&nrow<m&&ncol<n&&!visited[nrow][ncol]&&arr[nrow][ncol]=='O')dfs(nrow,ncol,visited,arr,m,n);
        }
    }
}