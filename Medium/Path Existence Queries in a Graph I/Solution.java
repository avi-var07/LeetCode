/*You are given an integer n representing the number of nodes in a graph, labeled from 0 to n - 1.

You are also given an integer array nums of length n sorted in non-decreasing order, and an integer maxDiff.

An undirected edge exists between nodes i and j if the absolute difference between nums[i] and nums[j] is at most maxDiff (i.e., |nums[i] - nums[j]| <= maxDiff).

You are also given a 2D integer array queries. For each queries[i] = [ui, vi], determine whether there exists a path between nodes ui and vi.

Return a boolean array answer, where answer[i] is true if there exists a path between ui and vi in the ith query and false otherwise.

 

Example 1:

Input: n = 2, nums = [1,3], maxDiff = 1, queries = [[0,0],[0,1]]

Output: [true,false]

Explanation:

Query [0,0]: Node 0 has a trivial path to itself.
Query [0,1]: There is no edge between Node 0 and Node 1 because |nums[0] - nums[1]| = |1 - 3| = 2, which is greater than maxDiff.
Thus, the final answer after processing all the queries is [true, false].
Example 2:

Input: n = 4, nums = [2,5,6,8], maxDiff = 2, queries = [[0,1],[0,2],[1,3],[2,3]]

Output: [false,false,true,true]

Explanation:

The resulting graph is:



Query [0,1]: There is no edge between Node 0 and Node 1 because |nums[0] - nums[1]| = |2 - 5| = 3, which is greater than maxDiff.
Query [0,2]: There is no edge between Node 0 and Node 2 because |nums[0] - nums[2]| = |2 - 6| = 4, which is greater than maxDiff.
Query [1,3]: There is a path between Node 1 and Node 3 through Node 2 since |nums[1] - nums[2]| = |5 - 6| = 1 and |nums[2] - nums[3]| = |6 - 8| = 2, both of which are within maxDiff.
Query [2,3]: There is an edge between Node 2 and Node 3 because |nums[2] - nums[3]| = |6 - 8| = 2, which is equal to maxDiff.
Thus, the final answer after processing all the queries is [false, false, true, true].
 

Constraints:

1 <= n == nums.length <= 105
0 <= nums[i] <= 105
nums is sorted in non-decreasing order.
0 <= maxDiff <= 105
1 <= queries.length <= 105
queries[i] == [ui, vi]
0 <= ui, vi < n */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println("Enter maxDiff: ");
        int maxDiff =sc.nextInt();

        System.out.println("Enter number of queries: ");
        int m =sc.nextInt();

        int queries[][] = new int[m][2];

        for(int i=0;i<m;i++){
            System.out.println("Enter u: ");
            queries[i][0]=sc.nextInt();
            System.out.println("Enter v: ");
            queries[i][1] =sc.nextInt();
        }
        
        Solution sol = new Solution();
        boolean ans[] = sol.pathExistenceQueries(n, arr, maxDiff, queries);
        for(boolean ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    class DSU{
        int V;
        int parent[];
        int size[];

        DSU(int V){
            this.V=V;
            parent = new int[V];
            size=new int[V];

            for(int i=0;i<V;i++){
                parent[i]=i;
                size[i]=1;
            }
        }

        boolean union(int a, int b){
            int pa=findParent(a);
            int pb = findParent(b);

            if(pa==pb)return false;

            if(size[pa]>=size[pb]){
                parent[pb]=pa;
                size[pa]+=size[pb];
            }
            else{
                parent[pa]=pb;
                size[pb]+=size[pa];
            }
            return true;
        }
        int findParent(int x){
            if(parent[x]==x)return x;
            return parent[x]=findParent(parent[x]);
        }

    }
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        //int left=0, right=1;
        DSU d=new DSU(n);
        // List<List<Integer>>adj = new ArrayList<>();
        // for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        
        // while(right<n){
        //     int diff =nums[right]-nums[left];
        //     if(diff<=maxDiff){
        //         d.union(left, right);
        //         right++;
        //     }
        //     else left++;
        // }

        //upar while loop ka simple version:
        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1]<=maxDiff)d.union(i, i-1);
        }
        int m=queries.length;
        boolean ans[] = new boolean[m];
        int idx=0;
        for(int ele[]: queries){
            int u=ele[0];
            int v=ele[1];

            //TLE: ans[idx++]=solve(u, v, adj, n);
            ans[idx++]=d.findParent(u)==d.findParent(v);
        }

        return ans;
    }
    // static boolean solve(int src, int target, List<List<Integer>>adj, int n){
    //     Queue<Integer>queue= new LinkedList<>();
    //     queue.add(src);
    //     boolean vis[] = new boolean[n];
    //     vis[src]=true;
    //     while(!queue.isEmpty()){
    //         int curr=queue.poll();
    //         if(curr==target)return true;

    //         for(int nbr: adj.get(curr)){
    //             if(!vis[nbr]){
    //                 queue.add(nbr);
    //                 vis[nbr]=true;
    //             }
    //         }
    //     }
    //     return false;
    // }
}