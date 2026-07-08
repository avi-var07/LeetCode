/*You are given a string s of length m consisting of digits. You are also given a 2D integer array queries, where queries[i] = [li, ri].

For each queries[i], extract the substring s[li..ri]. Then, perform the following:

Form a new integer x by concatenating all the non-zero digits from the substring in their original order. If there are no non-zero digits, x = 0.
Let sum be the sum of digits in x. The answer is x * sum.
Return an array of integers answer where answer[i] is the answer to the ith query.

Since the answers may be very large, return them modulo 109 + 7.

 

Example 1:

Input: s = "10203004", queries = [[0,7],[1,3],[4,6]]

Output: [12340, 4, 9]

Explanation:

s[0..7] = "10203004"
x = 1234
sum = 1 + 2 + 3 + 4 = 10
Therefore, answer is 1234 * 10 = 12340.
s[1..3] = "020"
x = 2
sum = 2
Therefore, the answer is 2 * 2 = 4.
s[4..6] = "300"
x = 3
sum = 3
Therefore, the answer is 3 * 3 = 9.
Example 2:

Input: s = "1000", queries = [[0,3],[1,1]]

Output: [1, 0]

Explanation:

s[0..3] = "1000"
x = 1
sum = 1
Therefore, the answer is 1 * 1 = 1.
s[1..1] = "0"
x = 0
sum = 0
Therefore, the answer is 0 * 0 = 0.
Example 3:

Input: s = "9876543210", queries = [[0,9]]

Output: [444444137]

Explanation:

s[0..9] = "9876543210"
x = 987654321
sum = 9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 = 45
Therefore, the answer is 987654321 * 45 = 44444444445.
We return 44444444445 modulo (109 + 7) = 444444137.
 

Constraints:

1 <= m == s.length <= 105
s consists of digits only.
1 <= queries.length <= 105
queries[i] = [li, ri]
0 <= li <= ri < m */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string: ");
        String s =sc.nextLine();
        System.out.println("Enter number of queries: ");
        int n = sc.nextInt();

        int arr[][] = new int[n][2];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) {
            System.out.println("Enter l: ");
            arr[i][0] = sc.nextInt();
            System.out.println("Enter r: ");
            arr[i][1] = sc.nextInt();
        }
        Solution sol=new Solution();

        int ans[]=sol.sumAndMultiply(s, arr);
        for(int ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    long MOD=1000000007;
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n =s.length();
        int ps[] = new int[n];
        long num[] = new long[n];
        int nonZero[]= new int[n];
        long pow[]=new long[n+1];
        pow[0]=1;
        ps[0]=s.charAt(0)-'0';
        num[0]=ps[0];
        if(num[0]==0)nonZero[0]=0;
        for(int i=1;i<n;i++){
            int dig = s.charAt(i)-'0';
            ps[i]=ps[i-1]+dig;
            nonZero[i]=nonZero[i-1];
            if(dig==0)num[i]=num[i-1];
            else {
                num[i]=(num[i-1]*10+dig)%MOD;
                nonZero[i]++;
            }
        }
        for(int i=1;i<=n;i++)pow[i]=(pow[i-1]*10)%MOD;
        int m =queries.length;
        int ans[] =new int[m];
        int idx=0;

        for(int q[]: queries){
            int l=q[0];
            int r=q[1];
            int sum=l!=0?ps[r]-ps[l-1]:ps[r];
            int len=nonZero[r]-(l==0?0:nonZero[l-1]);
            

            long x=l==0?num[r]:(num[r]-(num[l-1]*pow[len])%MOD+MOD)%MOD;
            ans[idx++]=(int)((x*(sum%MOD))%MOD);
        }
        return ans;
    }
}