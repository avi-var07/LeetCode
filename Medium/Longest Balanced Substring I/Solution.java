/*You are given a string s consisting of lowercase English letters.

A substring of s is called balanced if all distinct characters in the substring appear the same number of times.

Return the length of the longest balanced substring of s.

 

Example 1:

Input: s = "abbac"

Output: 4

Explanation:

The longest balanced substring is "abba" because both distinct characters 'a' and 'b' each appear exactly 2 times.

Example 2:

Input: s = "zzabccy"

Output: 4

Explanation:

The longest balanced substring is "zabc" because the distinct characters 'z', 'a', 'b', and 'c' each appear exactly 1 time.​​​​​​​

Example 3:

Input: s = "aba"

Output: 2

Explanation:

​​​​​​​One of the longest balanced substrings is "ab" because both distinct characters 'a' and 'b' each appear exactly 1 time. Another longest balanced substring is "ba".

 

Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter s: ");
        String s =sc.nextLine();
        System.out.println(longestBalanced(s));

        sc.close();
    }
    public static int longestBalanced(String s) {
        int n =s.length();
        //if(n==1)return 1;
        int maxi = 0;
        //brute:

        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         String sub = s.substring(i, j+1);

        //         if(check(sub))maxi=Math.max(maxi, sub.length());
        //     }
        // }

        for(int i=0;i<n;i++){
            int freq[] = new int[26];
            for(int j=i;j<n;j++){
                freq[s.charAt(j)-'a']++;

                if(check(freq))maxi=Math.max(maxi, j-i+1);
            }


        }
        return maxi;
    }
    // static boolean check(String s){
    //     int freq[] = new int[26];
    //     for(char ch: s.toCharArray())freq[ch-'a']++;

    //     int exp=-1;

    //     for(int ele: freq){
    //         if(ele>0){
    //             if(exp==-1)exp=ele;
    //             else if(exp!=ele)return false;
    //         }
    //     }
    //     return true;
    // }
    static boolean check(int freq[]){
      
       int exp=-1;

        for(int ele: freq){
            if(ele>0){
                if(exp==-1)exp=ele;
                else if(exp!=ele)return false;
            }
        }
        return true;
    }
}