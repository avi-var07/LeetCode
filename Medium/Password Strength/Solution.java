/*You are given a string password.

The strength of the password is calculated based on the following rules:

1 point for each distinct lowercase letter ('a' to 'z').
2 points for each distinct uppercase letter ('A' to 'Z').
3 points for each distinct digit ('0' to '9').
5 points for each distinct special character from the set "!@#$".
Each character contributes at most once, even if it appears multiple times.

Return an integer denoting the strength of the password.

 

Example 1:

Input: password = "aA1!"

Output: 11

Explanation:

The distinct characters are 'a', 'A', '1' and '!'.
Thus, the strength = 1 + 2 + 3 + 5 = 11.
Example 2:

Input: password = "bbB11#"

Output: 11

Explanation:

The distinct characters are 'b', 'B', '1' and '#'.
Thus, the strength = 1 + 2 + 3 + 5 = 11.​​​​​​​
 

Constraints:

1 <= password.length <= 105
password consists of lowercase and uppercase English letters, digits, and special characters from "!@#$". */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter s: ");
        String s = sc.nextLine();

        System.out.println(passwordStrength(s));
        sc.close();
    }
    public static int passwordStrength(String s) {
        int ans=0;

        Set<Character>set = new HashSet<>();


        for(char ch: s.toCharArray())set.add(ch);

        for(char ch: set){
            if(ch>='a'&&ch<='z')ans+=1;
            else if(ch>='A'&&ch<='Z')ans+=2;
            else if(ch>='0'&&ch<='9')ans+=3;
            else ans+=5;
        }

        return ans;
    }
}