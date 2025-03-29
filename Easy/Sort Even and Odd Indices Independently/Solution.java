/*You are given a 0-indexed integer array nums. Rearrange the values of nums according to the following rules:

Sort the values at odd indices of nums in non-increasing order.
For example, if nums = [4,1,2,3] before this step, it becomes [4,3,2,1] after. The values at odd indices 1 and 3 are sorted in non-increasing order.
Sort the values at even indices of nums in non-decreasing order.
For example, if nums = [4,1,2,3] before this step, it becomes [2,1,4,3] after. The values at even indices 0 and 2 are sorted in non-decreasing order.
Return the array formed after rearranging the values of nums.

 

Example 1:

Input: nums = [4,1,2,3]
Output: [2,3,4,1]
Explanation: 
First, we sort the values present at odd indices (1 and 3) in non-increasing order.
So, nums changes from [4,1,2,3] to [4,3,2,1].
Next, we sort the values present at even indices (0 and 2) in non-decreasing order.
So, nums changes from [4,1,2,3] to [2,3,4,1].
Thus, the array formed after rearranging the values is [2,3,4,1].
Example 2:

Input: nums = [2,1]
Output: [2,1]
Explanation: 
Since there is exactly one odd index and one even index, no rearrangement of values takes place.
The resultant array formed is [2,1], which is the same as the initial array. 
 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100
 */
import java.util.*;
class Solution {
    public static int[] sortEvenOdd(int[] nums) {
        int n = nums.length;
        int evenSize = (n + 1) / 2;
        int oddSize = n / 2;
        
        int[] even = new int[evenSize];
        int[] odd = new int[oddSize];
        
        int i = 0, j = 0;
        
        for (int index = 0; index < n; index++) {
            if (index % 2 == 0) {
                even[i++] = nums[index];
            } else {
                odd[j++] = nums[index];
            }
        }
        
        Arrays.sort(even);
        Arrays.sort(odd);
        
        for (int k = 0; k < odd.length / 2; k++) {
            int temp = odd[k];
            odd[k] = odd[odd.length - 1 - k];
            odd[odd.length - 1 - k] = temp;
        }
        
        i = 0;
        j = 0;
        
        for (int index = 0; index < n; index++) {
            if (index % 2 == 0) {
                nums[index] = even[i++];
            } else {
                nums[index] = odd[j++];
            }
        }
        
        return nums;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] result = sortEvenOdd(nums);
        System.out.println("Sorted array: " + Arrays.toString(result));
        sc.close();
    }
}
