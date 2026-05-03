/*You are given an integer n.

Let r be the integer formed by reversing the digits of n.

Return the sum of all prime numbers between min(n, r) and max(n, r), inclusive.

 

Example 1:

Input: n = 13

Output: 132

Explanation:

The reverse of 13 is 31. Thus, the range is [13, 31].
The prime numbers in this range are 13, 17, 19, 23, 29, and 31.
The sum of these prime numbers is 13 + 17 + 19 + 23 + 29 + 31 = 132.
Example 2:

Input: n = 10

Output: 17

Explanation:

The reverse of 10 is 1. Thus, the range is [1, 10].
The prime numbers in this range are 2, 3, 5, and 7.
The sum of these prime numbers is 2 + 3 + 5 + 7 = 17.
Example 3:

Input: n = 8

Output: 0

Explanation:

The reverse of 8 is 8. Thus, the range is [8, 8].
There are no prime numbers in this range, so the sum is 0.
 

Constraints:

1 <= n <= 1000
 
 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();

        System.out.println(sumOfPrimesInRange(n));
        
        sc.close();
    }
    public static int sumOfPrimesInRange(int n) {
        int r =rev(n);
        int sum=0;
        int mini = Math.min(n, r);
        int maxi =Math.max(n,r);
        for(int i=mini;i<=maxi;i++)if(prime(i))sum+=i;

        return sum;
        
    }
    static int rev(int n){
        int r=0;
        while(n!=0){
            int d =n%10;
            r=r*10+d;
            n/=10;
        }
        return r;
    }
    static boolean prime(int n){
        if(n<=1)return false;

        for(int i=2;i*i<=n;i++)if(n%i==0)return false;

        return true;
    }
}