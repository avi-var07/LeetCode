/*You are given a string s consisting of lowercase English letters and special characters.

Your task is to perform these in order:

Reverse the lowercase letters and place them back into the positions originally occupied by letters.
Reverse the special characters and place them back into the positions originally occupied by special characters.
Return the resulting string after performing the reversals.

 

Example 1:

Input: s = ")ebc#da@f("

Output: "(fad@cb#e)"

Explanation:

The letters in the string are ['e', 'b', 'c', 'd', 'a', 'f']:
Reversing them gives ['f', 'a', 'd', 'c', 'b', 'e']
s becomes ")fad#cb@e("
​​​​​​​The special characters in the string are [')', '#', '@', '(']:
Reversing them gives ['(', '@', '#', ')']
s becomes "(fad@cb#e)"
Example 2:

Input: s = "z"

Output: "z"

Explanation:

The string contains only one letter, and reversing it does not change the string. There are no special characters.

Example 3:

Input: s = "!@#$%^&*()"

Output: ")(*&^%$#@!"

Explanation:

The string contains no letters. The string contains all special characters, so reversing the special characters reverses the whole string.

 

Constraints:

1 <= s.length <= 100
s consists only of lowercase English letters and the special characters in "!@#$%^&*()". */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String s = sc.nextLine();

        System.out.println(reverseByType(s));
        sc.close();
    }
    public static String reverseByType(String s) {

        StringBuilder l = new StringBuilder();
        StringBuilder sp = new StringBuilder();

        for(char ch: s.toCharArray()){
            if(ch>='a'&&ch<='z')l.append(ch);
            else sp.append(ch);
        }

        l.reverse();
        sp.reverse();

        StringBuilder ans = new StringBuilder();
        int i1=0, i2 = 0;

        for(char ch: s.toCharArray()){
            if(ch>='a'&&ch<='z')ans.append(l.charAt(i1++));
            else ans.append(sp.charAt(i2++));
            
        }

        return ans.toString();
    }

}