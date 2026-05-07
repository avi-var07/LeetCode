/* You are given an integer array nums.

From any index i, you can jump to another index j under the following rules:

Jump to index j where j > i is allowed only if nums[j] < nums[i].
Jump to index j where j < i is allowed only if nums[j] > nums[i].
For each index i, find the maximum value in nums that can be reached by following any sequence of valid jumps starting at i.

Return an array ans where ans[i] is the maximum value reachable starting from index i.

 

Example 1:

Input: nums = [2,1,3]

Output: [2,2,3]

Explanation:

For i = 0: No jump increases the value.
For i = 1: Jump to j = 0 as nums[j] = 2 is greater than nums[i].
For i = 2: Since nums[2] = 3 is the maximum value in nums, no jump increases the value.
Thus, ans = [2, 2, 3].

Example 2:

Input: nums = [2,3,1]

Output: [3,3,3]

Explanation:

For i = 0: Jump forward to j = 2 as nums[j] = 1 is less than nums[i] = 2, then from i = 2 jump to j = 1 as nums[j] = 3 is greater than nums[2].
For i = 1: Since nums[1] = 3 is the maximum value in nums, no jump increases the value.
For i = 2: Jump to j = 1 as nums[j] = 3 is greater than nums[2] = 1.
Thus, ans = [3, 3, 3].

 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109*/

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        int ans[] = maxValue(arr);

        for(int ele: ans)System.out.print(ele+" ");
        
        sc.close();
    }
    
    // int dp[];
    // int n;
    // boolean vis[];
    public static int[] maxValue(int[] nums) {
        int n =nums.length;
        //BFS: (TLE)

        // for(int i=0;i<n;i++){
        //     Queue<Integer>queue = new LinkedList<>();
        //     boolean vis[] = new boolean[n];
        //     queue.add(i);
        //     vis[i]=true;

        //     int maxi = nums[i];

        //     while(!queue.isEmpty()){
        //         int curr = queue.poll();

        //         maxi = Math.max(maxi, nums[curr]);
        //         //right:

        //         for(int j=curr+1;j<n;j++){
        //             if(nums[j]<nums[curr]&&!vis[j]){
        //                 vis[j]=true;
        //                 queue.add(j);
        //             }
        //         }

        //         //left:

        //         for(int j=0;j<curr;j++){
        //             if(nums[j]>nums[curr]&&!vis[j]){
        //                 vis[j]=true;
        //                 queue.add(j);
        //             }
        //         }
        //     }
        //     ans[i]=maxi;
        // }

        //DFS+memo: WA

        // dp = new int[n];

        // Arrays.fill(dp, -1);
        // int ans[] =new int[n];
        // vis=new boolean[n];
        // for(int i=0;i<n;i++)ans[i]=dfs(i, nums);

        //Optimal: preMax, preMin

        //based on the conditions:

        int preMax[] = new int[n]; //maxi: 0to i;
        int suffMin[] = new int[n]; //mini: i to n-1;

        preMax[0]=nums[0];
        suffMin[n-1]=nums[n-1];

        for(int i=1;i<n;i++)preMax[i] = Math.max(nums[i], preMax[i-1]);

        for(int i=n-2;i>=0;i--)suffMin[i] = Math.min(nums[i], suffMin[i+1]);

        int ans[] = new int[n];
        ans[n-1]=preMax[n-1];

        for(int  i=n-2;i>=0;i--){
            if(preMax[i]<=suffMin[i+1])ans[i]=preMax[i];
            else ans[i]=ans[i+1];
        }
    

        return ans;
    }

    // int dfs(int ind, int arr[]){
    //     if(dp[ind]!=-1)return dp[ind];
    //     if(vis[ind])return arr[ind];

    //     vis[ind]=true;
    //     int maxi = arr[ind];

    //     //Right:

    //     for(int j=ind+1;j<n;j++)if(arr[j]<arr[ind])maxi = Math.max(maxi, dfs(j, arr));
        

    //     //Left:


    //     for(int j=0;j<ind;j++)if(arr[j]>arr[ind])maxi = Math.max(maxi, dfs(j, arr));

    //     return dp[ind]=maxi;
    //}
}