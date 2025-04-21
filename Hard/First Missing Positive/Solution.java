/*Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1 */

import java.util.*;
class Solution{
    public static int firstMissingPositive(int[] nums){
        int i=0, n=nums.length;
        while(i<n){
            int correct = nums[i]-1;
            if(nums[i]>0&&nums[i]<=n&&nums[i]!=nums[correct]){
                int temp=nums[i];
                nums[i]=nums[correct];
                nums[correct]=temp;
            }
            else i++;
        }
        for(int j=0;j<n;j++)if(nums[j]!=j+1)return j+1;

        return n+1;

    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter number of elements in the array: ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

        System.out.println("Smallest Positive Missing Number is: "+firstMissingPositive(arr));
        sc.close();
    }
}