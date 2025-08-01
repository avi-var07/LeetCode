/*You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.

 

Example 1:

Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
Example 2:

Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
1 <= k <= 109 */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements: ");
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println("Enter the value of k: ");
        int k = sc.nextInt();
        System.out.println("Number of operations required: "+maxOperations(arr, k));
        sc.close();
    }
    public static int maxOperations(int[] nums, int k) {
        int oper = 0, left=0, right=nums.length-1;
        Arrays.sort(nums);
        while(left<right){
            int sum = nums[left]+nums[right];
            if(sum==k){
                nums[left]=0;
                nums[right]=0;
                oper++;
                left++;
                right--;
            }
            else if(sum<k)left++;
            else right--;
        }
        return oper;

    }


}