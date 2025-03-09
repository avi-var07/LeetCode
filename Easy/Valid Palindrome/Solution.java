/*A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters. */
import java.util.*;
class Solution {
    static boolean isPalindrome(String s) {
        String s1 = s.toLowerCase();
        StringBuilder s2 = new StringBuilder();
        StringBuilder s3 = new StringBuilder();

        for (int i = 0; i < s1.length(); i++) {
            if (Character.isLetterOrDigit(s1.charAt(i))) {
                s2.append(s1.charAt(i));
            }
        }
        for (int i = s1.length() - 1; i >= 0; i--) {
            if (Character.isLetterOrDigit(s1.charAt(i))) {
                s3.append(s1.charAt(i));
            }
        }

        return s2.toString().equals(s3.toString());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = sc.nextLine();
        System.out.println(isPalindrome(s));
        sc.close();
    }
}
