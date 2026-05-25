/*You are given an integer array nums.

In one operation, you can choose any two distinct indices i and j and swap nums[i] and nums[j].

Return an integer denoting the minimum number of operations required to move all 0s to the end of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]

Output: 2

Explanation:

We perform the following swap operations:

Swap nums[0] and nums[3], giving nums = [3, 1, 0, 0, 12].
Swap nums[2] and nums[4], giving nums = [3, 1, 12, 0, 0].
Thus, the answer is 2.

Example 2:

Input: nums = [0,1,0,2]

Output: 1

Explanation:

We perform the following swap operations:

Swap nums[0] and nums[3], giving nums = [2, 1, 0, 0].
Thus, the answer is 1.

Example 3:

Input: nums = [1,2,0]

Output: 0

Explanation:

The array already satisfies the condition. Therefore, no swap operations are needed.

 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        
        System.out.println(minimumSwaps(arr));
        sc.close();
    }
    public static int minimumSwaps(int[] nums) {
        int cnt=0;
        for(int ele: nums)if(ele==0)cnt++;

        int n =nums.length;
        int correct =0;
        for(int i=n-1;i>=n-cnt;i--)if(nums[i]==0)correct++;

        return cnt-correct;
    }
}