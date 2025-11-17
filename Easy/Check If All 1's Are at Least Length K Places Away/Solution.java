/*Given an binary array nums and an integer k, return true if all 1's are at least k places away from each other, otherwise return false.

 

Example 1:


Input: nums = [1,0,0,0,1,0,0,1], k = 2
Output: true
Explanation: Each of the 1s are at least 2 places away from each other.
Example 2:


Input: nums = [1,0,0,1,0,1], k = 2
Output: false
Explanation: The second 1 and third 1 are only one apart from each other.
 

Constraints:

1 <= nums.length <= 105
0 <= k <= nums.length
nums[i] is 0 or 1 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println("Enter value of k: ");
        int k = sc.nextInt();
        System.out.println(kLengthApart(arr, k));
        sc.close();
    }
    public static boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int last = -1;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                if(last!=-1&& i-last-1<k)return false;

                last=i;
            }
        }

        return true;
    }
}