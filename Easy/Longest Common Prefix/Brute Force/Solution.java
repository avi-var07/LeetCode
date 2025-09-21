/*Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty. */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Strings: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " Strings:");
        String arr[] = new String[n];
        for(int i = 0; i < n; i++) 
        arr[i] = sc.next();
        System.out.println("Longest Common Prefix is: "+longestCommonPrefix(arr));
        
        
        sc.close();
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs[0].length()==0)return "";
        
        if(strs.length==0)return "";
        
        if(strs.length==1)return strs[0];
        String temp = strs[0];
        
        for(int i = 0;i<temp.length();i++){
            char ch = temp.charAt(i);
            
            for(int j=1;j<strs.length;j++){
                if(i>=strs[j].length()||strs[j].charAt(i)!=ch)return temp.substring(0, i);
            }
        }
        return temp;
    }
}