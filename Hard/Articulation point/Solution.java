/*Given an undirected connected graph with V vertices and adjacency list adj. You are required to find all the vertices removing which (and edges through it) disconnects the graph into 2 or more components and return it in sorted manner.
Note: Indexing is zero-based i.e nodes numbering from (0 to V-1). There might be loops present in the graph.

Example 1:

Input:

Output:{1,4}
Explanation: Removing the vertex 1 will
discconect the graph as-

Removing the vertex 4 will disconnect the
graph as-

 

Your Task:
You don't need to read or print anything. Your task is to complete the function articulationPoints() which takes V and adj as input parameters and returns a list containing all the vertices removing which turn the graph into two or more disconnected components in sorted order. If there are no such vertices then returns a list containing -1.
 

Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)
 

Constraints:
1 ≤ V ≤ 105

 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of node: ");
        int n = sc.nextInt();

        System.out.println("Enter size of adj list: ");
        int m = sc.nextInt();
        
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            System.out.println("Enter u: ");
            int u =sc.nextInt();
            System.out.println("Enter v: ");
            int v =sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Solution sol = new Solution();
        ArrayList<Integer>ans = sol.articulationPoints(n, adj);

        for(int ele: ans)System.out.print(ele+" ");

        sc.close();
    }
    int time = 0;
    public ArrayList<Integer> articulationPoints(int V,
                                                 ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean visited[] = new boolean[V];
        int disc[] = new int[V];
        int low[] = new int[V];
        ArrayList<Integer>ans = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(!visited[i])dfs(i, -1, visited, disc, low, ans, adj);
        }
        Collections.sort(ans);
        if(ans.size()==0)ans.add(-1);
        return ans;
    }
    void dfs(int node, int parent, boolean visited[], int disc[], int low[], ArrayList<Integer>ans, ArrayList<ArrayList<Integer>>adj){
        visited[node]=true;
        disc[node]=low[node]=time++;
        int children = 0; //center k liye fail krega: check lagayenge ki no of children root k >2 hai ky?
        for(int nbr: adj.get(node)){
            if(parent==nbr)continue;
            
            if(visited[nbr])low[node]=Math.min(low[node], disc[nbr]);
            
            else{
                children++;
                dfs(nbr, node, visited, disc, low, ans, adj);
                low[node]=Math.min(low[nbr], low[node]);
                if(low[nbr]>=disc[node]&&parent!=-1&&!ans.contains(node))ans.add(node);
            }
        }
        if(parent==-1&&children>1&&!ans.contains(node))ans.add(node);
    }
}