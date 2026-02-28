/*Given an integer n, return the decimal value of the binary string formed by concatenating the binary representations of 1 to n in order, modulo 109 + 7.

 

Example 1:

Input: n = 1
Output: 1
Explanation: "1" in binary corresponds to the decimal value 1. 
Example 2:

Input: n = 3
Output: 27
Explanation: In binary, 1, 2, and 3 corresponds to "1", "10", and "11".
After concatenating them, we have "11011", which corresponds to the decimal value 27.
Example 3:

Input: n = 12
Output: 505379714
Explanation: The concatenation results in "1101110010111011110001001101010111100".
The decimal value of that is 118505380540.
After modulo 109 + 7, the result is 505379714.
 

Constraints:

1 <= n <= 105
 
 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();

        Solution sol = new Solution();
        System.out.println(sol.concatenatedBinary(n));
        sc.close();
    }
    int MOD = 1000000007;
    public int concatenatedBinary(int n) {
        // String s ="";
        // for(int i=1;i<=n;i++)s+=binary(i);
        
        // long ans = 0;
        // for(int i=0;i<s.length();i++)ans=(ans*2+(s.charAt(i)-'0'))%MOD;

        // return (int)ans;
        long ans=0;
        int bitLength =0;
        for(int i=1;i<=n;i++){
            if((i&(i-1))==0)bitLength++;//power of 2 increase length of bitLength
            ans= ((ans<<bitLength)+i)%MOD;
        }

        return (int)ans;
    }
    // static String binary(int n){
    //     return Integer.toBinaryString(n);
    // }

}