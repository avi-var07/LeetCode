/*You are given an integer array nums and a positive integer k.

Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.

A subarray is a contiguous sequence of elements within an array.

 

Example 1:

Input: nums = [1,3,2,3,3], k = 2
Output: 6
Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].
Example 2:

Input: nums = [1,4,2,1], k = 3
Output: 0
Explanation: No subarray contains the element 4 at least 3 times.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 106
1 <= k <= 105
 
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

        System.out.println("Enter k: ");
        int k = sc.nextInt();

        System.out.println(countSubarrays(arr, k));
        sc.close();
    }
    public static long countSubarrays(int[] nums, int k) {
        long ans=0;
        int maxi = nums[0];
        for(int ele: nums)if(ele>maxi)maxi=ele;

        int countMaxi = 0;

        int l =0, r=0;

        int n = nums.length;
        while(r<n){
            if(nums[r]==maxi)countMaxi++;

            while(countMaxi>=k){
                ans+=n-r;
                if(nums[l]==maxi)countMaxi--;
                l++;
            }
            
            r++;
        }
        return ans;
    }
}