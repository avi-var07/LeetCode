/*Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

 

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23
 

Constraints:

1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109
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
        
        System.out.println("Enter the maximum hours: ");
        int h = sc.nextInt();
        System.out.println("Minimum banana/hour speed is: "+minEatingSpeed(arr, h));
        sc.close();
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int maxi = piles[0];

        for(int ele: piles){
            if(ele>maxi)maxi=ele;
        }

        int low = 1, high=maxi, ans=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int total=calculateTime(piles, mid);
            if(total<=h){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    static int calculateTime(int arr[], int hour){
        int total=0;
        for(int ele: arr){
            total+=Math.ceil((double)(ele)/(double)(hour));
            
        }
        return total;
    }
}