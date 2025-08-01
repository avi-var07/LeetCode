/*A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.

 

Example 1:

Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
Example 2:

Input: weights = [3,2,2,4,1,4], days = 3
Output: 6
Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4
Example 3:

Input: weights = [1,2,3,1,1], days = 4
Output: 3
Explanation:
1st day: 1
2nd day: 2
3rd day: 3
4th day: 1, 1
 

Constraints:

1 <= days <= weights.length <= 5 * 104
1 <= weights[i] <= 500
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
        
        System.out.println("Enter days limit: ");
        int days = sc.nextInt();
        System.out.println("Minimum capacity allowed is: "+shipWithinDays(arr, days));
        sc.close();
    }
    public static int shipWithinDays(int[] arr, int days) {
        int maxi = arr[0], high=0;
        for(int ele: arr){
            if(ele>maxi)maxi=ele;
            high+=ele;
        }
        int low = maxi, ans=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int required = noOfDays(arr, mid);
            if(required<=days){
                ans=mid;
                high=mid-1;

            }
            else low=mid+1;
        }
        return ans;
    }
    static int  noOfDays(int arr[], int capacity){
        int day=1, load=0;
        for(int ele: arr){
            if(load+ele>capacity){
                day++;
                load=ele;
            }
            else load+=ele;
        }
        return day;
    }
}