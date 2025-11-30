/*You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr).

Return the maximum absolute sum of any (possibly empty) subarray of nums.

Note that abs(x) is defined as follows:

If x is a negative integer, then abs(x) = -x.
If x is a non-negative integer, then abs(x) = x.
 

Example 1:

Input: nums = [1,-3,2,3,-4]
Output: 5
Explanation: The subarray [2,3] has absolute sum = abs(2+3) = abs(5) = 5.
Example 2:

Input: nums = [2,-5,1,-4,3,-2]
Output: 8
Explanation: The subarray [-5,1,-4] has absolute sum = abs(-5+1-4) = abs(-8) = 8.
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
 
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

        System.out.println(maxAbsoluteSum(arr));
        sc.close();
    }
    public static int maxAbsoluteSum(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];
        int n = nums.length;
        for(int i = 1;i<n;i++){
            currSum = Math.max(nums[i], currSum+nums[i]);
            maxSum = Math.max(currSum, maxSum);
        }
        int maxi = Math.abs(maxSum);
        
        currSum = nums[0];
        maxSum = nums[0];
        for(int i = 1;i<n;i++){
            currSum = Math.min(nums[i], currSum+nums[i]);
            maxSum = Math.min(currSum, maxSum);
        }
        int mini = Math.abs(maxSum);
        return Math.max(maxi, mini);
    }
}