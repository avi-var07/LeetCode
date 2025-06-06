/*Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
 

Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space? */
import java.util.*;
class Solution {
    static void rotate(int[] nums, int k) {
        if(k==0) return;
        int n = nums.length;
        k=k%n;
        int j=0;
        while(j<k){
            int last = nums[n-1];
            for(int i=n-1;i>0;i--){
                nums[i]=nums[i-1];
            }
            nums[0]=last;
            j++;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println("Enter the value of k");
        int k = sc.nextInt();
        rotate(nums,k);
        System.out.println("The rotated array is:");
        for(int i=0;i<n;i++){
            System.out.print(nums[i]+" ");
        }
        sc.close();
    }
}

//Gives TLE as TC is (O(n*k)) where n is the size of the array and k is the number of rotations
//Time complexity: O(n*k, fails for large values of n and k)
//Space complexity: O(1) as we are not using any extra space