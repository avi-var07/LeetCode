/*Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15
 

Constraints:

1 <= nums.length <= 3 * 104
nums[i] is either 0 or 1.
0 <= goal <= nums.length */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println("Enter goal: ");
        int k = sc.nextInt();
        System.out.println(numSubarraysWithSum(arr, k));
        
        sc.close();
    }
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return count(nums, goal)-count(nums, goal-1);
    }
    static int count(int arr[], int goal){
        if(goal<0)return 0;
        int l = 0, r=0, sum=0,ans=0;
        int n= arr.length;
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