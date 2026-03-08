/*You are given an integer array nums.


An index i is balanced if the sum of elements strictly to the left of i equals the product of elements strictly to the right of i.

If there are no elements to the left, the sum is considered as 0. Similarly, if there are no elements to the right, the product is considered as 1.

Return an integer denoting the smallest balanced index. If no balanced index exists, return -1.

 

Example 1:

Input: nums = [2,1,2]

Output: 1

Explanation:

For index i = 1:

Left sum = nums[0] = 2
Right product = nums[2] = 2
Since the left sum equals the right product, index 1 is balanced.
No smaller index satisfies the condition, so the answer is 1.

Example 2:

Input: nums = [2,8,2,2,5]

Output: 2

Explanation:

For index i = 2:

Left sum = 2 + 8 = 10
Right product = 2 * 5 = 10
Since the left sum equals the right product, index 2 is balanced.
No smaller index satisfies the condition, so the answer is 2.

Example 3:

Input: nums = [1]

Output: -1

For index i = 0:
The left side is empty, so the left sum is 0.
The right side is empty, so the right product is 1.
Since the left sum does not equal the right product, index 0 is not balanced.
Therefore, no balanced index exists and the answer is -1.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();


        System.out.println(smallestBalancedIndex(arr));
        sc.close();
    }
    public static int smallestBalancedIndex(int[] nums) {
        int n= nums.length;

        //Approach1 failed:
        // long preSum[] = new long[n];
        // long suffPro[] = new long[n];
        // preSum[0]=nums[0];
        // suffPro[0] =nums[0];

        // for(int i=1;i<n;i++){
        //     preSum[i]=preSum[i-1]+nums[i];
        //     suffPro[i]=suffPro[i-1]*nums[i];
        // }

        // for(int i=0;i<n;i++){
        //     long left=i==0?0:preSum[i-1];
        //     long right=i==n-1?1:suffPro[n-1]/suffPro[i];

        //     if(left==right)return i;
        // }
        // return -1;
        

        //Approach 2 failed: 
        // long left =0;
        // for(int i=0;i<n;i++){
        //     long right=1;
        //     for(int j=i+1;j<n;j++){
        //         right*=nums[j];
        //         if(right>left)break;
        //     }
        //     if(left==right)return i;

        //     left+=nums[i];
        // }
        // return -1;

        long preSum[] = new long[n];
        preSum[0]=nums[0];

        for(int i=1;i<n;i++)preSum[i]=preSum[i-1]+nums[i];
        long right=1;
        int ans=-1;
        for(int i=n-1;i>=0;i--){
            long left = i-1>=0?preSum[i-1]:0;
            if(left==right)ans=i;
            right*=nums[i];
            if(right<0)break;
        }
        return ans;

    }
}