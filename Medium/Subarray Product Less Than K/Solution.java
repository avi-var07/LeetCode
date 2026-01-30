/*Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

 

Example 1:

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Example 2:

Input: nums = [1,2,3], k = 0
Output: 0
 

Constraints:

1 <= nums.length <= 3 * 104
1 <= nums[i] <= 1000
0 <= k <= 106 */

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
        int  k =sc.nextInt();

        System.out.println(numSubarrayProductLessThanK(arr, k));
        sc.close();
    }
    public static int numSubarrayProductLessThanK(int[] arr, int k) {
        int left = 0, right = 0;
        int  n  =arr.length;
        int product =1;
        int ans =0;
        while(right<n){
            product*=arr[right];
            while(product>=k&&left<=right){
                product/=arr[left];
                left++;
            }
            ans+= right-left+1;
            right++;
        }
        return ans;
    }
}