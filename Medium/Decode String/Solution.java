/*Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
 

Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300]. */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter s: ");
        String s = sc.nextLine();

        System.out.println(decodeString(s));

        sc.close();
    }
    public static String decodeString(String s) {
        //mera brute force:
        // StringBuilder sb = new StringBuilder();
        // Stack<Character>st = new Stack<>();
        // for(char ch: s.toCharArray()){
        //     if(ch==']'){
        //         StringBuilder str =new StringBuilder();
        //         while(st.peek()!='[')str.append(st.pop());
        //         str.reverse();
        //         st.pop(); //'['
        //         StringBuilder dig = new StringBuilder();
        //         while(!st.isEmpty()&&Character.isDigit(st.peek()))dig.append(st.pop());
        //         dig.reverse();
                
        //         int num = Integer.parseInt(dig.toString());
        //         StringBuilder inner = new StringBuilder();
            
        //         for(int i=0;i<num;i++)inner.append(str);

        //         for(char ele: inner.toString().toCharArray())st.push(ele);
        //     }
        //     else st.push(ch);
        // }

        // while(!st.isEmpty())sb.append(st.pop());
        // sb.reverse();
        // return sb.toString();

        //better: integers ka alg stack bana lo
        Stack<Character>st =new Stack<>();
        Stack<Integer>Z= new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num=0;
        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch))num=num*10+(ch-'0');
            else if(ch=='['){
                Z.push(num);
                num=0;
                st.push(ch);
            }
            else if(ch==']'){
                StringBuilder str =new StringBuilder();
                while(st.peek()!='[')str.append(st.pop());
                str.reverse();
                st.pop(); //'['
            
                StringBuilder inner = new StringBuilder();

                int digi = Z.pop();
                for(int i=0;i<digi;i++)inner.append(str);

                for(char ele: inner.toString().toCharArray())st.push(ele);
            }
            else st.push(ch);
        }

        while(!st.isEmpty())sb.append(st.pop());

        sb.reverse();
        return sb.toString();

    }
}