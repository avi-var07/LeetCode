/*In this problem, a tree is an undirected graph that is connected and has no cycles.

You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.

 

Example 1:


Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]
Example 2:


Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
Output: [1,4]
 

Constraints:

n == edges.length
3 <= n <= 1000
edges[i].length == 2
1 <= ai < bi <= edges.length
ai != bi
There are no repeated edges.
The given graph is connected. */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of edges: ");
        int e = sc.nextInt();
        
        int arr[][] = new int[e][2];
        System.out.println("Enter "+e+" elements: ");
        for(int i=0;i<e;i++) {
            System.out.println("Enter u: ");
            arr[i][0] = sc.nextInt();
            System.out.println("Enter v: ");
            arr[i][1] = sc.nextInt();
        }
        int ans[] = findRedundantConnection(arr);
        System.out.println(ans[0]+","+ans[1]);
        sc.close();
    }
    static class DSU{
        int parent[];
        int size[];

        DSU(int n){
            parent = new int[n+1];
            size= new int[n+1];

            for(int i=0;i<=n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }
        boolean union(int u, int v){
            int pu = findParent(u);
            int pv = findParent(v);

            if(pu==pv)return true; //ye cycle bana rha

            else{
                if(size[pu]>=size[pv]){
                    parent[pv]=pu;
                    size[pu]+=size[pv];
                }
                else{
                    parent[pu]=pv;
                    size[pv]+=size[pu];

                }
            }
            return false;
        }
        int findParent(int vtx){
            if(parent[vtx]==vtx)return vtx;

            return parent[vtx]=findParent(parent[vtx]);
        }
    }
    public static int[] findRedundantConnection(int[][] edges) { 
        int n = edges.length;
        DSU d = new DSU(n+1);
        int ans[] = new int[2];
        for(int e[]: edges){
            if(d.union(e[0], e[1])){
                ans[0]=e[0];
                ans[1]=e[1];
            }
        }
        return ans;
    }
}