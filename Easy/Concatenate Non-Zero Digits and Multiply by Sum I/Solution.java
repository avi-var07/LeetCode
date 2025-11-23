/*You are given an integer n.

Form a new integer x by concatenating all the non-zero digits of n in their original order. If there are no non-zero digits, x = 0.

Let sum be the sum of digits in x.

Return an integer representing the value of x * sum.

 

Example 1:

Input: n = 10203004

Output: 12340

Explanation:

The non-zero digits are 1, 2, 3, and 4. Thus, x = 1234.
The sum of digits is sum = 1 + 2 + 3 + 4 = 10.
Therefore, the answer is x * sum = 1234 * 10 = 12340.
Example 2:

Input: n = 1000

Output: 1

Explanation:

The non-zero digit is 1, so x = 1 and sum = 1.
Therefore, the answer is x * sum = 1 * 1 = 1.
 

Constraints:

0 <= n <= 109
 
 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();
        System.out.println(sumAndMultiply(n));

        sc.close();
    }
    public static long sumAndMultiply(int n) {
        StringBuilder sb = new StringBuilder();
        while(n!=0){
            int d = n%10;
            if(d!=0)sb.append(d);
            n/=10;
        }
        sb.reverse();
        if(sb.length()==0)return 0;
        int sum = 0;
        for(char ch: sb.toString().toCharArray())sum+=(ch-'0');

        long ans = Long.parseLong(sb.toString());
        return ans*sum;
    }
}