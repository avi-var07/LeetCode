/*There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

 

Example 1:

Illustration of graph
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Explanation: The given graph is shown above.
Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
Example 2:

Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
Output: [4]
Explanation:
Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.
 

Constraints:

n == graph.length
1 <= n <= 104
0 <= graph[i].length <= n
0 <= graph[i][j] <= n - 1
graph[i] is sorted in a strictly increasing order.
The graph may contain self-loops.
The number of edges in the graph will be in the range [1, 4 * 104]. */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[][] = new int[n][n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) {
            for(int j= 0;j<n;j++)arr[i][j] = sc.nextInt();
        }
        List<Integer>ans = eventualSafeNodes(arr);

        for(int ele: ans)System.out.print(ele+" ");

        sc.close();
    }
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        boolean visited[] = new boolean[V];
        boolean path[] = new boolean[V];
        boolean safe[] = new boolean[V];
        List<Integer>ans = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(!visited[i])dfs(i, visited, path, graph,safe);
            
        }
        for(int i=0;i<V;i++)if(safe[i])ans.add(i);
        return ans;
    }
    static boolean dfs(int node, boolean visited[], boolean path[], int graph[][], boolean safe[]){
        visited[node]=true;
        path[node]=true;

        for(int ele: graph[node]){
            if(!visited[ele]){
                if(dfs(ele, visited, path, graph, safe))return true;
            }
            else if(path[ele])return true;
        }
        path[node]=false;
        safe[node]=true;
        return false;
    }
}