/*You are given a positive integer n.

There is an undirected graph with n nodes labeled from 0 to n - 1. Initially, the graph has no edges.

You are also given a 2D integer array edges, where edges[i] = [ui, vi, wi] represents an edge between nodes ui and vi with weight wi. The weight wi is either 0 or 1.

Process the edges in edges in the given order. For each edge, add it to the graph only if, after adding it, the sum of the weights of the edges in every cycle in the resulting graph is even.

Return an integer denoting the number of edges that are successfully added to the graph.

 

Example 1:

Input: n = 3, edges = [[0,1,1],[1,2,1],[0,2,1]]

Output: 2

Explanation:



[0, 1, 1]: We add the edge between vertex 0 and vertex 1 with weight 1.
[1, 2, 1]: We add the edge between vertex 1 and vertex 2 with weight 1.
[0, 2, 1]: The edge between vertex 0 and vertex 2 (the dashed edge in the diagram) is not added because the cycle 0 - 1 - 2 - 0 has total edge weight 1 + 1 + 1 = 3, which is an odd number.
Example 2:

Input: n = 3, edges = [[0,1,1],[1,2,1],[0,2,0]]

Output: 3

Explanation:



[0, 1, 1]: We add the edge between vertex 0 and vertex 1 with weight 1.
[1, 2, 1]: We add the edge between vertex 1 and vertex 2 with weight 1.
[0, 2, 0]: We add the edge between vertex 0 and vertex 2 with weight 0.
Note that the cycle 0 - 1 - 2 - 0 has total edge weight 1 + 1 + 0 = 2, which is an even number.
 

Constraints:

3 <= n <= 5 * 104
1 <= edges.length <= 5 * 104
edges[i] = [ui, vi, wi]
0 <= ui < vi < n
All edges are distinct.
wi = 0 or wi = 1 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes: ");
        int n = sc.nextInt();
        
        System.out.println("Enter number of edges: ");
        int e = sc.nextInt();
        int arr[][] = new int[e][3];
        System.out.println("Enter "+e+" edges: ");
        for(int i=0;i<e;i++) {
            
            System.out.println("Enter u: ");
            arr[i][0] = sc.nextInt();
            System.out.println("Enter v: ");
            arr[i][1] = sc.nextInt();
            System.out.println("Enter w: ");
            arr[i][2] = sc.nextInt();
        }
        Solution sol = new Solution();
        System.out.println(sol.numberOfEdgesAdded(n, arr));

        sc.close();
    }
    //weights sirf 0 ya 1 hai, mathematically represented as parity:
    //Even number → parity = 0
    //Odd number  → parity = 1
    //XOR exactly parity addition jaisa behave karta hai
    // 0 ^ 0 = 0   (even + even = even)
    // 0 ^ 1 = 1   (even + odd = odd)
    // 1 ^ 0 = 1   (odd + even = odd)
    // 1 ^ 1 = 0   (odd + odd = even)

    //(a + b) % 2  ==  a ^ b , Isliye sum even/odd check karne ke liye XOR use karte hain.
    //Cycle sum = path(u → v) + new edge weight
    //cycle parity = parity[u] ^ parity[v] ^ w
    //agar 0: add, else no
    class DSU{
        int parent[];
        int parity[];
        int size[];
        DSU(int v){
            parent = new int[v];
            parity = new int[v];
            size=new int[v];

            for(int i=0;i<v;i++){
                parent[i]=i;
                parity[i]=0;
                size[i]=1;
            }
        }

        boolean union(int u, int v, int w){
            int pu = findParent(u);
            int pv = findParent(v);

            if(pu==pv){ //mtlb cycle bana dega
                if((parity[u]^parity[v]^w) ==0)return true;
                return false;
            }
            else{
                if(size[pu]>=size[pv]){
                    parent[pv]=pu;
                    parity[pv]=parity[u]^parity[v]^w;
                    size[pu]+=size[pv];
                }
                else{
                    parent[pu]=pv;
                    parity[pu]=parity[u]^parity[v]^w;
                    size[pv]+=size[pu];
                }
            }
            return true;
        }

        int findParent(int x){
            if(parent[x]==x)return x;
            int oriParent = parent[x];
            parent[x]=findParent(parent[x]);
            parity[x]^=parity[oriParent];
            return parent[x];
        }
    }
    public int numberOfEdgesAdded(int n, int[][] edges) {
        DSU d = new DSU(n);
        int cnt=0;

        for(int e[]: edges){
            int u =e[0];
            int v =e[1];
            int w =e[2];

            if(d.union(u,v,w))cnt++;
        }
        return cnt;
    }
}