/*You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed and is protected by a security system with a color code.

You are given two integer arrays nums and colors, both of length n, where nums[i] is the amount of money in the ith house and colors[i] is the color code of that house.

You cannot rob two adjacent houses if they share the same color code.

Return the maximum amount of money you can rob.

 

Example 1:

Input: nums = [1,4,3,5], colors = [1,1,2,2]

Output: 9

Explanation:

Choose houses i = 1 with nums[1] = 4 and i = 3 with nums[3] = 5 because they are non-adjacent.
Thus, the total amount robbed is 4 + 5 = 9.
Example 2:

Input: nums = [3,1,2,4], colors = [2,3,2,2]

Output: 8

Explanation:

Choose houses i = 0 with nums[0] = 3, i = 1 with nums[1] = 1, and i = 3 with nums[3] = 4.
This selection is valid because houses i = 0 and i = 1 have different colors, and house i = 3 is non-adjacent to i = 1.
Thus, the total amount robbed is 3 + 1 + 4 = 8.
Example 3:

Input: nums = [10,1,3,9], colors = [1,1,1,2]

Output: 22

Explanation:

Choose houses i = 0 with nums[0] = 10, i = 2 with nums[2] = 3, and i = 3 with nums[3] = 9.
This selection is valid because houses i = 0 and i = 2 are non-adjacent, and houses i = 2 and i = 3 have different colors.
Thus, the total amount robbed is 10 + 3 + 9 = 22.
 

Constraints:

1 <= n == nums.length == colors.length <= 105
1 <= nums[i], colors[i] <= 105

Note: Please do not copy the description during the contest to maintain the integrity of your submissions. */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements of arr (money): ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        
        int colors[] = new int[n];
        
        System.out.println("Enter "+n+" elements of colors: ");
        for(int i=0;i<n;i++) colors[i] = sc.nextInt();

        System.out.println(rob(arr, colors));
        sc.close();
    }
    public static long rob(int[] arr, int[] colors) {
        int n =arr.length;

        long take[] = new long[n];
        long skip[] = new long[n];
        take[0]=arr[0];
        skip[0]=0;
        
        for(int i=1;i<n;i++){

            skip[i]=Math.max(take[i-1], skip[i-1]);

            if(colors[i]==colors[i-1])take[i]=skip[i-1]+arr[i];
            else take[i]=Math.max(take[i-1], skip[i-1])+arr[i];
        }

        return Math.max(take[n-1], skip[n-1]);
    }
}