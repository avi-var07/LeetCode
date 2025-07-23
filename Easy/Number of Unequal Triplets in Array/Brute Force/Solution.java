/* You are given a 0-indexed array of positive integers nums. Find the number of triplets (i, j, k) that meet the following conditions:

0 <= i < j < k < nums.length
nums[i], nums[j], and nums[k] are pairwise distinct.
In other words, nums[i] != nums[j], nums[i] != nums[k], and nums[j] != nums[k].
Return the number of triplets that meet the conditions.

 

Example 1:

Input: nums = [4,4,2,4,3]
Output: 3
Explanation: The following triplets meet the conditions:
- (0, 2, 4) because 4 != 2 != 3
- (1, 2, 4) because 4 != 2 != 3
- (2, 3, 4) because 2 != 4 != 3
Since there are 3 triplets, we return 3.
Note that (2, 0, 4) is not a valid triplet because 2 > 0.
Example 2:

Input: nums = [1,1,1,1,1]
Output: 0
Explanation: No triplets meet the conditions so we return 0.
 

Constraints:

3 <= nums.length <= 100
1 <= nums[i] <= 1000*/

//Extreme Brute Force Approach

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
        
        System.out.println("Number of Unequal triplets in the array is: "+unequalTriplets(arr));
        
        sc.close();
    }
    public static int unequalTriplets(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            for(int j = i+1; j<nums.length;j++){
                if(nums[i]==nums[j])continue;
                for(int k = j+1; k<nums.length;k++){
                    if(nums[i]!=nums[j]&&nums[j]!=nums[k]&&nums[i]!=nums[k])count++;
                }
            }
        }
        return count;
    }
}