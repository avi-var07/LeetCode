/*You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one outgoing edge.

The graph is represented with a given 0-indexed array edges of size n, indicating that there is a directed edge from node i to node edges[i]. If there is no outgoing edge from node i, then edges[i] == -1.

Return the length of the longest cycle in the graph. If no cycle exists, return -1.

A cycle is a path that starts and ends at the same node.

 

Example 1:


Input: edges = [3,3,4,2,3]
Output: 3
Explanation: The longest cycle in the graph is the cycle: 2 -> 4 -> 3 -> 2.
The length of this cycle is 3, so 3 is returned.
Example 2:


Input: edges = [2,-1,3,1]
Output: -1
Explanation: There are no cycles in this graph.
 

Constraints:

n == edges.length
2 <= n <= 105
-1 <= edges[i] < n
edges[i] != i */
import java.util.*;

class Solution{
    static int len;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of edges: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter edges: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println(longestCycle(arr));
        sc.close();
    }
    public static int longestCycle(int[] edges) {
        int V =  edges.length;
        boolean visited[] = new boolean[V];
        boolean path[] = new boolean[V];
        int level[] = new int[V];
        len=-1;
        for(int i=0;i<V;i++){
            if(!visited[i])dfs(i, visited, path, level, 0, edges);
        }

        return len;
    }
    static void dfs(int node, boolean visited[], boolean path[], int level[], int depth, int edges[]){
        visited[node]=true;
        path[node]=true;
        level[node]=depth;

        int next=edges[node];

        if(next!=-1){
            if(!visited[next])dfs(next, visited, path, level, depth+1, edges);
            else if(path[next]){
                int currentLen=level[node]-level[next]+1;
                len = Math.max(currentLen, len);
            }
        }
        path[node]=false;
    }
}