/*You are given an undirected graph with V vertices and E edges. The graph is represented as a 2D array edges[][], where each element edges[i] = [u, v] indicates an undirected edge between vertices u and v.
Your task is to return all the articulation points (or cut vertices) in the graph.
An articulation point is a vertex whose removal, along with all its connected edges, increases the number of connected components in the graph.

Note: The graph may be disconnected, i.e., it may consist of more than one connected component.
If no such point exists, return {-1}.

Examples :

Input: V = 5, edges[][] = [[0, 1], [1, 4], [4, 3], [4, 2], [2, 3]]

Output: [1, 4]
Explanation: Removing the vertex 1 or 4 will disconnects the graph as-
   
Input: V = 4, edges[][] = [[0, 1], [0, 2]]
Output: [0]
Explanation: Removing the vertex 0 will increase the number of disconnected components to 3.  
Constraints:
1 ≤ V, E ≤ 104


 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of node: ");
        int n = sc.nextInt();

        System.out.println("Enter numbe of edges: ");
        int m = sc.nextInt();
        
        int adj[][] = new int[m][2];
        for(int i=0;i<m;i++){
            System.out.println("Enter u: ");
            int u =sc.nextInt();
            System.out.println("Enter v: ");
            int v =sc.nextInt();

            adj[i][0]=u;
            adj[i][1]=v;
        }
        ArrayList<Integer>ans = articulationPoints(n, adj);

        for(int ele: ans)System.out.print(ele+" ");

        sc.close();
    }
    static int time =0;
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        // code here
        int disc[] = new int[V];
        int low[] = new int[V];
        boolean visited[] = new boolean[V];
        
        List<List<Integer>>adj = new ArrayList<>();
        
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        
        int n =edges.length;
        for(int i=0;i<n;i++){

            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        ArrayList<Integer>ans = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            if(!visited[i])dfs(i, -1, adj, visited, disc, low, ans);
        }
        
        if(ans.size()==0)ans.add(-1);
        Collections.sort(ans);
        return ans;
        
    }
    static void dfs(int node, int parent,List<List<Integer>>adj, boolean visited[], int disc[], int low[], ArrayList<Integer>ans){
        visited[node]=true;
        disc[node]=low[node]=time++;
        int children =0;
        for(int nbr: adj.get(node)){
            if(parent==nbr)continue;
            
            else if(visited[nbr])low[node] = Math.min(low[node], disc[nbr]);
            else{
                dfs(nbr, node, adj, visited, disc, low, ans);
                children++;
                low[node]=Math.min(low[node], low[nbr]);
                
                if(low[nbr]>=disc[node]&&parent!=-1&&!ans.contains(node))ans.add(node);
            }
            
        }
        if(children>1&&parent==-1&&!ans.contains(node))ans.add(node);
        
        
        
    }
}