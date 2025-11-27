/*You are given an array of integers nums and an integer k.

Return the maximum sum of a subarray of nums, such that the size of the subarray is divisible by k.

 

Example 1:

Input: nums = [1,2], k = 1

Output: 3

Explanation:

The subarray [1, 2] with sum 3 has length equal to 2 which is divisible by 1.

Example 2:

Input: nums = [-1,-2,-3,-4,-5], k = 4

Output: -10

Explanation:

The maximum sum subarray is [-1, -2, -3, -4] which has length equal to 4 which is divisible by 4.

Example 3:

Input: nums = [-5,1,2,-3,4], k = 2

Output: 4

Explanation:

The maximum sum subarray is [1, 2, -3, 4] which has length equal to 4 which is divisible by 2.

 

Constraints:

1 <= k <= nums.length <= 2 * 105
-109 <= nums[i] <= 109 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        System.out.println("Enter k: ");
        int k =sc.nextInt();
        System.out.println(maxSubarraySum(arr, k));
        
        sc.close();
    }
    public static long maxSubarraySum(int[] nums, int k) {
        long ans = Long.MIN_VALUE;
        int n = nums.length;

        long ps[] = new long[n];
        ps[0] = nums[0];
        for(int i=1;i<n;i++)ps[i]=ps[i-1]+nums[i];

        for(int start=0;start<k;start++){
            long currSum = 0;

            int i =start;
            while(i<n&&i+k-1<n){
                int j = i+k-1;
                long subSum = ps[j]-(i>0?ps[i-1]:0);
                currSum = Math.max(subSum, currSum+subSum);
                ans = Math.max(ans, currSum);
                i+=k;
            }
        }
        return ans;
    }
}