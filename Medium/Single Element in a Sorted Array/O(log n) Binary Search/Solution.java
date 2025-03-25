/*540. Single Element in a Sorted Array
Solved
Medium
Topics
Companies
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

 

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 105 */

import java.util.Scanner;
class Solution{
    public static int singleNonDuplicate(int[] nums){
        int n = nums.length;
        if(nums[0]!=nums[1]) return nums[0];
        if(nums[n-1]!=nums[n-2]) return nums[n-1];
        if(n==1) return nums[0];
        int l=1,r=n-2;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]!=nums[mid-1]&&nums[mid]!=nums[mid+1]) return nums[mid];
            else if(mid%2==0&&nums[mid]!=nums[mid+1]||mid%2==1&&nums[mid]!=nums[mid-1]) r = mid-1;
            else l = mid+1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements in the array");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        System.out.println("The element which occurs only once is: "+singleNonDuplicate(arr));
        sc.close();
    }
}