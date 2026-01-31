/*Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).

 

Example 1:


Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Example 2:


Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 

Constraints:

n == graph.length
2 <= n <= 15
0 <= graph[i][j] < n
graph[i][j] != i (i.e., there will be no self-loops).
All the elements of graph[i] are unique.
The input graph is guaranteed to be a DAG. */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter number of neighbours of node " + i + ": ");
            int m = sc.nextInt();

            graph[i] = new int[m];
            System.out.print("Enter neighbours: ");
            for (int j = 0; j < m; j++) graph[i][j] = sc.nextInt();
        }

        List<List<Integer>> result = allPathsSourceTarget(graph);

        System.out.println("All paths from 0 to " + (n - 1) + ":");
        for(List<Integer>ele: result)System.out.print(ele+" ");
        sc.close();
    }
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer>path = new ArrayList<>();

        dfs(0,graph, path, ans, graph.length-1);
        return ans;
    }
    static void dfs(int node, int graph[][], List<Integer>path,List<List<Integer>>ans, int target){
        path.add(node);

        if(node==target)ans.add(new ArrayList<>(path));

        else {
            for(int ele: graph[node])dfs(ele, graph, path, ans, target);
        }

        path.remove(path.size()-1);
    }
}