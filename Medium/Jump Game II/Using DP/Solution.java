/*You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at index i, you can jump to any index (i + j) where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index n - 1.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1]. */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        Solution s = new Solution();
        System.out.println(s.jump(arr));

        sc.close();
    }
    Integer dp[];
    public int jump(int[] nums) {
        int n =nums.length;
        dp =new Integer[n];
        return dfs_tab(nums, n);
    }
    // int dfs(int arr[], int idx, int n){
    //     int minSteps =Integer.MAX_VALUE;
    //     if(idx==n-1)return 0;
    //     if(idx>=n)return Integer.MAX_VALUE;

    //     if(dp[idx]!=null)return dp[idx];
    //     for(int i=1;i<=arr[idx];i++){
    //         int ans=dfs(arr, idx+i, n);
    //         if(ans!=Integer.MAX_VALUE)ans+=1;

    //         minSteps=Math.min(ans, minSteps);
    //     }
    //     return dp[idx]=minSteps;
    // }

    int dfs_tab(int arr[], int n){

        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                dp[i]=0; //last step pe hai n
                continue; 
            }
            int minSteps = Integer.MAX_VALUE;
            for(int j=1;j<=arr[i];j++){
                int ans = Integer.MAX_VALUE;
                
                if(i+j<n)ans=dp[i+j];
                if(ans!=Integer.MAX_VALUE)ans+=1; //agar pehle hi krdete to Integer.MAX_VALUE mei 1 add krne se issue hojaata

                minSteps = Math.min(ans, minSteps);
            }
            dp[i]=minSteps;
        }
        return dp[0];
    }
}