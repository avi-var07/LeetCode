/*Given a binary array nums, return the maximum number of consecutive 1's in the array.

 

Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1. */
import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements in the array: ");
        int n = sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements: ");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println("Maximum number of ones are: "+findMaxConsecutiveOnes(arr));
        sc.close();
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxi=0, count=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
                if(maxi<count)maxi=count;
            }
            else count=0;
        }

        return maxi;
    }
}