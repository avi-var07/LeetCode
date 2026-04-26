/*You are given a string s consisting of lowercase English characters.

Rearrange only the vowels in the string so that they appear in non-increasing order of their frequency.

If multiple vowels have the same frequency, order them by the position of their first occurrence in s.

Return the modified string.

Vowels are 'a', 'e', 'i', 'o', and 'u'.

The frequency of a letter is the number of times it occurs in the string.

 

Example 1:

Input: s = "leetcode"

Output: "leetcedo"

Explanation:​​​​​​​

Vowels in the string are ['e', 'e', 'o', 'e'] with frequencies: e = 3, o = 1.
Sorting in non-increasing order of frequency and placing them back into the vowel positions results in "leetcedo".
Example 2:

Input: s = "aeiaaioooa"

Output: "aaaaoooiie"

Explanation:​​​​​​​

Vowels in the string are ['a', 'e', 'i', 'a', 'a', 'i', 'o', 'o', 'o', 'a'] with frequencies: a = 4, o = 3, i = 2, e = 1.
Sorting them in non-increasing order of frequency and placing them back into the vowel positions results in "aaaaoooiie".
Example 3:

Input: s = "baeiou"

Output: "baeiou"

Explanation:

Each vowel appears exactly once, so all have the same frequency.
Thus, they retain their relative order based on first occurrence, and the string remains unchanged.
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter s: ");
        String s = sc.nextLine();
        System.out.println(sortVowels(s));
        sc.close();
    }
    public static String sortVowels(String s) {
        Set<Character>set = Set.of('a', 'e', 'i', 'o', 'u');
        Map<Character, Integer>map = new HashMap<>(); //vowel->freq
        Map<Character, Integer>idx = new HashMap<>(); //vowel->1st index

        int n =s.length();
        for(int i=0;i<n;i++){
            char ch= s.charAt(i);
            if(set.contains(ch)){
                map.put(ch, map.getOrDefault(ch, 0)+1);
                idx.putIfAbsent(ch, i);
            }
        }
        List<Character>freq = new ArrayList<>(map.keySet()); //list of vowels present in the string for sorting

        Collections.sort(freq, (a,b)->{
            if(map.get(a).equals(map.get(b)))return idx.get(a)-idx.get(b);
            else return map.get(b)-map.get(a); //desc
        });

        List<Character>vowels = new ArrayList<>(); //sorting k baad vowels ka arrangement
        
        for(char ch: freq){
            int cnt =map.get(ch);
            while(cnt-->0)vowels.add(ch);
        }

        StringBuilder sb = new StringBuilder();
        int index=0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(set.contains(ch))sb.append(vowels.get(index++));
            else sb.append(ch);
        }

        return sb.toString();
    }
}