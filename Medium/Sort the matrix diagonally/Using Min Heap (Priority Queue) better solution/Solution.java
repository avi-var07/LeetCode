/*A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column and going in the bottom-right direction until reaching the matrix's end. For example, the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].

Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.
Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
Example 2:

Input: mat = [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,25,68,4],[84,28,14,11,5,50]]
Output: [[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66],[84,28,75,33,55,68]] */
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
        int ans[][] = diagonalSort(arr);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)System.out.print(ans[i][j]+" ");
            System.out.println();
        }
        sc.close();
    }
    public static int[][] diagonalSort(int[][] mat) {
        int n =mat.length, m = mat[0].length;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j = 0;j<m;j++){
                int key = i-j;
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(mat[i][j]);
            }
        }

        for(ArrayList<Integer> list: map.values())Collections.sort(list);

        for(int i = n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int key = i-j;
                ArrayList<Integer> list = map.get(key);
                mat[i][j]=list.remove(list.size()-1);
            }
        }
        return mat;
    }
}