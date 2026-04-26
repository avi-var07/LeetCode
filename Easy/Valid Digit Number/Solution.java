/*You are given an integer n and a digit x.

A number is considered valid if:

It contains at least one occurrence of digit x, and
It does not start with digit x.
Return true if n is valid, otherwise return false.

 

Example 1:

Input: n = 101, x = 0

Output: true

Explanation:

The number contains digit 0 at index 1. It does not start with 0, so it satisfies both conditions. Thus, the answer is true​​​​​​​.

Example 2:

Input: n = 232, x = 2

Output: false

Explanation:

The number starts with 2, which violates the condition. Thus, the answer is false.

Example 3:

Input: n = 5, x = 1

Output: false

Explanation:

The number does not contain digit 1. Thus, the answer is false.

 

Constraints:

0 <= n <= 105​​​​​​​
0 <= x <= 9 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();

        System.out.println("Enter x: ");
        int x=sc.nextInt();

        System.out.println(validDigit(n, x));
        sc.close();
    }
    public static boolean validDigit(int n, int x) {
        // String str = String.valueOf(n);
        // if(str.charAt(0)-'0'==x)return false;

        // while(n!=0){
        //     int d = n%10;
        //     if(d==x)return true;
        //     n/=10;
        // }
        // return false;
        boolean found = false;
        while(n>9){
            if(n%10==x)found=true;
            n/=10;
        }
        return found&&n!=x;
    }
}