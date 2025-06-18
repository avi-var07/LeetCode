/*This is the Brute Force Approach Just For Understanding Purpose, because this will give TLE */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements:");
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) 
        arr[i] = sc.nextInt();
        
        System.out.println("Maximum Profit is: "+maxProfit(arr));
        
        sc.close();
    }
    public static int maxProfit(int[] prices) {
       int profit = 0;
       for(int i=0;i<prices.length;i++){
        for(int j=i+1;j<prices.length;j++){
            if(prices[j]>prices[i]){
                if(profit<(prices[j]-prices[i]))profit=prices[j]-prices[i];
            }
        }
       }

       return profit;
    }
}