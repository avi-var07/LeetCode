/*You are given an m x n integer matrix grid​​​, where m and n are both even integers, and an integer k.

The matrix is composed of several layers, which is shown in the below image, where each color is its own layer:



A cyclic rotation of the matrix is done by cyclically rotating each layer in the matrix. To cyclically rotate a layer once, each element in the layer will take the place of the adjacent element in the counter-clockwise direction. An example rotation is shown below:


Return the matrix after applying k cyclic rotations to it.

 

Example 1:


Input: grid = [[40,10],[30,20]], k = 1
Output: [[10,20],[40,30]]
Explanation: The figures above represent the grid at every state.
Example 2:


Input: grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], k = 2
Output: [[3,4,8,12],[2,11,10,16],[1,7,6,15],[5,9,13,14]]
Explanation: The figures above represent the grid at every state.
 

Constraints:

m == grid.length
n == grid[i].length
2 <= m, n <= 50
Both m and n are even integers.
1 <= grid[i][j] <= 5000
1 <= k <= 109 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int m= sc.nextInt();
        
        System.out.println("Enter number of cols: ");
        int n= sc.nextInt();

        int arr[][] = new int[m][n];
        System.out.println("Enter "+m*n+" elements: ");
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++)arr[i][j] = sc.nextInt();
        }
        System.out.println("Enter k: ");
        int k =sc.nextInt();
        int ans[][] = rotateGrid(arr, k);

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)System.out.print(ans[i][j]+" ");

            System.out.println();
        }
        sc.close();
    }
    public static int[][] rotateGrid(int[][] grid, int k) {
        int m =grid.length;
        int n =grid[0].length;

        int layers = Math.min(m, n)/2;

        for(int i=0;i<layers;i++){ 
            List<Integer>elements = new ArrayList<>();

            int top = i;
            int left =i;
            int down = m-i-1;
            int right = n-i-1;

            //top:

            for(int j=left;j<=right;j++)elements.add(grid[top][j]);

            //right:
            //corner wala cover hogya, to top+1 se start hoga: down+1 bhi hum left jaane mei cover krdenge
            for(int j=top+1;j<=down-1;j++)elements.add(grid[j][right]);

            //down:

            for(int j=right;j>=left;j--)elements.add(grid[down][j]);

            //left:

            for(int j=down-1;j>=top+1;j--)elements.add(grid[j][left]);

            int len =elements.size();

            int rot =k%len;
            rotate(elements, rot, len);
            int idx=0;

            for(int j=left;j<=right;j++)grid[top][j]=elements.get(idx++);
            for(int j=top+1;j<=down-1;j++)grid[j][right]=elements.get(idx++);
            for(int j=right;j>=left;j--)grid[down][j]=elements.get(idx++);
            for(int j=down-1;j>=top+1;j--)grid[j][left]=elements.get(idx++);


        }
        return grid;
    }
    static void rotate(List<Integer>arr, int k, int n){
        reversal(arr, 0, k-1);
        reversal(arr, k, n-1);
        reversal(arr, 0, n-1);
    }
    static void reversal(List<Integer>arr, int start, int end){
        while(start<end){
            int temp =arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            start++;
            end--;
        }
    }
}