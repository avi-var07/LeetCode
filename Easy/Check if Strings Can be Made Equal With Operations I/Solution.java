/*You are given two strings s1 and s2, both of length 4, consisting of lowercase English letters.

You can apply the following operation on any of the two strings any number of times:

Choose any two indices i and j such that j - i = 2, then swap the two characters at those indices in the string.
Return true if you can make the strings s1 and s2 equal, and false otherwise.

 

Example 1:

Input: s1 = "abcd", s2 = "cdab"
Output: true
Explanation: We can do the following operations on s1:
- Choose the indices i = 0, j = 2. The resulting string is s1 = "cbad".
- Choose the indices i = 1, j = 3. The resulting string is s1 = "cdab" = s2.
Example 2:

Input: s1 = "abcd", s2 = "dacb"
Output: false
Explanation: It is not possible to make the two strings equal.
 

Constraints:

s1.length == s2.length == 4
s1 and s2 consist only of lowercase English letters.     */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter s1: ");
        String s1 = sc.nextLine();
        System.out.println("Enter s2: ");
        String s2 = sc.nextLine();

        System.out.println(canBeEqual(s1, s2));
        sc.close();
    }
    public static boolean canBeEqual(String s1, String s2) {
        //ya to 02 sirf swap, ya fir 02 13 dono swap, ya fir sirf 13 swap:
        char arr[] = s1.toCharArray();
        if(s1.equals(s2))return true;
        else{
            char temp = arr[0];
            arr[0]=arr[2];
            arr[2]=temp;

            String newString = new String(arr);
            if(newString.equals(s2))return true;
            else{
                char temp1 = arr[1];
                arr[1]=arr[3];
                arr[3]=temp1;
                String newString1 = new String(arr);
                if(newString1.equals(s2))return true;
                else{
                    char temp2 = arr[0];
                    arr[0]=arr[2];
                    arr[2]=temp2;

                    String newString2 = new String(arr);
                    if(newString2.equals(s2))return true;
                    
                }
            }
        }
        return false;
    }
}  