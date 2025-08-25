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
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int key = i+j;
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(mat[i][j]);
            }
        }
        List<Integer> ans = new ArrayList<>();

        boolean flip = true;
        int total = n+m-1;
        for(int i=0;i<total;i++){
            List<Integer> diag = map.get(i);
            if (flip)Collections.reverse(diag); 
            
            ans.addAll(diag);
            flip=!flip;
        }

        int result[] = new int[ans.size()];

        for(int i=0;i<ans.size();i++)
        result[i]= ans.get(i);


        return result;
    }
}