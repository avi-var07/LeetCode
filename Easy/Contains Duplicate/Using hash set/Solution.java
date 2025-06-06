/*Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 

Example 1:

Input: nums = [1,2,3,1]

Output: true

Explanation:

The element 1 occurs at the indices 0 and 3.

Example 2:

Input: nums = [1,2,3,4]

Output: false

Explanation:

All elements are distinct.

Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]

Output: true

 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
 */

 import java.util.*;

 class Solution {
     static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num))
                return true; // Duplicate found
            set.add(num);
        }

        return false; // No duplicates
     }
     public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         System.out.println("Enter the number of elements in the array:");
         int n=sc.nextInt();
         System.out.println("Enter the elements of the array:");
         int[] nums=new int[n];
         for(int i=0;i<n;i++)
         {
             nums[i]=sc.nextInt();
         }
         System.out.println(containsDuplicate(nums));
         sc.close();
     }
 }
 