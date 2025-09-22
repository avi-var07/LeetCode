/*Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"

Output: true

Explanation:

The strings s and t can be made identical by:

Mapping 'e' to 'a'.
Mapping 'g' to 'd'.
Example 2:

Input: s = "foo", t = "bar"

Output: false

Explanation:

The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

Example 3:

Input: s = "paper", t = "title"

Output: true

 

Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character. */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first String: ");
        String str1 = sc.nextLine();
        System.out.println("Enter second String: ");
        String str2 = sc.nextLine();
        System.out.println(isIsomorphic(str1, str2));
        sc.close();
    }
    public static boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())return false;
        Map<Character, Character> map = new HashMap<>();

        for(int i = 0; i<s.length();i++){
            char original = s.charAt(i);
            char replaced = t.charAt(i);
            if(!map.containsKey(original)){
                if(!map.containsValue(replaced))map.put(original, replaced);
                else return false;
            }
            else{
                char present = map.get(original);
                if(replaced!=present)return false;
            }
        }
        return true;
    }
}