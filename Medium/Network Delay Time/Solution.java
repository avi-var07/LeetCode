/*You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

 

Example 1:


Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1
Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
 

Constraints:

1 <= k <= n <= 100
1 <= times.length <= 6000
times[i].length == 3
1 <= ui, vi <= n
ui != vi
0 <= wi <= 100
All the pairs (ui, vi) are unique. (i.e., no multiple edges.) */
import java.util.*;

class Solution{
    static class Pair{
    int v,wt;
    Pair(int v, int wt){
        this.v=v;
        this.wt=wt;
    }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
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
        System.out.println("Enter k: ");
        int k =sc.nextInt();
        System.out.println(networkDelayTime(arr, n, k));

        sc.close();
    }
    public static int networkDelayTime(int[][] times, int n, int k) {
        if(k>n)return -1;
        int dist[] = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b)->a.wt-b.wt);
        
        List<List<Pair>>adj = new ArrayList<>();
        for(int i=0;i<=n;i++)adj.add(new ArrayList<>());

        for(int t[]: times)adj.get(t[0]).add(new Pair(t[1], t[2]));
        
        dist[k]=0;
        pq.add(new Pair(k, 0));
        int ans =-1;
        while(!pq.isEmpty()){
            Pair p = pq.poll();

            int node = p.v;
            int wt =p.wt;

            if(wt>dist[node])continue;
            for(Pair ele: adj.get(node)){
                int newNode =ele.v;
                int newDist = wt+ele.wt;

                if(newDist<dist[newNode]){
                    dist[newNode]=newDist;
                    pq.add(new Pair(newNode, newDist));
                }
            }
        }
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE)return -1;
            else if(dist[i]>ans)ans=dist[i];
        }

        return ans;
    }
}