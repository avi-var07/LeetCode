/*Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.

The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.

 

Example 1:

Input: nums = [2,5,6,9,10]
Output: 2
Explanation:
The smallest number in nums is 2.
The largest number in nums is 10.
The greatest common divisor of 2 and 10 is 2.
Example 2:

Input: nums = [7,5,6,8,3]
Output: 1
Explanation:
The smallest number in nums is 3.
The largest number in nums is 8.
The greatest common divisor of 3 and 8 is 1.
Example 3:

Input: nums = [3,3]
Output: 3
Explanation:
The smallest number in nums is 3.
The largest number in nums is 3.
The greatest common divisor of 3 and 3 is 3. */

import java.util.*;

class Solution {
    public static int findGCD(int[] nums) {
        int maxi  = nums[0] , mini = nums[0];
        for(int ele:nums){
            if(ele>maxi)maxi=ele;
            if(ele<mini)mini=ele;
        }
        int ans = gcd(maxi,mini);
        return ans;
    }
    public static int gcd(int a, int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the array:");
        int[] nums = new int[n];
        for(int i=0;i<n;i++) nums[i] = sc.nextInt();
    
        System.out.println("The gcd is: "+findGCD(nums));
        sc.close();
    }
}