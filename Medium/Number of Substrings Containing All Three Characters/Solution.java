/*Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
Example 3:

Input: s = "abc"
Output: 1
 

Constraints:

3 <= s.length <= 5 x 10^4
s only consists of a, b or c characters.
  */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String s = sc.nextLine();
        System.out.println(numberOfSubstrings(s));
        sc.close();
    }
    public static int numberOfSubstrings(String s) {
        int ans = 0, n = s.length();
        int lastSeen[] = {-1,-1,-1};
        for(int i = 0;i<n;i++){
            lastSeen[s.charAt(i)-'a']=i;
            ans+=1+(Math.min(lastSeen[0],Math.min(lastSeen[1],lastSeen[2])));
        }
        return ans;
    }
}