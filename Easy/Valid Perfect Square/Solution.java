/*367. Valid Perfect Square
Solved
Easy
Topics
premium lock icon
Companies
Given a positive integer num, return true if num is a perfect square or false otherwise.

A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.

You must not use any built-in library function, such as sqrt.

 

Example 1:

Input: num = 16
Output: true
Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
Example 2:

Input: num = 14
Output: false
Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.
 

Constraints:

1 <= num <= 231 - 1
 */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number to check: ");
        int n = sc.nextInt();
        System.out.println(isPerfectSquare(n));
        sc.close();
    }

    public static boolean isPerfectSquare(int num) {
        int start = 1, end = num;
        while(start<=end){
            int mid = start+(end-start)/2;
            if((long)mid*mid==num)return true;
            else if((long)mid*mid<num)start=mid+1;
            else end=mid-1;
        }
        return false;
    }
}