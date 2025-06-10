/*You are given a string s consisting of lowercase English letters.

Your task is to find the maximum difference diff = freq(a1) - freq(a2) between the frequency of characters a1 and a2 in the string such that:

a1 has an odd frequency in the string.
a2 has an even frequency in the string.
Return this maximum difference.

 

Example 1:

Input: s = "aaaaabbc"

Output: 3

Explanation:

The character 'a' has an odd frequency of 5, and 'b' has an even frequency of 2.
The maximum difference is 5 - 2 = 3.
Example 2:

Input: s = "abcabcab"

Output: 1

Explanation:

The character 'a' has an odd frequency of 3, and 'c' has an even frequency of 2.
The maximum difference is 3 - 2 = 1.
 

Constraints:

3 <= s.length <= 100
s consists only of lowercase English letters.
s contains at least one character with an odd frequency and one with an even frequency.
 */

 import java.util.*;
 
 class Solution {
     public static void main(String args[]) {
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter string: ");
         String str = sc.nextLine();
         System.out.println("Maximum difference between odd and even max freq is: "+maxDifference(str));
         sc.close();
     }
     public static int maxDifference(String s) {
      Map<Character, Integer> mp = new HashMap<>();

      for(char ch : s.toCharArray())
      mp.put(ch, mp.getOrDefault(ch,0)+1);

      ArrayList<Integer> even = new ArrayList<>();
      ArrayList<Integer> odd = new ArrayList<>();

      for(var ele: mp.entrySet()){
        if(ele.getValue()%2==0)
        even.add(ele.getValue());
        else odd.add(ele.getValue());
      }

      int maxDiff = Integer.MIN_VALUE;

      for(int oddFreq: odd){
        for(int evenFreq: even)
        if(oddFreq-evenFreq>maxDiff)maxDiff=oddFreq-evenFreq;
      }

      return maxDiff;
    }
 }

//TC is O(N)
//SC is O(1) but uses HashMap and ArrayList!