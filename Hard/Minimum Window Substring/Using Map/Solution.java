/*Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 

Follow up: Could you find an algorithm that runs in O(m + n) time?

 
 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String s: ");
        String s = sc.nextLine();        
        System.out.println("Enter String t: ");
        String t= sc.nextLine();        
        System.out.println(minWindow(s, t));
        sc.close();
    }
    public static String minWindow(String s, String t) {
        int m = t.length();
        int n = s.length();
        int l = 0, r= 0, minLen = Integer.MAX_VALUE, sInd = -1, count=0;
        Map<Character, Integer>map = new HashMap<>();
        for(char ele: t.toCharArray())map.put(ele, map.getOrDefault(ele,0)+1);

        while(r<n){
            char ch = s.charAt(r);
            if(map.containsKey(ch)&&map.get(ch)>0)count++;
            map.put(ch, map.getOrDefault(ch,0)-1);
            while(count==m){
                int len =r-l+1;
                if(len<minLen){
                    minLen = len;
                    sInd = l;
                }
                char left = s.charAt(l);
                map.put(left, map.get(left)+1);
                if(map.get(left)>0)count--;
                l++;
            }
            r++;
        }
        return sInd==-1?"":s.substring(sInd, sInd+minLen);
    }
}