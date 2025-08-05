/*Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

Return the minimized largest sum of the split.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
Example 2:

Input: nums = [1,2,3,4,5], k = 2
Output: 9
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
 

Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 106
1 <= k <= min(50, nums.length)
 */
import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements:");
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) 
        arr[i] = sc.nextInt();
        
        System.out.println("Enter the value of k: ");
        int k = sc.nextInt();

        System.out.println("Minimum of maximum sum of ele is: "+splitArray(arr, k));
        sc.close();
    }

    public static int splitArray(int[] nums, int k) {
        int maxi = nums[0], sum=0;
        for(int ele: nums){
            if(ele>maxi)maxi=ele;
            sum+=ele;

        }
        while(maxi<=sum){
            int mid = maxi+(sum-maxi)/2;
            if(canSplit(nums, mid)>k)maxi=mid+1;
            else sum=mid-1;
        }
        return maxi;
    }
    static int canSplit(int arr[], int total){
        int split=1, lastSplit=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]+lastSplit<=total)lastSplit+=arr[i];
            else{
                split++;
                lastSplit=arr[i];
            }
        }
        return split;
    }
}