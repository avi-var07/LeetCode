/*Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.

 

Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.
Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16
 

Constraints:

1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length */
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
        System.out.println(numberOfSubarrays(arr, k));
        sc.close();
    }
    public static int numberOfSubarrays(int[] nums, int k) {
        for(int i=0;i<nums.length;i++)nums[i] = nums[i]%2;
        return count(nums, k)-count(nums, k-1);
    }
    static int count(int arr[], int goal){
        if(goal<0)return 0;
        int l =0, r=0, sum =0, ans=0;
        int n = arr.length;
        while(r<n){
            sum+=arr[r];
            while(sum>goal){
                sum-=arr[l];
                l++;
            }
            ans+=(r-l+1);
            r++;
        }
        return ans;
    }
}