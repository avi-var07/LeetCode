/*Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 

Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104
 

Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)). */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println("Enter target: ");
        int target = sc.nextInt();

        System.out.println(minSubArrayLen(target, arr));
        sc.close();
    }
    public static int minSubArrayLen(int target, int[] arr) {
        int left = 0, right =0;
        int n = arr.length;
        
        int sum = 0;
        int ans =Integer.MAX_VALUE;
        while(right<n){
            sum+=arr[right];
            while(sum>=target){
                ans=Math.min(ans, right-left+1);
                sum-=arr[left];
                left++;
            }
            
            right++;
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}