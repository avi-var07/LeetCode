/*Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

 

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 

Constraints:

1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself. */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String s = sc.nextLine();

        System.out.println("Enter k: ");
        int k  =sc.nextInt();

        System.out.println(removeKdigits(s, k));
        sc.close();
    }
    public static String removeKdigits(String num, int k) {
        if(k==num.length())return "0";
        Stack<Character>st = new Stack<>();
        for(char ch: num.toCharArray()){
            while(!st.isEmpty()&&st.peek()>ch&&k>0){
                st.pop();
                k--;
            }
            st.push(ch);
        }

        while(k>0){
            st.pop();
            k--;
        }

        if(st.isEmpty())return "0";

        StringBuilder res = new StringBuilder();

        while(!st.isEmpty())res.append(st.pop());

        if(res.length()==0)return "0";

        res.reverse();

        int i =0;
        while(i<res.length()&&res.charAt(i)=='0')i++;

        String ans = res.substring(i).toString();

        if(ans.length()==0)return "0";

        return ans;
        
    }
}