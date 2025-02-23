/*Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109 */
import java.util.Scanner;

class Solution {
    static void searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans[] = {-1, -1};

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                int first = mid, last = mid;

                while (first > 0 && nums[first - 1] == target) 
                    first--;

                while (last < nums.length - 1 && nums[last + 1] == target) 
                    last++;

                ans[0]=first;
                ans[1]=last;
            }

            if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        

        
        System.out.println("First occurence at: "+ans[0]+" " +"Last occurence at: "+ans[1]);
    }
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n=sc.nextInt();

        int arr[]=new int[n];
        System.out.println("Enter the array elements: ");

        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

        System.out.println("Enter target to be searched for: ");
        int target =  sc.nextInt();

        searchRange(arr, target);

        sc.close();


    }
}
