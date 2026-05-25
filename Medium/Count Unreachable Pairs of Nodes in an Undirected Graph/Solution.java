/*You are given an integer n. There is an undirected graph with n nodes, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting nodes ai and bi.

Return the number of pairs of different nodes that are unreachable from each other.

 

Example 1:


Input: n = 3, edges = [[0,1],[0,2],[1,2]]
Output: 0
Explanation: There are no pairs of nodes that are unreachable from each other. Therefore, we return 0.
Example 2:


Input: n = 7, edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]
Output: 14
Explanation: There are 14 pairs of nodes that are unreachable from each other:
[[0,1],[0,3],[0,6],[1,2],[1,3],[1,4],[1,5],[2,3],[2,6],[3,4],[3,5],[3,6],[4,6],[5,6]].
Therefore, we return 14.
 

Constraints:

1 <= n <= 105
0 <= edges.length <= 2 * 105
edges[i].length == 2
0 <= ai, bi < n
ai != bi
There are no repeated edges. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices: ");
        int n = sc.nextInt();

        int arr[][] = new int[n][2];
        System.out.println("Enter "+n+" edges: ");
        for(int i=0;i<n;i++) {
            System.out.println("Enter u: ");
            arr[i][0] = sc.nextInt();
            System.out.println("Enter v: ");
            arr[i][1] = sc.nextInt();
        }

        Solution sol =new Solution();
        System.out.println(sol.countPairs(n, arr));


        sc.close();
    }
    class DSU{
        int parent[];
        int size[];

        int V;
        DSU(int V){
            this.V=V;

            parent = new int[V];
            size= new int[V];

            for(int i=0;i<V;i++){
                parent[i]=i;
                size[i]=1;
            }

        }
        boolean union(int a, int b){
            int pa  =find(a);
            int pb=  find(b);

            if(pa==pb)return true;

            if(size[pa]>=size[pb]){
                parent[pb]=pa;
                size[pa]+=size[pb];
            }
            else{
                parent[pa]=pb;
                size[pb]+=size[pa];
            }
            return false;
        }

        int find(int x){
            if(parent[x]==x)return x;

            return parent[x] = find(parent[x]);
        }
    }
    public long countPairs(int n, int[][] edges) {
        DSU d=  new DSU(n);

        long ans =0;

        for(int ele[]: edges){
            int u =ele[0];
            int v =ele[1];

            d.union(u,v);

        }

        long rem = n;
        //component ka actual size ultimate parent mei store hota hai, mtlb hr grp ka final parent


        for(int i=0;i<n;i++){
            if(d.parent[i]==i){
                int sze =d.size[i];

                rem-=sze;
                ans+=sze*rem;
            }
        }

        return ans;
    }
}