/*There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104
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
        
        System.out.println("Enter target: ");
        int target = sc.nextInt();
        System.out.println("Index is: "+search(arr, target));
        sc.close();
    }

    public static int search(int[] arr, int target) {
        int low = 0, high  =arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==target)return mid;
            else if(arr[low]<=arr[mid]){    //left side sorted
                if(arr[mid]>=target&&arr[low]<=target)  //target sorted side mei hai
                high=mid-1;
                else low=mid+1;

            }
            else{   //right side sorted hai
                if(arr[mid]<=target&&target<=arr[high])low=mid+1;   //sorted side mei hai
                else high=mid-1;
            }
        }
        return -1;
    }

}