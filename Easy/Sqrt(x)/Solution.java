/*69. Sqrt(x)
Solved
Easy
Topics
premium lock icon
Companies
Hint
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 

Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 

Constraints:

0 <= x <= 231 - 1 */


import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int n = sc.nextInt();
        System.out.println("Square Root is: "+ mySqrt(n));
        sc.close();
    }
    public static int mySqrt(int n) {
        if (n == 0 || n == 1) return n;
        int start = 1, end = n,ans=0;
        while(start<=end){
            int mid = start+(end-start)/2;

            if((long)mid*mid==n)return mid;
            else if((long)mid*mid<n){
                ans=mid;
                start=mid+1;
            }
            else end=mid-1;
        }
        return ans;
    }
}