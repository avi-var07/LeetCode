/*You are given two strings s1 and s2, both of length n, consisting of lowercase English letters.

You can apply the following operation on any of the two strings any number of times:

Choose any two indices i and j such that i < j and the difference j - i is even, then swap the two characters at those indices in the string.
Return true if you can make the strings s1 and s2 equal, and false otherwise.

 

Example 1:

Input: s1 = "abcdba", s2 = "cabdab"
Output: true
Explanation: We can apply the following operations on s1:
- Choose the indices i = 0, j = 2. The resulting string is s1 = "cbadba".
- Choose the indices i = 2, j = 4. The resulting string is s1 = "cbbdaa".
- Choose the indices i = 1, j = 5. The resulting string is s1 = "cabdab" = s2.
Example 2:

Input: s1 = "abe", s2 = "bea"
Output: false
Explanation: It is not possible to make the two strings equal.
 

Constraints:

n == s1.length == s2.length
1 <= n <= 105
s1 and s2 consist only of lowercase English letters. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter s1: ");
        String s1 = sc.nextLine();
        System.out.println("Enter s2: ");
        String s2 = sc.nextLine();

        System.out.println(checkStrings(s1, s2));
        sc.close();
    }
    public static boolean checkStrings(String s1, String s2) {
        if(s1.equals(s2))return true;

        //ya to even index swap, ya odd index swap, to:
        //agar even index k elements ek se ++ kro, ek se --, mtlb eventually 0 banna hi chhaiye, nhi to wrong hai beteeee
        //same odd k liye
        int odd[] =new int[26];
        int even[] =new int[26];

        int n = s1.length();
        for(int i=0;i<n;i++){
            if(i%2==0){
                even[s1.charAt(i)-'a']++;
                even[s2.charAt(i)-'a']--;
            }
            else{
                odd[s1.charAt(i)-'a']++;
                odd[s2.charAt(i)-'a']--;
            }
        }

        for(int i=0;i<26;i++){
            if(even[i]!=0||odd[i]!=0)return false;
        }
        return true;
    }
}