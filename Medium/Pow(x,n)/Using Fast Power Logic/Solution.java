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
        double base, res=1;
        long power=n;
        if(power==0)return 1;
        if(power==1)return x;
        
        if(power<0){
            base=1/x;
            power*=-1;
        }
        else base =x;

        while(power>0){
            if(power%2==1)res*=base;
            base*=base;
            power=power>>1;
        }

        return res;

    }
}