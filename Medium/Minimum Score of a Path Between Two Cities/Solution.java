/*You are given a positive integer n representing n cities numbered from 1 to n. You are also given a 2D array roads where roads[i] = [ai, bi, distancei] indicates that there is a bidirectional road between cities ai and bi with a distance equal to distancei. The cities graph is not necessarily connected.

The score of a path between two cities is defined as the minimum distance of a road in this path.

Return the minimum possible score of a path between cities 1 and n.

Note:

A path is a sequence of roads between two cities.
It is allowed for a path to contain the same road multiple times, and you can visit cities 1 and n multiple times along the path.
The test cases are generated such that there is at least one path between 1 and n.
 

Example 1:


Input: n = 4, roads = [[1,2,9],[2,3,6],[2,4,5],[1,4,7]]
Output: 5
Explanation: The path from city 1 to 4 with the minimum score is: 1 -> 2 -> 4. The score of this path is min(9,5) = 5.
It can be shown that no other path has less score.
Example 2:


Input: n = 4, roads = [[1,2,2],[1,3,4],[3,4,7]]
Output: 2
Explanation: The path from city 1 to 4 with the minimum score is: 1 -> 2 -> 1 -> 3 -> 4. The score of this path is min(2,2,4,7) = 2.
 

Constraints:

2 <= n <= 105
1 <= roads.length <= 105
roads[i].length == 3
1 <= ai, bi <= n
ai != bi
1 <= distancei <= 104
There are no repeated edges.
There is at least one path between 1 and n. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();

        int arr[][] = new int[n][3];
        System.out.println("Enter "+n+" elements: ");
        for(int i=1;i<=n;i++) {
            System.out.println("Enter u: ");
            arr[i][0] = sc.nextInt();
            System.out.println("Enter v: ");
            arr[i][1] = sc.nextInt();
            System.out.println("Enter w: ");
            arr[i][2] = sc.nextInt();
        }
        Solution sol = new Solution();
        System.out.println(sol.minScore(n, arr));

        sc.close();
    }
    class Pair{
        int v;
        int wt;

        Pair(int v, int wt){
            this.v=v;
            this.wt=wt;
        }
    }
    int ans=Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        List<List<Pair>>adj = new ArrayList<>();
        for(int i=0;i<=n;i++)adj.add(new ArrayList<>());
        for(int ele[]: roads){
            int u=ele[0];
            int v=ele[1];
            int wt=ele[2];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        boolean vis[]= new boolean[n+1];
     
        dfs(1, adj, vis);
        return ans;

    }
    void dfs(int node, List<List<Pair>>adj, boolean vis[]){
        vis[node]=true;
        
        for(Pair nbr: adj.get(node)){
            ans=Math.min(nbr.wt, ans);
            if(!vis[nbr.v])dfs(nbr.v, adj, vis);
        }
    }
}