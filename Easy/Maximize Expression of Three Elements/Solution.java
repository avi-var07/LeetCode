/*You are given an integer array nums.

Choose three elements a, b, and c from nums at distinct indices such that the value of the expression a + b - c is maximized.

Return an integer denoting the maximum possible value of this expression.

 

Example 1:

Input: nums = [1,4,2,5]

Output: 8

Explanation:

We can choose a = 4, b = 5, and c = 1. The expression value is 4 + 5 - 1 = 8, which is the maximum possible.

Example 2:

Input: nums = [-2,0,5,-2,4]

Output: 11

Explanation:

We can choose a = 5, b = 4, and c = -2. The expression value is 5 + 4 - (-2) = 11, which is the maximum possible.

 

Constraints:

3 <= nums.length <= 100
-100 <= nums[i] <= 100 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println(maximizeExpressionOfThree(arr));
        sc.close();
    }
    public static int maximizeExpressionOfThree(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j = 0;j<n;j++){
                for(int k = 0;k<n;k++){
                    int a = nums[i];
                    int b = nums[j];
                    int c = nums[k];
                    if(i!=j&&j!=k){
                        int diff = a+b-c;
                        if(diff>maxi)maxi=diff;
                    }
                    
                }
            }
        }
        return maxi;
    }
}