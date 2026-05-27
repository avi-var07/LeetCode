/*You are given a string word. A letter c is called special if it appears both in lowercase and uppercase in word, and every lowercase occurrence of c appears before the first uppercase occurrence of c.

Return the number of special letters in word.

 

Example 1:

Input: word = "aaAbcBC"

Output: 3

Explanation:

The special characters are 'a', 'b', and 'c'.

Example 2:

Input: word = "abc"

Output: 0

Explanation:

There are no special characters in word.

Example 3:

Input: word = "AbBCab"

Output: 0

Explanation:

There are no special characters in word.

 

Constraints:

1 <= word.length <= 2 * 105
word consists of only lowercase and uppercase English letters. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        String s = sc.nextLine();

        System.out.println(numberOfSpecialChars(s));
        sc.close();
    }
    public static int numberOfSpecialChars(String word) {
        Map<Character, Integer>map = new HashMap<>();
        int n =word.length();
        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            if(Character.isUpperCase(ch))map.putIfAbsent(ch, i);
        }
        boolean ans[] = new boolean[26];
        int cnt=0;
        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            if(Character.isLowerCase(ch)){
                char upper= Character.toUpperCase(ch);
                if(map.containsKey(upper)){
                    int index = map.get(upper);
                    if(index==-1)ans[ch-'a']=false;
                    else if(i<index)ans[ch-'a']=true;
                }
            }
            else map.put(ch, -1);
        }

        for(boolean ele: ans)if(ele)cnt++;

        return cnt;
    }
}