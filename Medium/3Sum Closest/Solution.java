/* Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 

Constraints:

3 <= nums.length <= 500
-1000 <= nums[i] <= 1000
-104 <= target <= 104*/

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
        
        System.out.println("Enter target: ");

        int target  =  sc.nextInt();

        System.out.println("3Sum Closest is : "+ threeSumClosest(arr, target));
        
        sc.close();
    }
    static public int threeSumClosest(int[] nums, int target) {
        int closestSum =  nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){
            int j = i+1, k=nums.length-1;

            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];

                if(sum==target)return target;

                int diff1 = Math.abs(target-sum);
                int diff2 = Math.abs(closestSum - target);

                if(diff1<diff2)closestSum = sum;
                
                if(sum<target)j++;
                else k--;
            }
        }

        return closestSum;
    }
}