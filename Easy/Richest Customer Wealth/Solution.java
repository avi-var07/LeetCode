/*You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.

A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.

 

Example 1:

Input: accounts = [[1,2,3],[3,2,1]]
Output: 6
Explanation:
1st customer has wealth = 1 + 2 + 3 = 6
2nd customer has wealth = 3 + 2 + 1 = 6
Both customers are considered the richest with a wealth of 6 each, so return 6.
Example 2:

Input: accounts = [[1,5],[7,3],[3,5]]
Output: 10
Explanation: 
1st customer has wealth = 6
2nd customer has wealth = 10 
3rd customer has wealth = 8
The 2nd customer is the richest with a wealth of 10.
Example 3:

Input: accounts = [[2,8,7],[7,1,3],[1,9,5]]
Output: 17
 

Constraints:

m == accounts.length
n == accounts[i].length
1 <= m, n <= 50
1 <= accounts[i][j] <= 100 */
import java.util.*;
class Solution {
    public static int maximumWealth(int[][] accounts) {
       int maxi=0;
       int rows = accounts.length;
       for(int i=0;i<rows;i++){
        int sum=0;
        for(int j=0;j<accounts[i].length;j++){
            sum+=accounts[i][j];
            if(sum>maxi)
            maxi=sum;
        }
       }
       return maxi;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int r =sc.nextInt();
        System.out.println("Enter number of cols: ");
        int c =sc.nextInt();
        int matrix[][]=new int[r][c];
        System.out.println("Enter elements: ");
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++)
            matrix[i][j]=sc.nextInt();
        }
        System.out.println("Maximum Wealth: "+maximumWealth(matrix));
        sc.close();
    }
}