/*You are given an integer array nums consisting only of 0, 1, and 2.

A pair of indices (i, j) is called valid if nums[i] == 1 and nums[j] == 2.

Return the minimum absolute difference between i and j among all valid pairs. If no valid pair exists, return -1.

The absolute difference between indices i and j is defined as abs(i - j).

 

Example 1:

Input: nums = [1,0,0,2,0,1]

Output: 2

Explanation:

The valid pairs are:

(0, 3) which has absolute difference of abs(0 - 3) = 3.
(5, 3) which has absolute difference of abs(5 - 3) = 2.
Thus, the answer is 2.

Example 2:

Input: nums = [1,0,1,0]

Output: -1

Explanation:

There are no valid pairs in the array, thus the answer is -1.

 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 2 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println(minAbsoluteDifference(arr));
        sc.close();
    }
    public static int minAbsoluteDifference(int[] nums) {
        int last1=-1;
        int last2=-1;
        int ans=Integer.MAX_VALUE;
        int n =nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                last1=i;
                if(last2!=-1)ans=Math.min(ans, Math.abs(last1-last2));
            }
            else if(nums[i]==2){
                last2=i;
                if(last1!=-1)ans=Math.min(ans, Math.abs(last1-last2));
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}