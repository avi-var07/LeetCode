/*
You are given an integer array bloomDay, an integer m and an integer k.

You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.

Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.

 

Example 1:

Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
Output: 3
Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
We need 3 bouquets each should contain 1 flower.
After day 1: [x, _, _, _, _]   // we can only make one bouquet.
After day 2: [x, _, _, _, x]   // we can only make two bouquets.
After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
Example 2:

Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
Output: -1
Explanation: We need 3 bouquets each has 2 flowers, that means we need 6 flowers. We only have 5 flowers so it is impossible to get the needed bouquets and we return -1.
Example 3:

Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
Output: 12
Explanation: We need 2 bouquets each should have 3 flowers.
Here is the garden after the 7 and 12 days:
After day 7: [x, x, x, x, _, x, x]
We can make one bouquet of the first three flowers that bloomed. We cannot make another bouquet from the last three flowers that bloomed because they are not adjacent.
After day 12: [x, x, x, x, x, x, x]
It is obvious that we can make two bouquets in different ways.
 

Constraints:

bloomDay.length == n
1 <= n <= 105
1 <= bloomDay[i] <= 109
1 <= m <= 106
1 <= k <= n


*/
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
        
        System.out.println("Enter number of bouquets: ");
        int m = sc.nextInt();

        System.out.println("Enter number of adjacent flowers: ");
        int k = sc.nextInt();

        System.out.println("Minimum Days required are: "+minDays(arr, m, k));
        
        sc.close();
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        int mini = bloomDay[0], maxi = bloomDay[0];

        for(int ele: bloomDay){
            if(ele<mini)mini=ele;
        }

        for(int ele: bloomDay){
            if(ele>maxi)maxi=ele;
        }
        int ans = -1;
        if(m*k>bloomDay.length)return -1;
        while(mini<=maxi){
            int mid = mini+(maxi-mini)/2;

            if(possible(bloomDay, m, k, mid)){
                ans=mid;
                maxi=mid-1;
            }
            else mini=mid+1;
        }
        return ans;
    }
    static boolean possible(int arr[], int m, int k, int day){
        int count = 0, noOfBouquets = 0;

        for(int ele: arr){
            if(ele<=day)count++;
            else{
                noOfBouquets+=(count/k);
                count=0;
            }
        }
        noOfBouquets+=(count/k);

        if(noOfBouquets>=m)return true;
        
        return false;
    }
}