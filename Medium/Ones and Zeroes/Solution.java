import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        String arr[] = new String[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.next();

        System.out.println("Enter number of zeroes: ");
        int m = sc.nextInt();
        System.out.println("Enter number of ones: ");
        int a = sc.nextInt();
        System.out.println(findMaxForm(arr, m, a));
        sc.close();
    }
    public static int findMaxForm(String[] strs, int m, int n) {
        Integer dp[][][] = new Integer[strs.length+1][m+1][n+1];
        return solve(strs, m,n, 0, dp);
    }
    static int solve(String arr[], int m, int n, int i,Integer dp[][][]){
        if(i==arr.length||(m==0&&n==0))return 0;

        if(dp[i][m][n]!=null)return dp[i][m][n];

        int notPick  = solve(arr, m, n, i+1,dp);

        int zeroes = 0, ones = 0;
        for(char ch: arr[i].toCharArray()){
            if(ch=='0')zeroes++;
            else ones++;
        }

        int pick = 0, result = 0;

        if(m>=zeroes&&n>=ones)pick = 1+solve(arr, m-zeroes, n-ones, i+1,dp);

        if(pick>notPick)result = pick;
        else result = notPick;

        dp[i][m][n] =result;

        return dp[i][m][n];
    }
}