/*Given an integer array nums, return the maximum possible sum of elements of the array such that it is divisible by three.

 

Example 1:

Input: nums = [3,6,5,1,8]
Output: 18
Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).
Example 2:

Input: nums = [4]
Output: 0
Explanation: Since 4 is not divisible by 3, do not pick any number.
Example 3:

Input: nums = [1,2,3,4,4]
Output: 12
Explanation: Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum divisible by 3).
 

Constraints:

1 <= nums.length <= 4 * 104
1 <= nums[i] <= 104
 
 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println(maxSumDivThree(arr));
        sc.close();
    }
    public static int maxSumDivThree(int[] nums) {
        Integer dp[][] = new Integer[nums.length][3];
        return solve(nums, 0, 0, dp);
    }
    static int solve(int arr[], int index, int rem, Integer dp[][]){
        if(index==arr.length)return rem==0?0:-1;
        
        if(dp[index][rem]!=null)return dp[index][rem];

        int pick = solve(arr,index+1,(rem+arr[index])%3, dp);
        if(pick!=-1)pick+=arr[index];
        
        int notPick = solve(arr,index+1, rem, dp);

        int result = Math.max(pick, notPick);
        dp[index][rem] = result;

        return dp[index][rem];
    }
}