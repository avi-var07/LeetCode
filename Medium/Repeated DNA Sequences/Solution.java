/*The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.

 

Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
Example 2:

Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]
 

Constraints:

1 <= s.length <= 105
s[i] is either 'A', 'C', 'G', or 'T'. */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter s: ");
        String s = sc.nextLine();
        List<String>ans = findRepeatedDnaSequences(s);

        for(String ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    static List<String> findRepeatedDnaSequences(String s){
        int n = s.length();
        int k =10;
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<k;i++)sb.append(s.charAt(i));

        List<String>ans = new ArrayList<>();
        Map<String, Integer>map = new HashMap<>();
        map.put(sb.toString(), 1);
        for(int i=k;i<n;i++){
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));

            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
            if(map.get(sb.toString())==2)ans.add(sb.toString());    //exactly 2

        }   
        return ans;
    }
}