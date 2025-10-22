/*Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
n is an integer.
Either x is not zero or n > 0.
-104 <= xn <= 104 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter base: ");
        int x = sc.nextInt();
        System.out.println("Enter power to raise: ");
        int n = sc.nextInt();

        System.out.println(myPow(x, n));

        
        sc.close();
    }
    public static double myPow(double x, int n) {
        long N = n;
        if(N<0){
            x=1/x;
            N=-N;
        }

        return power(x, N);
    }
    static double power(double x, long n){
        if(n==0)return 1;

        double temp = power(x,n/2);
        if(n%2==0)return temp*temp;
        else return x*temp*temp; 
    }
}