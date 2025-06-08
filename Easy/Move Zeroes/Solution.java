/*Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 

Follow up: Could you minimize the total number of operations done? */


//Approach used is two pointer: i for indexing, j for first zero!!

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        
        System.out.println("Entet the elements: ");

        int arr[]=new int[n];
        
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

        moveZeroes(arr);

        for(int ele: arr)
        System.out.print(ele+" ");
        sc.close();
    }
    public static void moveZeroes(int[] nums) {
        int j=-1;
    
        for(int i=0;i<nums.length;i++)
        if(nums[i]==0){
            j=i;
            break;
        }
        if(j==-1)return;

        
        for(int i=j+1;i<nums.length;i++){
            if(nums[i]!=0){
                int temp = nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            }
        }

    }
}