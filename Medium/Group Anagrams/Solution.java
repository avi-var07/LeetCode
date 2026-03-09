/*Given an array of strings strs, group the anagrams together. You can return the answer in any order.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]

 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        String arr[] = new String[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.next();

        List<List<String>>ans = groupAnagrams(arr);

        for(var ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>>map = new HashMap<>();

        for(String ele: strs){
            char arr[]=ele.toCharArray();

            Arrays.sort(arr);

            String key = new String(arr);

            if(!map.containsKey(key))map.put(key, new ArrayList<>());

            map.get(key).add(ele);
        }
        return new ArrayList<>(map.values());

        // Map<String, List<String>>map =new HashMap<>();
        // for(String ele: strs){
        //     int freq[] = new int[26];
        //     for(char ch: ele.toCharArray())freq[ch-'a']++;

        //     StringBuilder key = new StringBuilder();
        //     for(int f: freq)key.append("#").append(f);

        //     String k = key.toString();
        //     if(!map.containsKey(k))map.put(k, new ArrayList<>());

        //     map.get(k).add(ele);
        // }
        // return new ArrayList<>(map.values());
    }
}