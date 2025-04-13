/*Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and using only constant extra space.

 

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [3,3,3,3,3]
Output: 3
 

Constraints:

1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
  */
  import java.util.*;
class Solution {
    public static int findDuplicate(int[] nums) {
        int ans = 0;
        int freq[] = new int[nums.length+1];
        for(int i=0;i<nums.length;i++)
        freq[nums[i]]++;

        for(int i=0;i<freq.length;i++){
            if(freq[i]>1)
            ans=i;
        }
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
        int result = findDuplicate(nums);
        System.out.println("The duplicate number is: " + result);
        sc.close();
    }
}