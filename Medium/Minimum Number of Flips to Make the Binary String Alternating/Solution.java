/*You are given a binary string s. You are allowed to perform two types of operations on the string in any sequence:

Type-1: Remove the character at the start of the string s and append it to the end of the string.
Type-2: Pick any character in s and flip its value, i.e., if its value is '0' it becomes '1' and vice-versa.
Return the minimum number of type-2 operations you need to perform such that s becomes alternating.

The string is called alternating if no two adjacent characters are equal.

For example, the strings "010" and "1010" are alternating, while the string "0100" is not.
 

Example 1:

Input: s = "111000"
Output: 2
Explanation: Use the first operation two times to make s = "100011".
Then, use the second operation on the third and sixth elements to make s = "101010".
Example 2:

Input: s = "010"
Output: 0
Explanation: The string is already alternating.
Example 3:

Input: s = "1110"
Output: 1
Explanation: Use the second operation on the second element to make s = "1010".
 

Constraints:

1 <= s.length <= 105
s[i] is either '0' or '1'. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter s: ");
        String s = sc.nextLine();
        System.out.println(minFlips(s));
        sc.close();
    }
    public static int minFlips(String s) {
        int n =s.length();
        //Approach1: s+=s krk
        // s+=s; //saare type1 generate hogye;
        
        // //alternating n size k 2 pattern hoskte, ek 0 se start wala ek 1 start wala:


        //Approach 2: Circular bana kr: %n krk

    //     StringBuilder s1=new StringBuilder();
    //     StringBuilder s2=new StringBuilder();
    //     for(int i=0;i<2*n;i++){
    //         s1.append(i%2==0?'0':'1');
    //         s2.append(i%2==0?'1':'0');
    //     }

    //     int ans= Integer.MAX_VALUE;
    //     int left =0, right=0;
    //     int f1=0, f2=0;

    //     while(right<2*n){
    //         if(s.charAt(right%n)!=s1.charAt(right))f1++;
    //         if(s.charAt(right%n)!=s2.charAt(right))f2++;

    //         if(right-left+1>n){ //shrink
    //             if(s.charAt(left%n)!=s1.charAt(left))f1--;
    //             if(s.charAt(left%n)!=s2.charAt(left))f2--;
    //             left++;
    //         }
    //         if(right-left+1==n)ans=Math.min(ans, Math.min(f1,f2));
    //         right++;
    //     }
    //     return ans;

    //Approach 3: without s1 and s2: s1 is for odd index '0', even index '1', s2 is for odd index '1', even index '0' using expected character

        int ans= Integer.MAX_VALUE;
        int left =0, right=0;
        int f1=0, f2=0;

        while(right<2*n){
            char rightChar =s.charAt(right%n);
            char expS1 = (right%2==0)?'0':'1';
            char expS2 = (right%2==0)?'1':'0';
            if(rightChar!=expS1)f1++;
            if(rightChar!=expS2)f2++;

            if(right-left+1>n){ //shrink
                char leftChar = s.charAt(left%n);
                expS1 = (left%2==0)?'0':'1';
                expS2 = (left%2==0)?'1':'0';
                if(leftChar!=expS1)f1--;
                if(leftChar!=expS2)f2--;
                left++;
            }
            if(right-left+1==n)ans=Math.min(ans, Math.min(f1,f2));
            right++;
        }
        return ans;


    }
}