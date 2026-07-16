/*You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:

The length of the subarray is k, and
All the elements of the subarray are distinct.
Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,5,4,2,9,9,9], k = 3
Output: 15
Explanation: The subarrays of nums with length 3 are:
- [1,5,4] which meets the requirements and has a sum of 10.
- [5,4,2] which meets the requirements and has a sum of 11.
- [4,2,9] which meets the requirements and has a sum of 15.
- [2,9,9] which does not meet the requirements because the element 9 is repeated.
- [9,9,9] which does not meet the requirements because the element 9 is repeated.
We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions
Example 2:

Input: nums = [4,4,4], k = 3
Output: 0
Explanation: The subarrays of nums with length 3 are:
- [4,4,4] which does not meet the requirements because the element 4 is repeated.
We return 0 because no subarrays meet the conditions.
 

Constraints:

1 <= k <= nums.length <= 105
1 <= nums[i] <= 105 */
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
        int k=sc.nextInt();

        System.out.println(maximumSubarraySum(arr, k));
        sc.close();
    }
    //     public long maximumSubarraySum(int[] nums, int k) {
//         int n =nums.length;
//         Map<Integer, Integer>map = new HashMap<>();
//         long ans = Long.MIN_VALUE;
//         for(int i=0;i<=n-k;i++){
//             long sum =0;
//             boolean valid=true;
//             for(int j=i;j<i+k;j++){
//                 if(map.containsKey(nums[j])){
//                     valid=false;
//                     break;
//                 }
                
//                 map.put(nums[j], 1);
//                 sum+=nums[j];
                
//             }
//             if(valid)ans=Math.max(ans, sum);
//             map.clear();
//         }
//         return ans==Long.MIN_VALUE?0:ans;
//     }
// }
    public static long maximumSubarraySum(int[] nums, int k) {
        int n =nums.length;
        long ans=0;
        Set<Integer>set = new HashSet<>();
        long curr=0;
        int l =0, r=0;

        while(r<n){
            while(set.contains(nums[r])){
                set.remove(nums[l]);
                curr-=nums[l];
                l++;
            }
            set.add(nums[r]);
            curr+=nums[r];
            if(r-l+1==k){
                ans= Math.max(ans, curr);
                set.remove(nums[l]);
                curr-=nums[l];
                l++;
            }
            r++;
            
        }
        return ans;
    }
}