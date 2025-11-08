/*Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

 

Example 1:

Input: num1 = "11", num2 = "123"
Output: "134"
Example 2:

Input: num1 = "456", num2 = "77"
Output: "533"
Example 3:

Input: num1 = "0", num2 = "0"
Output: "0"
 

Constraints:

1 <= num1.length, num2.length <= 104
num1 and num2 consist of only digits.
num1 and num2 don't have any leading zeros except for the zero itself.
 
 */

 import java.util.*;
 
 class Solution{
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter num1: ");
        String num1 = sc.nextLine();
        System.out.println("Enter num2: ");
        String num2 = sc.nextLine();
        
        System.out.println(addStrings(num1, num2));
         sc.close();
     }
    public static String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int p1 = num1.length()-1;
        int p2 = num2.length()-1;
        int carry = 0;
        while(p1>=0 || p2>=0){
            int sum = 0, s1=0, s2=0,base=10;
            if(p1>=0)s1=num1.charAt(p1--)-'0';
            if(p2>=0)s2=num2.charAt(p2--)-'0';
            sum=s1+s2+carry;
            if(sum>=base){
                carry=1;
                sum-=base;
            }
            else carry=0;
            res.append(sum);
        }
        if(carry!=0)res.append(1);

        return res.reverse().toString();
    }
 }