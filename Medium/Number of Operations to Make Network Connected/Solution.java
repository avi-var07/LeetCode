/*There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.

You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.

Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.

 

Example 1:


Input: n = 4, connections = [[0,1],[0,2],[1,2]]
Output: 1
Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
Example 2:


Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
Output: 2
Example 3:

Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
Output: -1
Explanation: There are not enough cables.
 

Constraints:

1 <= n <= 105
1 <= connections.length <= min(n * (n - 1) / 2, 105)
connections[i].length == 2
0 <= ai, bi < n
ai != bi
There are no repeated connections.
No two computers are connected by more than one cable. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter number of edges: ");
        int e= sc.nextInt();
        int arr[][] = new int[e][2];

        System.out.println("Enter "+e+" edges: ");
        for(int i=0;i<e;i++) {
            System.out.print("Enter u: ");
            arr[i][0] = sc.nextInt();
            System.out.print("Enter v: ");
            arr[i][1] = sc.nextInt();
        }

        Solution sol=new Solution();
        System.out.println(sol.makeConnected(n, arr));

        sc.close();
    }
    class DSU{
        int n;
        int parent[];
        int size[];
        int components;
        DSU(int n){
            this.n=n;
            parent = new int[n];
            size = new int[n];
            components=n;
            for(int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }

        boolean union(int u, int v){
            int pu = find(u);
            int pv =find(v);
            if(pu==pv)return false;

            if(size[pu]>=size[pv]){
                parent[pv]=pu;
                size[pu]+=size[pv];
            }
            else{
                parent[pu]=pv;
                size[pv]+=size[pu];
            }
            components--;
            return true;
        }

        int find(int x){
            if(parent[x]==x)return x;
            return parent[x]=find(parent[x]);
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)return -1;

        DSU d= new DSU(n);

        for(int ele[]: connections){
            int u =ele[0];
            int v=ele[1];

            d.union(u,v);
        }

        //find all unique parents (total groups)

        //using set:
        // Set<Integer>set = new HashSet<>();
        // for(int i=0;i<n;i++)set.add(d.find(i));

        // return set.size()-1;

        //using dsu to count only, intialising componets=n (all disconnected initially, as union is true, coponents--)

        return d.components-1;
        //dfs appraoch:
        // if(connections.length<n-1)return -1;
        // List<List<Integer>>adj = new ArrayList<>();
        // int ans= 0;

        // for(int i=0;i<n;i++)adj.add(new ArrayList<>());

        // for(int ele[]: connections){
        //     int u =ele[0];
        //     int v=ele[1];

        //     adj.get(u).add(v);
        //     adj.get(v).add(u);
        // }
        // boolean vis[]= new boolean[n];
        // for(int i=0;i<n;i++){
        //     if(!vis[i]){
        //         dfs(i, adj, vis);
        //         ans++;
        //     }
        // }

        // return ans-1;
    }

    // static void dfs(int node, List<List<Integer>>adj, boolean vis[]){
    //     vis[node]=true;

    //     for(int ele: adj.get(node)){
    //         if(!vis[ele])dfs(ele, adj, vis);
    //     }
    // }
}