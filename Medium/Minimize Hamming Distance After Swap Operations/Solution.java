/*You are given two integer arrays, source and target, both of length n. You are also given an array allowedSwaps where each allowedSwaps[i] = [ai, bi] indicates that you are allowed to swap the elements at index ai and index bi (0-indexed) of array source. Note that you can swap elements at a specific pair of indices multiple times and in any order.

The Hamming distance of two arrays of the same length, source and target, is the number of positions where the elements are different. Formally, it is the number of indices i for 0 <= i <= n-1 where source[i] != target[i] (0-indexed).

Return the minimum Hamming distance of source and target after performing any amount of swap operations on array source.

 

Example 1:

Input: source = [1,2,3,4], target = [2,1,4,5], allowedSwaps = [[0,1],[2,3]]
Output: 1
Explanation: source can be transformed the following way:
- Swap indices 0 and 1: source = [2,1,3,4]
- Swap indices 2 and 3: source = [2,1,4,3]
The Hamming distance of source and target is 1 as they differ in 1 position: index 3.
Example 2:

Input: source = [1,2,3,4], target = [1,3,2,4], allowedSwaps = []
Output: 2
Explanation: There are no allowed swaps.
The Hamming distance of source and target is 2 as they differ in 2 positions: index 1 and index 2.
Example 3:

Input: source = [5,1,2,4,3], target = [1,5,4,2,3], allowedSwaps = [[0,4],[4,2],[1,3],[1,4]]
Output: 0
 

Constraints:

n == source.length == target.length
1 <= n <= 105
1 <= source[i], target[i] <= 105
0 <= allowedSwaps.length <= 105
allowedSwaps[i].length == 2
0 <= ai, bi <= n - 1
ai != bi */

import java.util.*;

class Solution{
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int source[] = new int[n];
        System.out.println("Enter "+n+" elements of source: ");
        for(int i=0;i<n;i++) source[i] = sc.nextInt();

        int target[] = new int[n];
        System.out.println("Enter "+n+" elements of target: ");
        for(int i=0;i<n;i++) target[i] = sc.nextInt();

        System.out.println("Enter number of allowed swaps: ");
        int m = sc.nextInt();

        int allowedSwaps[][] = new int[m][2];
        System.out.println("Enter "+m+" pairs (ai bi): ");
        for(int i=0;i<m;i++){
            allowedSwaps[i][0] = sc.nextInt();
            allowedSwaps[i][1] = sc.nextInt();
        }

        Solution sol = new Solution();
        int ans = sol.minimumHammingDistance(source, target, allowedSwaps);

        System.out.println("Minimum Hamming Distance: " + ans);

        sc.close();
    }
    
    class DSU{
        int parent[];
        int size[];
        DSU(int n){
            parent = new int[n];
            size = new int[n];

            for(int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }

        int findParent(int x){
            if(parent[x]==x)return x;

            return parent[x] = findParent(parent[x]);
        }

        boolean union(int a, int b){
            int pa = findParent(a);
            int pb= findParent(b);
            if(pa==pb)return false;
            else{
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
        }
    }
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n =source.length;

        DSU d = new DSU(n);

        for(int ele[]: allowedSwaps)d.union(ele[0], ele[1]);

        Map<Integer, Map<Integer, Integer>>map = new HashMap<>();
        //har parent k groups k elements along with their freq
        //parent->(value->frequency) swap allowed and their elements

        //store krte hai map mei:
        for(int i=0;i<n;i++){
            int parent = d.findParent(i);

            map.putIfAbsent(parent, new HashMap<>());
            Map<Integer, Integer>freq = map.get(parent);
            //update freq:
            freq.put(source[i], freq.getOrDefault(source[i],0)+1);
        }

        int diff= 0;
        //check krte hai har index pe jaake diff from target array using parent (swap groups)

        for(int i=0;i<n;i++){
            int parent =d.findParent(i);

            Map<Integer, Integer>freq = map.get(parent);
            if(freq.getOrDefault(target[i], 0)>0)freq.put(target[i], freq.get(target[i])-1);
            else diff++;
            
        }

        return diff;
    }
}