/*Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length such that B[i] == A[(i+x) % A.length] for every valid index i.

 

Example 1:

Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 3 positions to begin on the element of value 3: [3,4,5,1,2].
Example 2:

Input: nums = [2,1,3,4]
Output: false
Explanation: There is no sorted array once rotated that can make nums.
Example 3:

Input: nums = [1,2,3]
Output: true
Explanation: [1,2,3] is the original sorted array.
You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
 
 

 

 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    static boolean check(int[] nums) {
        int n = nums.length;
        int ans[] = Arrays.copyOf(nums, n);

        Arrays.sort(ans);

        if(Arrays.equals(ans,nums))
        return true;

        else{
            int r=1;
            while(r<=n){
                int last = nums[n-1];
                for(int i=n-1;i>0;i--)
                nums[i]=nums[i-1];

                nums[0] = last;

                if(Arrays.equals(nums,ans))
                return true;

                else
                r++;
            }
        }
        return false;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of array: ");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

        System.out.println(check(arr));
        sc.close();
    }
}