
/*338. Counting Bits

Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

 

Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
 

Constraints:

0 <= n <= 105
 */import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the range upto where you want to count the bits:");
        int n=sc.nextInt();
        int ans[] = countBits(n);
        System.out.println("The number of set bits in the range 0 to "+n+" are:");
        for(int i:ans)System.out.print(i+",");
        sc.close();
    }
    public static int noOfSetBits(int n){
        int count = 0;
        while(n!=0){
            n&=(n-1);
            count++;
        }
        return count;
    }
    public static int[] countBits(int n) {
        int ans[]  = new int[n+1];
        for(int i=0;i<=n;i++)
        ans[i]=noOfSetBits(i);

        return ans;
    }
}