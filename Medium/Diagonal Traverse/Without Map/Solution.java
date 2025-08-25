/*Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,4,7,5,3,6,8,9]
Example 2:

Input: mat = [[1,2],[3,4]]
Output: [1,2,3,4]
 
 */
import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.println("Enter number of columns: ");
        int m= sc.nextInt();
        System.out.println("Enter " + n*m + " elements:");
        int arr[][]= new int[n][m];
        for(int i = 0; i < n; i++) 
        {
            for(int j=0;j<m;j++)arr[i][j] = sc.nextInt();
        }
        int ans[] = findDiagonalOrder(arr);
        for(int ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    public static int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int total = n+m-1;
        int result[] = new int[n*m];
        int index = 0;
        boolean flip = true;

        for(int i = 0;i<total;i++){
            int row = (i<m)?0:i-m+1;
            int col = (i<m)?i:m-1;
            List<Integer> temp = new ArrayList<>();
            while(row<n&&col>=0){
                temp.add(mat[row][col]);
                row++;
                col--;
            }
            if(flip)Collections.reverse(temp);

            for(int ele: temp)result[index++]=ele;
            flip=!flip;
        }
        return result;
    }
}