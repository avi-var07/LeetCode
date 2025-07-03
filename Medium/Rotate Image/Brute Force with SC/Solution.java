import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of matrix: ");
        int n = sc.nextInt();
        System.out.println("Enter " + (n*n) + " elements:");
        int arr[][] = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j=0;j<n;j++)
            arr[i][j] = sc.nextInt();
        }

        int ans[][] = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
            ans[j][n-1-i]=arr[i][j];
        }
        

        System.out.println("After Rotating the Matrix by 90 degrees clockwise: ");

        for(int i=0;i<n;i++){
            for(int j = 0;j<n;j++)
            System.out.print(ans[i][j]+" ");

            System.out.println();
        }


        
        sc.close();
    }
}