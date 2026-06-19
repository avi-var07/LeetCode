/*You are given an integer n.

Return true if its binary representation contains exactly one adjacent pair of set bits, and false otherwise.

 

Example 1:

Input: n = 6

Output: true

Explanation:

Binary representation of 6 is 110.
There is exactly one adjacent pair of set bits ("11"). Thus, the answer is true​​​​​​​.
Example 2:

Input: n = 5

Output: false

Explanation:

Binary representation of 5 is 101.
There is no adjacent pair of set bits. Thus, the answer is false​​​​​​​.
 

Constraints:

0 <= n <= 105 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();

        System.out.println(consecutiveSetBits(n));
        sc.close();
    }
    public static boolean consecutiveSetBits(int n) {
        String binary = Integer.toBinaryString(n);
        int len= binary.length();
        int cnt=0;
        for(int i=0;i<len-1;i++)if(binary.charAt(i)=='1'&&binary.charAt(i+1)=='1')cnt++;

        return cnt==1;
    }
}