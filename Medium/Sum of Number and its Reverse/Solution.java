/*Given a non-negative integer num, return true if num can be expressed as the sum of any non-negative integer and its reverse, or false otherwise.

 

Example 1:

Input: num = 443
Output: true
Explanation: 172 + 271 = 443 so we return true.
Example 2:

Input: num = 63
Output: false
Explanation: 63 cannot be expressed as the sum of a non-negative integer and its reverse so we return false.
Example 3:

Input: num = 181
Output: true
Explanation: 140 + 041 = 181 so we return true. Note that when a number is reversed, there may be leading zeros.
 

Constraints:

0 <= num <= 105 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();
        System.out.println(sumOfNumberAndReverse(n));
        sc.close();
    }
    public static boolean sumOfNumberAndReverse(int num) {
        for(int i=num/2;i<=num;i++)if(i+rev(i)==num)return true;
        // for(int i=0;i<=num;i++){
        //     if(i+rev(i)==num)return true;
        // }
        return false;
    }
    static int rev(int n){
        int rev=0;
        while(n>0){
            int d = n%10;
            rev = rev*10+d;
            n/=10;
        }
        return rev;
    }
}