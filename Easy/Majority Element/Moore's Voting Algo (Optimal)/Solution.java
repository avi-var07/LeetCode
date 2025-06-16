/*Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109 */

/*This  is Moore's Voting Algorihtm.
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

        System.out.println("Majority Element is: "+majorityElement(arr));
    
        sc.close();
    }

    public static int majorityElement(int[] nums) {
       int count = 0, ele=-1;

       for(int i = 0; i<nums.length;i++){
            if(count==0){
                count=1;
                ele=nums[i];
            }
            else if(nums[i]==ele)count++;
            else count--;
       } 

        int freq=0;
       for(int i = 0;i<nums.length;i++)
       if(nums[i]==ele)freq++;

       if(freq>(nums.length/2))return ele;

       return -1;

    }
}