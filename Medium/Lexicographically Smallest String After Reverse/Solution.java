/*You are given a string s of length n consisting of lowercase English letters.

You must perform exactly one operation by choosing any integer k such that 1 <= k <= n and either:

reverse the first k characters of s, or
reverse the last k characters of s.
Return the lexicographically smallest string that can be obtained after exactly one such operation.

A string a is lexicographically smaller than a string b if, at the first position where they differ, a has a letter that appears earlier in the alphabet than the corresponding letter in b. If the first min(a.length, b.length) characters are the same, then the shorter string is considered lexicographically smaller.

 

Example 1:

Input: s = "dcab"

Output: "acdb"

Explanation:

Choose k = 3, reverse the first 3 characters.
Reverse "dca" to "acd", resulting string s = "acdb", which is the lexicographically smallest string achievable.
Example 2:

Input: s = "abba"

Output: "aabb"

Explanation:

Choose k = 3, reverse the last 3 characters.
Reverse "bba" to "abb", so the resulting string is "aabb", which is the lexicographically smallest string achievable.
Example 3:

Input: s = "zxy"

Output: "xzy"

Explanation:

Choose k = 2, reverse the first 2 characters.
Reverse "zx" to "xz", so the resulting string is "xzy", which is the lexicographically smallest string achievable.
 

Constraints:

1 <= n == s.length <= 1000
s consists of lowercase English letters.

Note: Please do not copy the description during the contest to maintain the integrity of your submissions. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String s = sc.nextLine();
        System.out.println("Lexicographically smallest possible string is: "+lexSmallest(s));
        sc.close();
    }
    public static String lexSmallest(String s) {
        String smallest = s;
        
        for(int i=1;i<=s.length();i++){
            String first = new StringBuilder(s.substring(0,i)).reverse().toString()+s.substring(i);
            String last  = s.substring(0, s.length()-i)+ new StringBuilder(s.substring(s.length()-i)).reverse().toString();

            if(first.compareTo(smallest)<0)smallest=first;
            if(last.compareTo(smallest)<0)smallest=last;
        }
        return smallest;
    }
}