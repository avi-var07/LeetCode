/*You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

You should return the array of nums such that the the array follows the given conditions:

Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

 

Example 1:

Input: nums = [3,1,-2,-5,2,-4]
Output: [3,-2,1,-5,2,-4]
Explanation:
The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.  
Example 2:

Input: nums = [-1,1]
Output: [1,-1]
Explanation:
1 is the only positive integer and -1 the only negative integer in nums.
So nums is rearranged to [1,-1].
 

Constraints:

2 <= nums.length <= 2 * 105
nums.length is even
1 <= |nums[i]| <= 105
nums consists of equal number of positive and negative integers.
 

It is not required to do the modifications in-place.
 */

 //Brute Force Approach: 

 /*Create Two  arrays, in one array store positive and in another store negative. Merge them using indexing  */
import java.util.*;
class Solution {
    public static int[] rearrangeArray(int[] nums) {
        int n  = nums.length;
       int pos[] = new int[n/2]; 
       int neg[] = new int[n/2];
        int i=0,j=0;
       for(int num:nums){
        if(num>0){
            pos[i]=num;
            i++;
        }
        else {
            neg[j]=num;
            j++;
        }
    
       }

       int ans[] = new int[n];
        int l=0,m=0;
       for(int k=0;k<n;k++){
        if(k%2==0){
            ans[k]=pos[l];
            l++;
        }
        else {
            ans[k]=neg[m];
            m++;
        }
       }

       return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array:");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] result = rearrangeArray(nums);
        System.out.println("Rearranged array:");
        for (int num : result) {
            System.out.print(num + " ");
        }
        sc.close();
    }

}