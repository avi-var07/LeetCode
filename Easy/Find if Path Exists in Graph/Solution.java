/*There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

 

Example 1:


Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
Explanation: There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2
Example 2:


Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
Output: false
Explanation: There is no path from vertex 0 to vertex 5.
 

Constraints:

1 <= n <= 2 * 105
0 <= edges.length <= 2 * 105
edges[i].length == 2
0 <= ui, vi <= n - 1
ui != vi
0 <= source, destination <= n - 1
There are no duplicate edges.
There are no self edges.
 
 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter V: ");
        int V = sc.nextInt();

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

        System.out.println("Enter src: ");
        int src= sc.nextInt();
        System.out.println("Enter target: ");

        int target = sc.nextInt();
        System.out.println(validPath(V, arr, src, target));

        sc.close();
    }
        public static boolean validPath(int n, int[][] edges, int src, int target) {
        boolean visited[] = new boolean[n];

        ArrayList<ArrayList<Integer>>adj =new ArrayList<>();

        for(int i=0;i<n;i++)adj.add(new ArrayList<>());

        for(int e[]: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        //return dfs(src, adj, visited, target);
        Queue<Integer>queue=new LinkedList<>();

        queue.add(src);
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(node==target)return true;

            for(int ele: adj.get(node)){
                if(!visited[ele]){
                    visited[ele]=true;
                    queue.add(ele);
                }
            }
        }
        return  false;
        
    }
    // static boolean dfs(int node, ArrayList<ArrayList<Integer>>adj, boolean visited[], int target){
    //     visited[node]=true;
    //     if(node==target)return true;
    //     for(int ele: adj.get(node)){
    //         if(!visited[ele])if(dfs(ele, adj, visited, target))return true;
    //     }
    //     return false;
    // }
}