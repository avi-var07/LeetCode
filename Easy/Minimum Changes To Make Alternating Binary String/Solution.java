/*You are given a string s consisting only of the characters '0' and '1'. In one operation, you can change any '0' to '1' or vice versa.

The string is called alternating if no two adjacent characters are equal. For example, the string "010" is alternating, while the string "0100" is not.

Return the minimum number of operations needed to make s alternating.

 

Example 1:

Input: s = "0100"
Output: 1
Explanation: If you change the last character to '1', s will be "0101", which is alternating.
Example 2:

Input: s = "10"
Output: 0
Explanation: s is already alternating.
Example 3:

Input: s = "1111"
Output: 2
Explanation: You need two operations to reach "0101" or "1010".
 

Constraints:

1 <= s.length <= 104
s[i] is either '0' or '1'. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter s: ");
        String s = sc.nextLine();
        System.out.println(minOperations(s));
        sc.close();
    }
    public static int minOperations(String s) {
        int n =s.length();
        if(n==1)return 0;
        int count1=0, count2=0;

        for(int i=0;i<n;i++){
            //even pattern chl rha (even pe 0)
            if(i%2==0){
                if(s.charAt(i)!='0')count1++;
            }
            else{
                if(s.charAt(i)!='1')count1++;
            }

            if(i%2==0){
                if(s.charAt(i)!='1')count2++;
            }
            else{
                if(s.charAt(i)!='0')count2++;
            }
        }
        return Math.min(count1, count2);
    }
}