/*You are given a 0-indexed array nums consisiting of positive integers. You can do the following operation on the array any number of times:

Select an index i such that 0 <= i < n - 1 and replace either of nums[i] or nums[i+1] with their gcd value.
Return the minimum number of operations to make all elements of nums equal to 1. If it is impossible, return -1.

The gcd of two integers is the greatest common divisor of the two integers.

 

Example 1:

Input: nums = [2,6,3,4]
Output: 4
Explanation: We can do the following operations:
- Choose index i = 2 and replace nums[2] with gcd(3,4) = 1. Now we have nums = [2,6,1,4].
- Choose index i = 1 and replace nums[1] with gcd(6,1) = 1. Now we have nums = [2,1,1,4].
- Choose index i = 0 and replace nums[0] with gcd(2,1) = 1. Now we have nums = [1,1,1,4].
- Choose index i = 2 and replace nums[3] with gcd(1,4) = 1. Now we have nums = [1,1,1,1].
Example 2:

Input: nums = [2,10,6,14]
Output: -1
Explanation: It can be shown that it is impossible to make all the elements equal to 1.
 

Constraints:

2 <= nums.length <= 50
1 <= nums[i] <= 106 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println("Minimum operations: "+minOperations(arr));
        sc.close();
    }
    public static int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int ele: nums)if(ele==1)count++;

        if(count!=0)return n-count;

        int ops = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            int hcf = nums[i];
            for(int j=i+1;j<n;j++){
                hcf = gcd(hcf, nums[j]);

                if(hcf==1){
                    ops=Math.min(ops, j-i);
                    break;
                }
            }
        }
        if(ops==Integer.MAX_VALUE)return -1;

        return ops+(n-1);
    }

    static int gcd(int a, int b){
        while(a!=0&&b!=0){
            if(a>b)a%=b;
            else b%=a;
        }
        return a==0?b:a;
    }
}