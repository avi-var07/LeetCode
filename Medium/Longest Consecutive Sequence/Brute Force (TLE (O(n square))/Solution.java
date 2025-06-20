/*Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
Example 3:

Input: nums = [1,0,1,2]
Output: 3
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109

 */

 //Try any searching algo, will end with TLE

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
        
        System.out.println("Longest Consecutive Sequence is: "+longestConsecutive(arr));
        sc.close();
    }

    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int longest = 0;
        for(int i = 0; i<nums.length;i++){
            int ele = nums[i], count=1;

            while(BinarySearch(nums,ele+1)){
                ele++;
                count++;
            }
            if(count>longest)longest=count;
        }
        return longest;
    }
    static boolean BinarySearch(int arr[], int n){
        int start=0, end=arr.length-1;

        while(start<=end){
            int mid = start+(end-start)/2;

            if(arr[mid]==n)return true;

            else if(arr[mid]>n)end=mid-1;
            
            else start=mid+1;
        }
        return false;
    }
}