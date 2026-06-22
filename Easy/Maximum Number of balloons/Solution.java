/*Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.

 

Example 1:



Input: text = "nlaebolko"
Output: 1
Example 2:



Input: text = "loonbalxballpoon"
Output: 2
Example 3:

Input: text = "leetcode"
Output: 0
 

Constraints:

1 <= text.length <= 104
text consists of lower case English letters only. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text =sc.nextLine();
        System.out.println(maxNumberOfBalloons(text));
        sc.close();
    }
    public static int maxNumberOfBalloons(String text) {
        int b= 0;
        int a= 0;
        int l= 0;
        int o= 0;
        int n= 0;

        for(char ch: text.toCharArray()) {
            if(ch == 'b') b++;
            else if(ch == 'a') a++;
            else if(ch == 'l') l++;
            else if(ch == 'o') o++;
            else if(ch == 'n') n++;
        }
        return Math.min(Math.min(b, a), Math.min(n, Math.min(l/2, o/2)));
    }
}