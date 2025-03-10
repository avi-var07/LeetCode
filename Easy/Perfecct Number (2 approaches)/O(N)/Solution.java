/*A perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number itself. A divisor of an integer x is an integer that can divide x evenly.

Given an integer n, return true if n is a perfect number, otherwise return false.

 

Example 1:

Input: num = 28
Output: true
Explanation: 28 = 1 + 2 + 4 + 7 + 14
1, 2, 4, 7, and 14 are all divisors of 28.
Example 2:

Input: num = 7
Output: false
 

Constraints:

1 <= num <= 108 */
import java.util.*;
class Solution {
    static boolean checkPerfectNumber(int num) {
        int sum=0;
        
        for(int i=1;i<num;i++){
            if(num%i==0)
            sum+=i;
        }
        if(sum==num)
        return true;
        return false;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number:");
        int num=sc.nextInt();
        System.out.println(checkPerfectNumber(num));
        sc.close();
    }
}