/*You are given an integer array nums of length n and a binary string s of length n, where s[i] == '1' means index i initially contains a token and s[i] == '0' means it does not.

You may perform the following operation any number of times:

Choose a token currently located at index i, where i > 0, such that this token has not been moved before.
Move this token from index i to index i - 1.
An index is considered covered if it contains a token after all moves.

Return an integer denoting the maximum total value of nums at the covered indices after optimally performing the operations.

 

Example 1:

Input: nums = [9,2,6,1], s = "0101"

Output: 15

Explanation:

Initially, indices 1 and 3 contain tokens.
Move the token from index 3 to index 2.
Move the token from index 1 to index 0.
The covered indices are [0, 2], so the total value is nums[0] + nums[2] = 9 + 6 = 15.
Example 2:

Input: nums = [5,1,4], s = "001"

Output: 4

Explanation:

Initially, only index 2 contains a token.
It is optimal to leave the token at index 2.
The covered index is [2], so the total value is nums[2] = 4.
Example 3:

Input: nums = [9,3,5], s = "011"

Output: 14

Explanation:

Initially, indices 1 and 2 contain tokens.
Move the token from index 1 to index 0.
The covered indices are [0, 2], so the total value is nums[0] + nums[2] = 9 + 5 = 14.
 

Constraints:

1 <= n == nums.length == s.length <= 105
1 <= nums[i] <= 105
​​​​​​​s[i] is either '0' or '1' */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println("Enter s: ");
        sc.nextLine();
        String s= sc.nextLine();

        Solution sol =  new Solution();
        System.out.println(sol.maxTotal(arr, s));
        sc.close();
    }
    Long dp[][];
    public long maxTotal(int[] nums, String s) {
        int n =nums.length;
        dp = new Long[n][2];
        return solve(0, 0, nums, s, n);
    }
    long solve(int index, int prev, int arr[], String s, int n){ //prev hai overlap hatane ko
        if(index==n)return 0;
        if(dp[index][prev]!=null)return dp[index][prev];
        long ans=0;
        if(s.charAt(index)=='0')ans=solve(index+1, 0, arr, s, n); //next index pe jao
        else{
            long curr = arr[index]+solve(index+1, 1, arr, s, n);
            ans=Math.max(ans, curr);
            if(index>0&&prev==0){
                long left = arr[index-1]+solve(index+1, 0, arr, s, n);
                ans=Math.max(ans, left);
            }
            
        }
        return dp[index][prev]=ans;
    }
}