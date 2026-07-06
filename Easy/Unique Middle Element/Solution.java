/*You are given an integer array nums of odd length n.

Return true if the middle element of nums appears exactly once in the array. Otherwise return false.

 

Example 1:

Input: nums = [1,2,3]

Output: true

Explanation:

The middle element of nums is 2, which appears exactly once.

Thus, the answer is true.

Example 2:

Input: nums = [1,2,2]

Output: false

Explanation:

The middle element of nums is 2, which appears twice.

Thus, the answer is false.

 

Constraints:

1 <= n == nums.length <= 100
n is odd.
1 <= nums[i] <= 100 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println(isMiddleElementUnique(arr));
        sc.close();
    }
    public static boolean isMiddleElementUnique(int[] nums) {
        int n=nums.length;
        int mid = nums[n/2];

        boolean found=false;
        for(int ele: nums){
            if(ele==mid){
                if(!found)found=true;
                else return false;
            }
        }
        return true;
    }
}