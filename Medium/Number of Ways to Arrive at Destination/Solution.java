/*You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.

You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.

Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.

 

Example 1:


Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
Output: 4
Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
The four ways to get there in 7 minutes are:
- 0 ➝ 6
- 0 ➝ 4 ➝ 6
- 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
- 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
Example 2:

Input: n = 2, roads = [[1,0,10]]
Output: 1
Explanation: There is only one way to go from intersection 0 to intersection 1, and it takes 10 minutes.
 

Constraints:

1 <= n <= 200
n - 1 <= roads.length <= n * (n - 1) / 2
roads[i].length == 3
0 <= ui, vi <= n - 1
1 <= timei <= 109
ui != vi
There is at most one road connecting any two intersections.
You can reach any intersection from any other intersection. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes: ");
        int V = sc.nextInt();

        System.out.println("Enter number of edges: ");
        int n = sc.nextInt();
        int arr[][] = new int[n][3];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) {
            System.out.println("Enter u: ");
            arr[i][0] = sc.nextInt();
            System.out.println("Enter v: ");
            arr[i][1] = sc.nextInt();
            System.out.println("Enter w: ");
            arr[i][2] = sc.nextInt();
        }
        Solution sol  =new Solution();
        System.out.println(sol.countPaths(V, arr));
        sc.close();
    }
    class Pair{
        int node;
        long wt;
        Pair(int node, long wt){
            this.node =node;
            this.wt=wt;
        }
    }
    public int countPaths(int n, int[][] roads) {
        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b)->Long.compare(a.wt,b.wt));

        long dist[] = new long[n];
        long ways[] = new long[n];

        List<List<Pair>>adj=new ArrayList<>();

        for(int i=0;i<n;i++)adj.add(new ArrayList<>());

        for(int ele[]: roads){
            adj.get(ele[0]).add(new Pair(ele[1], ele[2]));
            adj.get(ele[1]).add(new Pair(ele[0], ele[2]));
        }

        Arrays.fill(dist, Long.MAX_VALUE);
        long MOD = (long)1e9+7;

        dist[0]=0;
        ways[0]=1;
        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            long initial =p.wt;

            
            for(Pair ele: adj.get(node)){
                long newDist = initial+ele.wt;
                int next=ele.node;

                if(newDist<dist[next]){
                    dist[next]=newDist;
                    ways[next]=ways[node];

                    pq.add(new Pair(next, newDist));
                }
                else if(newDist==dist[next])ways[next]=(ways[next]+ways[node])%MOD;
            }
        }
        return (int)(ways[n-1]%MOD);
    }
}