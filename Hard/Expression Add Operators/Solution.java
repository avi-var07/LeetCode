/*Given a string num that contains only digits and an integer target, return all possibilities to insert the binary operators '+', '-', and/or '*' between the digits of num so that the resultant expression evaluates to the target value.

Note that operands in the returned expressions should not contain leading zeros.

Note that a number can contain multiple digits.

 

Example 1:

Input: num = "123", target = 6
Output: ["1*2*3","1+2+3"]
Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2","2+3*2"]
Explanation: Both "2*3+2" and "2+3*2" evaluate to 8.
Example 3:

Input: num = "3456237490", target = 9191
Output: []
Explanation: There are no expressions that can be created from "3456237490" to evaluate to 9191.
 

Constraints:

1 <= num.length <= 10
num consists of only digits.
-231 <= target <= 231 - 1 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter num: ");
        String num  =sc.next();
        System.out.println("Enter target: ");
        int target  =sc.nextInt();

        List<String>ans = addOperators(num, target);
        for(var ele: ans)System.out.print(ele+" ");
        

        sc.close();
    }
    public static List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        solve(num, target, 0, "", 0, 0, ans);
        return ans;
    }
    static void solve(String num, int target, int index, String curr, long res, long prev, List<String>ans){
        if(index==num.length()){
            if(res==target)ans.add(curr);
            return;
        }
        String st ="";
        long curr_no = 0;
        for(int i=index;i<num.length();i++){
            if(i>index&&num.charAt(index)=='0')break;
            st+=num.charAt(i);
            curr_no = curr_no*10+(num.charAt(i)-'0');
            if(index==0)solve(num, target,i+1,st,curr_no, curr_no, ans);
            else{
                solve(num, target, i+1, curr+"+"+st, res+curr_no, curr_no, ans);
                solve(num, target, i+1, curr+"-"+st, res-curr_no, -curr_no, ans);
                solve(num, target, i+1, curr+"*"+st, res-prev+(prev*curr_no), prev*curr_no, ans);
            }

        }
    }
}