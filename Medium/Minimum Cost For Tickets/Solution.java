/*You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.

Train tickets are sold in three different ways:

a 1-day pass is sold for costs[0] dollars,
a 7-day pass is sold for costs[1] dollars, and
a 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.

For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
Return the minimum number of dollars you need to travel every day in the given list of days.

 

Example 1:

Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11
Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total, you spent $11 and covered all the days of your travel.
Example 2:

Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
Output: 17
Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
In total, you spent $17 and covered all the days of your travel.
 

Constraints:

1 <= days.length <= 365
1 <= days[i] <= 365
days is in strictly increasing order.
costs.length == 3
1 <= costs[i] <= 1000 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        int cost[] = new int[3];
        System.out.println("Enter the 3 costs: ");
        cost[0] = sc.nextInt();
        cost[1] = sc.nextInt();
        cost[2] = sc.nextInt();

        Solution sol =  new Solution();
        System.out.println(sol.mincostTickets(arr, cost));
        sc.close();
    }
    Integer dp[];
    public int mincostTickets(int[] days, int[] costs) {
        int n =days.length;
        dp=new Integer[n+1];
        return solve(0,days, costs, n);
        //return solve_tab(days, costs, n);
    }   
    int solve(int index, int d[], int c[], int n){
        if(index>=n)return 0;
        if(dp[index]!=null)return dp[index];
        int cost1 = c[0]+solve(index+1, d, c, n);
        int j=index;
        while(j<n&&d[j]<=d[index]+6)j++;
        int cost7 = c[1]+solve(j, d, c, n);
        j=index;
        while(j<n&&d[j]<=d[index]+29)j++;
        int cost30 = c[2]+solve(j, d, c, n);

        return dp[index]=Math.min(cost1, Math.min(cost7, cost30));
    }
    // int solve_tab(int d[], int c[], int n){
    //     int dp[] = new int[n+1];
    //     for(int i=n-1;i>=0;i--){
    //         int cost1 = c[0]+dp[i+1];
    //         int j =i;
    //         while(j<n&&d[j]<=d[i]+6)j++;
    //         int cost7 = c[1]+dp[j];
    //         j=i;
    //         while(j<n&&d[j]<=d[i]+29)j++;
    //         int cost30 = c[2]+dp[j];

    //         dp[i]=Math.min(cost1, Math.min(cost7, cost30));
    //     }
    //     return dp[0];
    // }
}