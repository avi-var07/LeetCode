/*Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = [["0"]]
Output: 0
Example 3:

Input: matrix = [["1"]]
Output: 1
 

Constraints:

rows == matrix.length
cols == matrix[i].length
1 <= rows, cols <= 200
matrix[i][j] is '0' or '1'. */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.println("Enter number of columns: ");
        int m = sc.nextInt();
        char arr[][] = new char[n][m];
        System.out.println("Enter "+n*m+" elements: ");
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++)arr[i][j] = sc.next().charAt(0);
        }

        System.out.println(maximalRectangle(arr));
        sc.close();
    }
    public static int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int pSum[][] = new int[n][m];
        for(int j=0;j<m;j++){
            int sum = 0;
            for(int i = 0;i<n;i++){
                if(matrix[i][j]=='1')sum++;
                else sum=0;

                pSum[i][j]=sum;
            }
        }
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)maxi = Math.max(maxi, cal(pSum[i]));

        return maxi;
    }

    static int cal(int arr[]){
        int n = arr.length;
        Stack<Integer>st = new Stack<>();
        int maxi = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            while(!st.isEmpty()&&arr[st.peek()]>arr[i]){
                int eleInd = st.pop();
                int nse = i;
                int pse = st.isEmpty()?-1:st.peek();
                maxi = Math.max(maxi, arr[eleInd]*(nse-pse-1));

            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int nse = n;
            int eleInd = st.pop();
            int pse = st.isEmpty()?-1:st.peek();
            maxi = Math.max(maxi, arr[eleInd]*(nse-pse-1));
        }
        return maxi;
    }
}