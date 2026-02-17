/*You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting vertices ai and bi.

Return the number of complete connected components of the graph.

A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.

A connected component is said to be complete if there exists an edge between every pair of its vertices.

 

Example 1:



Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
Output: 3
Explanation: From the picture above, one can see that all of the components of this graph are complete.
Example 2:



Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4],[3,5]]
Output: 1
Explanation: The component containing vertices 0, 1, and 2 is complete since there is an edge between every pair of two vertices. On the other hand, the component containing vertices 3, 4, and 5 is not complete since there is no edge between vertices 4 and 5. Thus, the number of complete components in this graph is 1.
 

Constraints:

1 <= n <= 50
0 <= edges.length <= n * (n - 1) / 2
edges[i].length == 2
0 <= ai, bi <= n - 1
ai != bi
There are no repeated edges. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter V: ");
        int V = sc.nextInt();
        System.out.println("Enter number of edges: ");
        int e = sc.nextInt();
        
        int arr[][] = new int[e][2];
        System.out.println("Enter "+e+" edges: ");
        for(int i=0;i<e;i++) {
            System.out.println("Enter u: ");
            arr[i][0] = sc.nextInt();
            System.out.println("Enter v: ");
            arr[i][1] = sc.nextInt();
        }

        System.out.println(countCompleteComponents(V, arr));

        sc.close();
    }
    public static int countCompleteComponents(int n, int[][] edges) {
        //number of components nikal kr unhe complete hai ya nhi check krenge

        List<List<Integer>>adj = new ArrayList<>();

        for(int i=0;i<n;i++)adj.add(new ArrayList<>());

        for(int e[]: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        } //graph to ban gaya

        boolean visited[] = new boolean[n];

        int ans=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                int res[] = dfs(i, visited, adj);
                int v=res[0];
                int e=res[1]/2; //undirected

                if(e==(v*(v-1)/2))ans++;
            }
        }
        return ans;
    }
    static int[] dfs(int node, boolean visited[], List<List<Integer>>adj){
        visited[node]=true;

        int v=1;
        int e=adj.get(node).size();

        for(int ele: adj.get(node)){
            if(!visited[ele]){
                int res[] = dfs(ele, visited, adj);
                v+=res[0];
                e+=res[1];
            }
        }
        return new int[]{v,e};
    }
}