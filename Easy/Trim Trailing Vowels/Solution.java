/*You are given a string s that consists of lowercase English letters.

Return the string obtained by removing all trailing vowels from s.

The vowels consist of the characters 'a', 'e', 'i', 'o', and 'u'.

 

Example 1:

Input: s = "idea"

Output: "id"

Explanation:

Removing "idea", we obtain the string "id".

Example 2:

Input: s = "day"

Output: "day"

Explanation:

There are no trailing vowels in the string "day".

Example 3:

Input: s = "aeiou"

Output: ""

Explanation:

Removing "aeiou", we obtain the string "".

 

Constraints:

1 <= s.length <= 100
s consists of only lowercase English letters. */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String s = sc.nextLine();
        System.out.println(trimTrailingVowels(s));
        sc.close();
    }
    public static String trimTrailingVowels(String s) {
        int n =s.length();
        int i =n-1;
        while(i>=0&&isVowel(s.charAt(i)))i--;

        return s.substring(0, i+1);
    }
    static boolean isVowel(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
}