/*1550. Three Consecutive Odds
Solved
Easy
Topics
Companies
Hint
Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.
 

Example 1:

Input: arr = [2,6,4,1]
Output: false
Explanation: There are no three consecutive odds.
Example 2:

Input: arr = [1,2,34,3,4,5,7,23,12]
Output: true
Explanation: [5,7,23] are three consecutive odds.
 

Constraints:

1 <= arr.length <= 1000
1 <= arr[i] <= 1000 */

import java.util.*;
class Solution {
    public static boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length < 3) return false;
        
        for(int i = 0; i <= arr.length - 3; i++) {
            if((arr[i]&1)==1 && (arr[i+1]&1)==1 && (arr[i+2]&1)==1)
                return true;
        }
        
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the no. of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        for(int i=0;i<n;i++)arr[i]=sc.nextInt();


        if(threeConsecutiveOdds(arr))System.out.println("Yes there are three consecutive odds present in the array!");
        else System.out.println("No there are no three consecutive odds present in the array!");

        sc.close();
    }
}
