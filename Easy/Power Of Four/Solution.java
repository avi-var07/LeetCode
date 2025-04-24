/*Given an integer n, return true if it is a power of four. Otherwise, return false.

An integer n is a power of four, if there exists an integer x such that n == 4x.

 

Example 1:

Input: n = 16
Output: true
Example 2:

Input: n = 5
Output: false
Example 3:

Input: n = 1
Output: true
 

Constraints:

-231 <= n <= 231 - 1
  */



import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to check if it is a power of 4:");
        int n = sc.nextInt();
        System.out.println(isPowerOfFour(n));
        sc.close();
    }
    public static boolean isPowerOfFour(int n) {
        return n > 0 &&
                (n & (n - 1)) == 0 &&   // check if n is a power of 2
                (n & 0x55555555) != 0;  //0x55555555 is a mask for 4's powers, check whether the only set bit is in the even position
     }
}