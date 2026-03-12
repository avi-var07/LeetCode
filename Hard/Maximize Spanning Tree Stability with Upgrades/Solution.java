/*You are given an integer n, representing n nodes numbered from 0 to n - 1 and a list of edges, where edges[i] = [ui, vi, si, musti]:

ui and vi indicates an undirected edge between nodes ui and vi.
si is the strength of the edge.
musti is an integer (0 or 1). If musti == 1, the edge must be included in the spanning tree. These edges cannot be upgraded.
You are also given an integer k, the maximum number of upgrades you can perform. Each upgrade doubles the strength of an edge, and each eligible edge (with musti == 0) can be upgraded at most once.

The stability of a spanning tree is defined as the minimum strength score among all edges included in it.

Return the maximum possible stability of any valid spanning tree. If it is impossible to connect all nodes, return -1.

Note: A spanning tree of a graph with n nodes is a subset of the edges that connects all nodes together (i.e. the graph is connected) without forming any cycles, and uses exactly n - 1 edges.

 

Example 1:

Input: n = 3, edges = [[0,1,2,1],[1,2,3,0]], k = 1

Output: 2

Explanation:

Edge [0,1] with strength = 2 must be included in the spanning tree.
Edge [1,2] is optional and can be upgraded from 3 to 6 using one upgrade.
The resulting spanning tree includes these two edges with strengths 2 and 6.
The minimum strength in the spanning tree is 2, which is the maximum possible stability.
Example 2:

Input: n = 3, edges = [[0,1,4,0],[1,2,3,0],[0,2,1,0]], k = 2

Output: 6

Explanation:

Since all edges are optional and up to k = 2 upgrades are allowed.
Upgrade edges [0,1] from 4 to 8 and [1,2] from 3 to 6.
The resulting spanning tree includes these two edges with strengths 8 and 6.
The minimum strength in the tree is 6, which is the maximum possible stability.
Example 3:

Input: n = 3, edges = [[0,1,1,1],[1,2,1,1],[2,0,1,1]], k = 0

Output: -1

Explanation:

All edges are mandatory and form a cycle, which violates the spanning tree property of acyclicity. Thus, the answer is -1.
 

Constraints:

2 <= n <= 105
1 <= edges.length <= 105
edges[i] = [ui, vi, si, musti]
0 <= ui, vi < n
ui != vi
1 <= si <= 105
musti is either 0 or 1.
0 <= k <= n
There are no duplicate edges.
 
 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int V = sc.nextInt();

        System.out.println("Enter number of edges: ");
        int n = sc.nextInt();
        int arr[][] = new int[n][4];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) {
            System.out.println("Enter u: ");
            arr[i][0] = sc.nextInt();
            System.out.println("Enter v: ");
            arr[i][1] = sc.nextInt();
            System.out.println("Enter w: ");
            arr[i][2] = sc.nextInt();
            System.out.println("Enter s: ");
            arr[i][3] = sc.nextInt();
        }
        System.out.println("Enter k: ");
        int k = sc.nextInt();
        Solution sol = new Solution();
        System.out.println(sol.maxStability(V, arr, k));
        sc.close();
    }
    class DSU{
        int parent[];
        int size[];
        int n;
        DSU(int n){
            this.n=n;
            parent = new int[n];
            size=new int[n];

            for(int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }
        int findParent(int x){
            if(parent[x]==x)return x;
             
            return parent[x]=findParent(parent[x]);
        }
        boolean union(int u, int v){
            int pu=findParent(u);
            int pv =findParent(v);
            if(pu==pv)return false;

            if(size[pu]>=size[pv]){
                parent[pv]=pu;
                size[pu]+=size[pv];
            }
            else{
                parent[pu]=pv;
                size[pv]+=size[pu];
            }
            return true;
        }
    }
    public int maxStability(int n, int[][] edges, int k) {
        int low=0, high=200000;

        int ans=-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(binarySearch(mid, n, edges, k)){
                ans=mid;
                low=mid+1;
            }
            else high=mid-1;
        }
        return ans;
    }

    boolean binarySearch(int mid, int n, int arr[][], int k){

    DSU d = new DSU(n);

    int used = 0;
    int upgrades = 0;

    // PASS 1 : mandatory edges
    for(int ele[]: arr){

        int u = ele[0];
        int v = ele[1];
        int w = ele[2];
        int must = ele[3];

        if(must == 1){

            if(w < mid) return false;

            if(!d.union(u,v)) return false;

            used++;
        }
    }

    if(used == n-1) return true;

    // collect optional edges
    List<int[]> optional = new ArrayList<>();

    for(int[] e : arr){
        if(e[3] == 0) optional.add(e);
    }

    // sort by strength descending
    optional.sort((a,b)->b[2]-a[2]);

    for(int[] ele : optional){

        int u = ele[0];
        int v = ele[1];
        int w = ele[2];

        if(d.findParent(u) == d.findParent(v)) continue;

        if(w >= mid){
            d.union(u,v);
            used++;
        }
        else if(w*2 >= mid && upgrades < k){
            d.union(u,v);
            upgrades++;
            used++;
        }

        if(used == n-1) return true;
    }

    return false;
}
}