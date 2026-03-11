/*You are given a 0-indexed integer array nums of size n.

Define two arrays leftSum and rightSum where:

leftSum[i] is the sum of elements to the left of the index i in the array nums. If there is no such element, leftSum[i] = 0.
rightSum[i] is the sum of elements to the right of the index i in the array nums. If there is no such element, rightSum[i] = 0.
Return an integer array answer of size n where answer[i] = |leftSum[i] - rightSum[i]|.

 

Example 1:

Input: nums = [10,4,8,3]
Output: [15,1,11,22]
Explanation: The array leftSum is [0,10,14,22] and the array rightSum is [15,11,3,0].
The array answer is [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|] = [15,1,11,22].
Example 2:

Input: nums = [1]
Output: [0]
Explanation: The array leftSum is [0] and the array rightSum is [0].
The array answer is [|0 - 0|] = [0].
 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 105 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        int ans[] = leftRightDifference(arr);

        for(int ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    public static int[] leftRightDifference(int[] nums) {
        int n =nums.length;
        int ans[] = new int[n];
        int left[] = new int[n];
        int right[] = new int[n];

        left[0] =0;
        for(int i=1;i<n;i++)left[i]=left[i-1]+nums[i-1];
        right[n-1]=0;
        for(int i=n-2;i>=0;i--)right[i]=right[i+1]+nums[i+1];
        
        for(int i=0;i<n;i++)ans[i]=Math.abs(left[i]-right[i]);
        return ans;
    }
}