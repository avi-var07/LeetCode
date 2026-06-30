/*You are given a directed weighted graph with n nodes labeled from 0 to n - 1.

The graph is represented by a 2D integer array edges, where edges[i] = [ui, vi, ti] indicates a directed edge from node ui to node vi that takes ti seconds to traverse.

You are also given an integer power representing the initial available power, and an integer array cost of length n, where cost[u] represents the power required to forward the signal from node u through any one of its outgoing edges.

You are given two integers source and target.

The signal starts at source at time 0 with power units of power and follows these rules:

The signal may traverse a directed edge from node u only if the remaining power is at least cost[u].
No power is consumed when the signal arrives at a node, unless it later leaves that node by traversing another edge.
When the signal is forwarded from node u, the remaining power is decreased by cost[u] units.
Traversing an edge edges[i] = [ui, vi, ti] increases the total time by ti seconds.
Return an integer array answer of size 2, where:

answer[0] is the minimum time required for the signal to reach node target.
answer[1] is the maximum remaining power among all paths that achieve answer[0].
If the signal cannot reach target, return [-1, -1].

 

Example 1:



Input: n = 5, edges = [[0,1,1],[1,4,1],[0,2,1],[2,3,1],[3,4,1]], power = 4, cost = [2,3,1,1,1], source = 0, target = 4

Output: [3,0]

Explanation:

The signal starts at node 0 with 4 units of power.
The path 0 -> 1 -> 4 is not valid, because after leaving node 0, the signal has 2 units of power remaining, which is less than cost[1] = 3.
The valid path 0 -> 2 -> 3 -> 4 takes a total time of 3.
The total power consumed along this path is cost[0] + cost[2] + cost[3] = 4, leaving 0 remaining power.
Hence, the answer is [3, 0].
Example 2:



Input: n = 3, edges = [[0,1,2],[1,2,2],[2,0,2]], power = 3, cost = [1,1,1], source = 1, target = 1

Output: [0,3]

Explanation:

Since the source and target are the same node, no traversal is required.
Hence, the minimum total time taken is 0, and no power is consumed.
Therefore, the answer is [0, 3].
Example 3:

​​​​​​​

Input: n = 4, edges = [[0,1,3],[2,3,4]], power = 3, cost = [1,1,1,1], source = 0, target = 3

Output: [-1,-1]

Explanation:

There is no valid path from source to target, therefore return [-1, -1].

 

Constraints:

1 <= n <= 1000
0 <= edges.length <= 1000
edges[i] = [ui, vi, ti]
0 <= ui, vi <= n - 1
1 <= ti <= 109
1 <= power <= 1000
cost.length == n
1 <= cost[i] <= 2000
0 <= source, target <= n - 1 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println("Enter power: " );
        int power=sc.nextInt();

        System.out.println("Enter source: ");
        int source =sc.nextInt();

        System.out.println("Enter target: ");
        int target =sc.nextInt();

        System.out.println("Enter number of edges: ");
        int m = sc.nextInt();
        int edges[][] = new int[m][3];

        for(int i=0;i<m;i++){
            System.out.println("Enter u: ");
            int u=sc.nextInt();
            System.out.println("Enter v: ");
            int v=sc.nextInt();
            System.out.println("Enter t: ");
            int t=sc.nextInt();

            edges[i][0]=u;
            edges[i][1]=v;
            edges[i][2]=t;
        }

        Solution sol =new Solution();
        long ans[]=sol.minTimeMaxPower(n, edges, power, arr, source, target);

        System.out.println(ans[0]+" "+ans[1]);

        sc.close();
    }
    class Tuple{
        int node;
        int power;
        long time;

        Tuple(int node, int power, long time){
            this.node=node;
            this.power=power;
            this.time=time;
        }
    }
    class Pair{
        int v;
        long t;

        Pair(int v, long t){
            this.v=v;
            this.t=t;
        }
    }
    public long[] minTimeMaxPower(int n, int[][] edges, int power, int[] cost, int source, int target) {
        List<List<Pair>>adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());

        for(int ele[]: edges){
            int u=ele[0];
            int v=ele[1];
            int t=ele[2];

            adj.get(u).add(new Pair(v, t));
        }

        PriorityQueue<Tuple>queue= new PriorityQueue<>((a,b)->Long.compare(a.time,b.time));
        queue.add(new Tuple(source, power, 0));
        
        long dist[][] = new long[n][power+1];

        for(long ele[]: dist)Arrays.fill(ele, Long.MAX_VALUE);
        dist[source][power]=0;
        while(!queue.isEmpty()){
            Tuple t=  queue.poll();
            int node =t.node;
            int remPower = t.power;
            long time=t.time;

            if(time>dist[node][remPower])continue;
            if(remPower<cost[node])continue;
            int newPower = remPower-cost[node];

            for(Pair ele: adj.get(node)){
                int nextNode=ele.v;
                long nextTime=ele.t;
                
                long newTime = nextTime+time;

                if(newTime<dist[nextNode][newPower]){
                    dist[nextNode][newPower]=newTime;
                    queue.add(new Tuple(nextNode, newPower, newTime));
                }
            }
            
        }
        long minTime=Long.MAX_VALUE;
        long maxPower = -1;

        for(int i=0;i<=power;i++){
            if(dist[target][i]<minTime){
                minTime=dist[target][i];
                maxPower= i;
            }
            else if(dist[target][i]==minTime)maxPower=Math.max(maxPower, (long)i);
        }

        if(minTime==Long.MAX_VALUE)return new long[]{-1,-1};

        return new long[]{minTime, maxPower};

    }
}