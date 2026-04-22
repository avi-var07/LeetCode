/*You are given two string arrays, queries and dictionary. All words in each array comprise of lowercase English letters and have the same length.

In one edit you can take a word from queries, and change any letter in it to any other letter. Find all words from queries that, after a maximum of two edits, equal some word from dictionary.

Return a list of all words from queries, that match with some word from dictionary after a maximum of two edits. Return the words in the same order they appear in queries.

 

Example 1:

Input: queries = ["word","note","ants","wood"], dictionary = ["wood","joke","moat"]
Output: ["word","note","wood"]
Explanation:
- Changing the 'r' in "word" to 'o' allows it to equal the dictionary word "wood".
- Changing the 'n' to 'j' and the 't' to 'k' in "note" changes it to "joke".
- It would take more than 2 edits for "ants" to equal a dictionary word.
- "wood" can remain unchanged (0 edits) and match the corresponding dictionary word.
Thus, we return ["word","note","wood"].
Example 2:

Input: queries = ["yes"], dictionary = ["not"]
Output: []
Explanation:
Applying any two edits to "yes" cannot make it equal to "not". Thus, we return an empty array.
 

Constraints:

1 <= queries.length, dictionary.length <= 100
n == queries[i].length == dictionary[j].length
1 <= n <= 100
All queries[i] and dictionary[j] are composed of lowercase English letters. */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of queries: ");
        int n = sc.nextInt();
        
        System.out.println("Enter number of words of dictionary: ");
        int m = sc.nextInt();

        String queries[] = new String [n];
        String dictionary[] = new String [m];
        System.out.println("Enter "+n+" elements: ");
        sc.nextLine();
        for(int i=0;i<n;i++) queries[i] = sc.nextLine();
        
        System.out.println("Enter words of dictionary: ");
        for(int i=0;i<m;i++) dictionary[i] = sc.nextLine();


        List<String>ans = twoEditWords(queries, dictionary);

        for(String ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    public static List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String>ans = new ArrayList<>();

        for(String ele: queries){
            for(String word: dictionary){
                if(isValid(ele, word)){
                    ans.add(ele);
                    break;
                }
            }
        }
        return ans;
    }
    static boolean isValid(String s1, String s2){
        int n=s1.length();
        int m =s2.length();
        if(n!=m)return false;

        int diff=0;

        for(int i=0;i<n;i++){
            if(s1.charAt(i)!=s2.charAt(i))diff++;
            if(diff>2)return false;
        }

        return true;
    }
}