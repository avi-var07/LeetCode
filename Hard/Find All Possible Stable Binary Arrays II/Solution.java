/*You are given 3 positive integers zero, one, and limit.

A binary array arr is called stable if:

The number of occurrences of 0 in arr is exactly zero.
The number of occurrences of 1 in arr is exactly one.
Each subarray of arr with a size greater than limit must contain both 0 and 1.
Return the total number of stable binary arrays.

Since the answer may be very large, return it modulo 109 + 7.

 

Example 1:

Input: zero = 1, one = 1, limit = 2

Output: 2

Explanation:

The two possible stable binary arrays are [1,0] and [0,1].

Example 2:

Input: zero = 1, one = 2, limit = 1

Output: 1

Explanation:

The only possible stable binary array is [1,0,1].

Example 3:

Input: zero = 3, one = 3, limit = 2

Output: 14

Explanation:

All the possible stable binary arrays are [0,0,1,0,1,1], [0,0,1,1,0,1], [0,1,0,0,1,1], [0,1,0,1,0,1], [0,1,0,1,1,0], [0,1,1,0,0,1], [0,1,1,0,1,0], [1,0,0,1,0,1], [1,0,0,1,1,0], [1,0,1,0,0,1], [1,0,1,0,1,0], [1,0,1,1,0,0], [1,1,0,0,1,0], and [1,1,0,1,0,0].

 

Constraints:

1 <= zero, one, limit <= 1000 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Zeroes: ");
        int zeroes = sc.nextInt();
        System.out.println("Enter number of Ones: ");
        
        int ones=sc.nextInt();
        System.out.println("Enter number of Limit: ");
        int limit = sc.nextInt();

        System.out.println(numberOfStableArrays(zeroes, ones, limit));
        sc.close(); 
    }
    //     int MOD = 1000000007;
//     int dp[][][];
//     public int numberOfStableArrays(int zero, int one, int limit) {
//     //     int startWithOne = solve(zero,one,limit,false);
//     //     int startWithZero = solve(zero,one,limit,true);
        
//     //     return (startWithOne+startWithZero)%MOD;
//     // }
//     // static int solve(int zeroesLeft, int onesLeft, int limit, boolean lastOne){
//     //     if(zeroesLeft==0&&onesLeft==0)return 1;
//     //     int result=0;
//     //     if(lastOne){ //explore 0's
//     //         for(int len=1;len<=Math.min(limit, zeroesLeft);len++)result+=solve(zeroesLeft-len, onesLeft, limit, false); //agli baar 1's explore krwane ko
//     //     }
//     //     else{   //mtlb last baar 0 kiya tha
//     //         for(int len=1;len<=Math.min(limit, onesLeft);len++)result+=solve(zeroesLeft, onesLeft-len, limit, true);
//     //     }
//     //     return result;
//     // }
//         dp=new int[zero+1][one+1][2];
//         for(int i=0;i<=zero;i++){
//             for(int j=0;j<=one;j++){
//                 for(int k=0;k<2;k++)dp[i][j][k]=-1;
//             }
//         }
//         int startWithOne = solve(zero,one,limit,false);
//         int startWithZero = solve(zero,one,limit,true);
        
//         return (startWithOne+startWithZero)%MOD;
//     }
//     // int solve(int zeroesLeft, int onesLeft, int limit, boolean lastOne){
//     //     int last =lastOne?1:0;
//     //     if(zeroesLeft==0&&onesLeft==0)return 1;
//     //     if(dp[zeroesLeft][onesLeft][last]!=-1)return dp[zeroesLeft][onesLeft][last];
//     //     int result=0;
//     //     if(lastOne){ //explore 0's
//     //         for(int len=1;len<=Math.min(limit, zeroesLeft);len++)result=(result+solve(zeroesLeft-len, onesLeft, limit, false))%MOD; //agli baar 1's explore krwane ko
//     //     }
//     //     else{   //mtlb last baar 0 kiya tha
//     //         for(int len=1;len<=Math.min(limit, onesLeft);len++)result=(result+solve(zeroesLeft, onesLeft-len, limit, true))%MOD;
//     //     }
//     //     return dp[zeroesLeft][onesLeft][last]=result;
//     // }
    
// }
    public static int numberOfStableArrays(int zero, int one, int limit) {
        int MOD = 1_000_000_007;
        
        // dp[i][j][last]
        // i = 0s used, j = 1s used, last = 0 ya 1
        long[][][] dp = new long[zero + 1][one + 1][2];
        
        // base case — sirf ek element rakha
        // 0 se 0 tak, limit ke andar
        for (int i = 1; i <= Math.min(limit, zero); i++) {
            dp[i][0][0] = 1;  // sirf i 0s hain, koi 1 nahi
        }
        for (int j = 1; j <= Math.min(limit, one); j++) {
            dp[0][j][1] = 1;  // sirf j 1s hain, koi 0 nahi
        }
        
        // fill karo baaki table
        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                
                // last element 0 rakha
                dp[i][j][0] = (dp[i-1][j][0] + dp[i-1][j][1]) % MOD;
                // agar limit cross hua toh invalid cases hatao
                if (i > limit) {
                    dp[i][j][0] = (dp[i][j][0] - dp[i-1-limit][j][1] + MOD) % MOD;
                }
                
                // last element 1 rakha
                dp[i][j][1] = (dp[i][j-1][0] + dp[i][j-1][1]) % MOD;
                // agar limit cross hua toh invalid cases hatao
                if (j > limit) {
                    dp[i][j][1] = (dp[i][j][1] - dp[i][j-1-limit][0] + MOD) % MOD;
                }
            }
        }
        
        // answer = saare valid arrays jisme zero 0s aur one 1s hain
        return (int)((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}