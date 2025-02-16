/*
20. Valid Parenthesis
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */
import java.util.*;
class Solution {
    static boolean isValid(String s) {
        Stack <Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{')
            stack.push(s.charAt(i));
            else{
                if(stack.isEmpty()) return false;
                char top=stack.pop();
                if((s.charAt(i)==')'&&top!='(')||(s.charAt(i)==']'&&top!='[')||(s.charAt(i)=='}'&&top!='{'))
                return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String to be checked");
        String s=sc.nextLine();
        System.out.println(isValid(s));
        sc.close();
    }
}