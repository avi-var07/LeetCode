/*Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

 

Example 1:


Input: n = 3
Output: 5
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 19 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();

        Solution sol = new Solution();

        System.out.println(sol.numTrees(n));
        sc.close();
    }
    int dp[];
    public int numTrees(int n) {
        //left side = i-1
        //right side = n-i;
        //total=left*right!!

        dp=new int[n+1];

        Arrays.fill(dp, -1);
        return generate(n);
    }
    // static int generate(int n){
    //     if(n==0||n==1)return 1;

    //     int total =0;
        
    //     // try every node as root
    //     for(int i=1;i<=n;i++){
    //         int left = generate(i-1);
    //         int right = generate(n-i);

    //         total+=left*right;
    //     }
    //     return total;
    // }

    int generate(int n){
        if(n==0||n==1)return 1;

        if(dp[n]!=-1)return dp[n];

        int total= 0;

        for(int i=1;i<=n;i++){
            int left = generate(i-1);
            int right= generate(n-i);

            total+=left*right;
        }

        dp[n]=total;

        return total;
    }
}