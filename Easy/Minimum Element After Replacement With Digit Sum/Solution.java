/*You are given an integer array nums.

You replace each element in nums with the sum of its digits.

Return the minimum element in nums after all replacements.

 

Example 1:

Input: nums = [10,12,13,14]

Output: 1

Explanation:

nums becomes [1, 3, 4, 5] after all replacements, with minimum element 1.

Example 2:

Input: nums = [1,2,3,4]

Output: 1

Explanation:

nums becomes [1, 2, 3, 4] after all replacements, with minimum element 1.

Example 3:

Input: nums = [999,19,199]

Output: 10

Explanation:

nums becomes [27, 10, 19] after all replacements, with minimum element 10.

 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 104 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println(minElement(arr));
        sc.close();
    }
    public static int minElement(int[] nums) {
        int n =nums.length;
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            nums[i]=sum(nums[i]);
            mini=Math.min(mini, nums[i]);
        }
        return mini;
    }
    static int sum(int ele){
        int sum=0;
        while(ele!=0){
            int d=ele%10;
            sum+=d;
            ele/=10;
        }
        return sum;
    }
}