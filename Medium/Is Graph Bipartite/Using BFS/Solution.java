/*There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:

There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.

 

Example 1:


Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
Output: false
Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.
Example 2:


Input: graph = [[1,3],[0,2],[1,3],[0,2]]
Output: true
Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
 

Constraints:

graph.length == n
1 <= n <= 100
0 <= graph[u].length < n
0 <= graph[u][i] <= n - 1
graph[u] does not contain u.
All the values of graph[u] are unique.
If graph[u] contains v, then graph[v] contains u.
 
 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of nodes:");
        int n = sc.nextInt();

        int[][] graph = new int[n][];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter number of neighbours of node " + i + ":");
            int k = sc.nextInt();

            graph[i] = new int[k];
            System.out.println("Enter neighbours of node " + i + ":");
            for (int j = 0; j < k; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.println(isBipartite(graph));
        sc.close();
    }
    public static boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int visited[] = new int[V];

        int color1 = 1, color2 = 2;
        Queue<Integer>queue = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                queue.add(i);
                visited[i]=color1;
                while(!queue.isEmpty()){
                    int node = queue.poll();

                    int color = visited[node];

                    for(int v: graph[node]){
                        if(visited[v]==0){
                            queue.add(v);
                            if(color==color1)visited[v]=color2;
                            else visited[v] = color1;
                        }
                        else{
                            int visitedColor = visited[v];
                            if(color==visitedColor)return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}