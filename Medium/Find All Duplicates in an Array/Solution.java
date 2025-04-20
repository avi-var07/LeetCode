/*Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears at most twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant auxiliary space, excluding the space needed to store the output

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
Example 2:

Input: nums = [1,1,2]
Output: [1]
Example 3:

Input: nums = [1]
Output: []
 

Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
Each element in nums appears once or twice. */

import java.util.*;
class Solution {
    public static List<Integer> findDuplicates(int[] nums) {
        int i=0, n=nums.length;
        while(i<n){
            int corrected = nums[i]-1;
            if(nums[i]!=nums[corrected]){
                int temp=nums[i];
                nums[i]=nums[corrected];
                nums[corrected]=temp;
            }
            else i++;
        }
        List<Integer>ans=new ArrayList<>();
        for(int j=0;j<n;j++) if(nums[j]!=j+1) ans.add(nums[j]);

        return ans;

    
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        List<Integer>result = findDuplicates(nums);
        System.out.println("The duplicate number is: " + result);
        sc.close();
    }
}
