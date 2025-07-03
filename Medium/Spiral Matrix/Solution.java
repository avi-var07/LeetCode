/*Given an m x n matrix, return all elements of the matrix in spiral order.
 * 
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100

 */
//To  move in spiral order the path is: Right-Bottom-Left-Top. 
import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.println("Enter number of columns: ");
        int m = sc.nextInt();
        System.out.println("Enter " + (n*m) + " elements:");
        int arr[][] = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j=0;j<m;j++)arr[i][j] = sc.nextInt();
        }
        
        List<Integer> ans = spiralOrder(arr);

        for(int ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int n=matrix.length, m = matrix[0].length;

        int top=0, left=0, bottom = n-1, right=m-1;

        while(left<=right&&top<=bottom){
            for(int i=left;i<=right;i++)ans.add(matrix[top][i]);    //Right, (left to right), columns change but row fixed which is the top. So top++;

            top++;

            for(int i=top;i<=bottom;i++)ans.add(matrix[i][right]);  //Bottom, (Top to Bottom), rows changes, column remains fixed which is the right. So right--;
        
            right--;
            if(top<=bottom){    //Check for top to bottom
                for(int i=right;i>=left;i--)ans.add(matrix[bottom][i]); //Left, (Right to Left), column change but row fixed which is bottom. So bottom--;

                bottom--;
            }

            if(left<=right){    //Check for left to right;
                for(int i=bottom;i>=top;i--)ans.add(matrix[i][left]);   //Top, (Bottom to Top), row changes but column remains fixed which is the left. So left++;

                left++;
            }
        }

        return ans;
    }
}