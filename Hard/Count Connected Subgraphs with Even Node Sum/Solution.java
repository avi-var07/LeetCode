/*You are given an undirected graph with n nodes labeled from 0 to n - 1. Node i has a value of nums[i], which is either 0 or 1. The edges of the graph are given by a 2D array edges where edges[i] = [ui, vi] represents an edge between node ui and node vi.

For a non-empty subset s of nodes in the graph, we consider the induced subgraph of s generated as follows:

We keep only the nodes in s.
We keep only the edges whose two endpoints are both in s.
Return an integer representing the number of non-empty subsets s of nodes in the graph such that:

The induced subgraph of s is connected.
The sum of node values in s is even.
 

Example 1:

Input: nums = [1,0,1], edges = [[0,1],[1,2]]

Output: 2

Explanation:

s	connected?	sum of node values	counted?
[0]	Yes	1	No
[1]	Yes	0	Yes
[2]	Yes	1	No
[0,1]	Yes	1	No
[0,2]	No, node 0 and node 2 are disconnected.	2	No
[1,2]	Yes	1	No
[0,1,2]	Yes	2	Yes
Example 2:

Input: nums = [1], edges = []

Output: 0

Explanation:

s	connected?	sum of node values	counted?
[0]	Yes	1	No
 

Constraints:

1 <= n == nums.length <= 13
nums[i] is 0 or 1.
0 <= edges.length <= n * (n - 1) / 2
edges[i] = [ui, vi]
0 <= ui < vi < n
All edges are distinct. */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();
        int edges[][] = new int[n][2];
        System.out.println("Enter "+n+" edges: ");
        for(int i=0;i<n;i++){
            System.out.println("Enter u: ");
            int u =sc.nextInt();
            System.out.println("Enter v: ");
            int v =sc.nextInt();

            edges[i][0]=u;
            edges[i][1]=v;
        }   
        
        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements of arr (stroing sum): ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println(evenSumSubgraphs(arr, edges));
        
        sc.close();
    }
    public static int evenSumSubgraphs(int[] nums, int[][] edges) {
        //sbse pehle saare subsets generate krenge backtrack se and sum nikal kr check krenge even hai ya nhi
        //connectivity check krne k liye subsets k nodes ko ek set mei daalenge. BFS chalayenge aur visited mark krte jayenge, end mei visited==set.size() to true hai and count++ hojayega!
        int n =nums.length;
        List<List<Integer>>adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int ele[]: edges){
            int u =ele[0];
            int v =ele[1];
            adj.get(u).add(v);
            adj.get(v).add(u);

        }
        List<Integer>ds = new ArrayList<>();
        return generate(0, ds, adj, nums, n);
    }
    static int generate(int idx, List<Integer>ds , List<List<Integer>>adj, int arr[], int n){
        if(idx==n){
            if(ds.size()==0)return 0;

            int sum=0;
            for(int ele: ds)sum+=arr[ele]; //index store horha hai n

            if(sum%2==1)return 0;
            
            if(isConnected(ds, adj))return 1;

            return 0;
        }
        int pick =0;
        ds.add(idx);
        pick+=generate(idx+1, ds, adj, arr, n);

        int notPick =0;
        ds.remove(ds.size()-1);
        notPick+=generate(idx+1, ds, adj, arr, n);

        return pick+notPick;
    }
    static boolean isConnected(List<Integer>subset, List<List<Integer>>adj){
        Queue<Integer>queue= new LinkedList<>();
        Set<Integer>set = new HashSet<>(subset);
        Set<Integer>vis = new HashSet<>();
        int start =subset.get(0);
        queue.add(start);
        vis.add(start);

        while(!queue.isEmpty()){
            int node =queue.poll();

            for(int ele: adj.get(node)){
                if(!vis.contains(ele)&&set.contains(ele)){
                    queue.add(ele);
                    vis.add(ele);
                }
            }
        }

        return vis.size()==set.size();
    }
}