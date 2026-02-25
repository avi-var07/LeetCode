/*There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some servers unable to reach some other server.

Return all critical connections in the network in any order.

 

Example 1:


Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.
Example 2:

Input: n = 2, connections = [[0,1]]
Output: [[0,1]]
 

Constraints:

2 <= n <= 105
n - 1 <= connections.length <= 105
0 <= ai, bi <= n - 1
ai != bi
There are no repeated connections. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter number of edges: ");
        int m = sc.nextInt();

        List<List<Integer>>arr = new ArrayList<>();

        for(int i=0;i<m;i++){
            System.out.println("Enter u: ");
            int u = sc.nextInt();
            System.out.println("Enter v: ");
            int v = sc.nextInt();
            arr.add(Arrays.asList(u,v));
        }
        Solution sol = new Solution();
        List<List<Integer>>ans = sol.criticalConnections(n, arr);

        for(List<Integer>ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    int time=0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>>adj = new ArrayList<>();
        for(int i =0;i<n;i++)adj.add(new ArrayList<>());

        for(List<Integer>ele: connections){
            int u=ele.get(0);
            int v=ele.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean visited[] = new boolean[n];
        int disc[]= new int[n];
        int low[] = new int[n];

        List<List<Integer>>ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!visited[i])dfs(i, -1, visited, adj, disc, low, ans);
        }
        return ans;   
    }

    void dfs(int node, int parent, boolean visited[], List<List<Integer>>adj, int disc[], int low[], List<List<Integer>>ans){
        visited[node]=true;
        disc[node]=low[node]=time++;

        for(int nbr: adj.get(node)){
            if(parent==nbr)continue;

            else if(visited[nbr])low[node]=Math.min(low[node], disc[nbr]);
            else{
                dfs(nbr, node, visited, adj, disc, low, ans);
                low[node] = Math.min(low[node], low[nbr]); //backtrack k time
                if(low[nbr]>disc[node])ans.add(Arrays.asList(node, nbr));

            }
        }

    }
}