/*You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:

Input: nums = [1,2,3]
Output: 3
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 1000 */

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
        System.out.println(s.rob(arr));
        sc.close();
    }
    //circle ka problem ek hi baat me break hota hai:
//Ya to first house lo
// Ya to last house lo
// Dono ek saath nahi le sakte.

//mtlb 2 problem hue: rob houses 0 to n-2 ya rob houses from 1 to n-1...ans dono ka max!

    public int rob(int[] arr) {
        int n = arr.length;
        if(n==1)return arr[0]; //kyuki n-2 and n-1 tk jaarhe
        Integer dp1[] = new Integer[n];
        Integer dp2[] = new Integer[n];
        int case1 = solve(arr, n, 0, n-2, dp1);
        int case2 = solve(arr, n, 1, n-1, dp2);

        return Math.max(case1, case2);
    }
    int solve(int arr[], int n, int start,int end, Integer dp[]){
        if(start>end)return 0;
        if(dp[start]!=null)return dp[start];
        
        int pick = 0;
        if(start<n)pick+=arr[start]+solve(arr, n, start+2, end, dp);
        int notPick = 0;
        if(start<n)notPick+=solve(arr, n, start+1, end, dp);

        return dp[start]=Math.max(pick, notPick);
    }
}