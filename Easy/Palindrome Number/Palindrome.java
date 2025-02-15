/*Given an integer x, return true if x is a 
palindrome
, and false otherwise.

 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:

-231 <= x <= 231 - 1 */
import java.util.Scanner;
class Palindrome {
    static boolean isPalindrome(int x) {
        int rev=0, n=x;
        while(n>0){
            int d= n%10;
            rev = rev*10+d;
            n/=10;
        }
        if(rev==x)
        return true;
        
        return false;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int x=sc.nextInt();
        System.out.println(isPalindrome(x));
        sc.close();
    }
}
