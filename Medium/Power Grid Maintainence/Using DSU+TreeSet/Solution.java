/*You are given an integer c representing c power stations, each with a unique identifier id from 1 to c (1‑based indexing).

These stations are interconnected via n bidirectional cables, represented by a 2D array connections, where each element connections[i] = [ui, vi] indicates a connection between station ui and station vi. Stations that are directly or indirectly connected form a power grid.

Initially, all stations are online (operational).

You are also given a 2D array queries, where each query is one of the following two types:

[1, x]: A maintenance check is requested for station x. If station x is online, it resolves the check by itself. If station x is offline, the check is resolved by the operational station with the smallest id in the same power grid as x. If no operational station exists in that grid, return -1.

[2, x]: Station x goes offline (i.e., it becomes non-operational).

Return an array of integers representing the results of each query of type [1, x] in the order they appear.

Note: The power grid preserves its structure; an offline (non‑operational) node remains part of its grid and taking it offline does not alter connectivity.

 

Example 1:

Input: c = 5, connections = [[1,2],[2,3],[3,4],[4,5]], queries = [[1,3],[2,1],[1,1],[2,2],[1,2]]

Output: [3,2,3]

Explanation:



Initially, all stations {1, 2, 3, 4, 5} are online and form a single power grid.
Query [1,3]: Station 3 is online, so the maintenance check is resolved by station 3.
Query [2,1]: Station 1 goes offline. The remaining online stations are {2, 3, 4, 5}.
Query [1,1]: Station 1 is offline, so the check is resolved by the operational station with the smallest id among {2, 3, 4, 5}, which is station 2.
Query [2,2]: Station 2 goes offline. The remaining online stations are {3, 4, 5}.
Query [1,2]: Station 2 is offline, so the check is resolved by the operational station with the smallest id among {3, 4, 5}, which is station 3.
Example 2:

Input: c = 3, connections = [], queries = [[1,1],[2,1],[1,1]]

Output: [1,-1]

Explanation:

There are no connections, so each station is its own isolated grid.
Query [1,1]: Station 1 is online in its isolated grid, so the maintenance check is resolved by station 1.
Query [2,1]: Station 1 goes offline.
Query [1,1]: Station 1 is offline and there are no other stations in its grid, so the result is -1.
 

Constraints:

1 <= c <= 105
0 <= n == connections.length <= min(105, c * (c - 1) / 2)
connections[i].length == 2
1 <= ui, vi <= c
ui != vi
1 <= queries.length <= 2 * 105
queries[i].length == 2
queries[i][0] is either 1 or 2.
1 <= queries[i][1] <= c */


import java.util.*;

class Solution{
    static int []parent;
    static int []rank;
    static TreeSet<Integer>[] compSet;
    static boolean[] offline;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of stations: ");
        int c = sc.nextInt();

        System.out.println("Enter number of connections: ");
        int n = sc.nextInt();

        int arr[][] = new int[n][2];
        System.out.println("Enter "+n+" connections: ");
        for(int i=0;i<n;i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        
        System.out.println("Enter number of queries: ");
        int q = sc.nextInt();

        int queries[][] = new int[q][2];
        for(int i=0;i<q;i++){
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }
        int ans[] = processQueries(c, arr, queries);

        for(int ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    public static int[] processQueries(int c, int[][] connections, int[][] queries) {
        parent  = new int[c+1];
        rank = new int[c+1];
        compSet = new TreeSet[c+1];
        offline = new boolean[c+1];

        for(int i=1;i<=c;i++){
            parent[i]=i;
            rank[i]=0;
            compSet[i] = new TreeSet<>();
            compSet[i].add(i);
        }

        for(int edge[]: connections)union(edge[0], edge[1]);

        List<Integer>res = new ArrayList<>();

        for(int q[]: queries){
            int type = q[0], x= q[1];

            if(type==1){
                if(!offline[x])res.add(x);
                else{
                    int root = find(x);
                    if(compSet[root].isEmpty())res.add(-1);
                    else res.add(compSet[root].first());
                }
            }
            else{
                if(!offline[x]){
                    offline[x]=true;
                    int root = find(x);
                    compSet[root].remove(x);
                }
            }
        }
        int ans[]  =new int[res.size()];
        for(int i=0;i<res.size();i++)ans[i]=res.get(i);

        return ans;
    }
    static int find(int x){
        if(parent[x]==x)return x;
        return parent[x] = find(parent[x]);
    }
    static void union(int a, int b){
        int a_parent = find(a);
        int b_parent = find(b);
        if(a_parent==b_parent)return;
        
        if(rank[a_parent]>rank[b_parent]){
            parent[b_parent]=a_parent;
            compSet[a_parent].addAll(compSet[b_parent]);
        }
        else if(rank[a_parent]<rank[b_parent]){
            parent[a_parent]=b_parent;
            compSet[b_parent].addAll(compSet[a_parent]);
        }
        else{
            parent[a_parent]=b_parent;
            rank[b_parent]++;
            compSet[b_parent].addAll(compSet[a_parent]);
        }
    }
}