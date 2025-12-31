/*There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

 

Example 1:


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 

Constraints:

1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i] */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size: ");
        int n = sc.nextInt();

        int arr[][] = new int[n][];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)arr[i][j] = sc.nextInt();
        } 
        System.out.println(findCircleNum(arr));
        sc.close();
    }
    public static int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        boolean visited[] = new boolean[V];

        int count = 0;
       
        for(int i=0;i<V;i++){
            if(!visited[i]){
                count++;
                dfs(isConnected,visited, i);
            }
        }
        return count;
    }
    static void dfs(int arr[][],boolean visited[], int node){
        visited[node]=true;
        for(int i=0;i<arr.length;i++){
            if(!visited[i]&&arr[node][i]==1)dfs(arr, visited, i);
        }
    }
}