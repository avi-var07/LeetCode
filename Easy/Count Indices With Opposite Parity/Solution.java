/*You are given an integer array nums of length n.

The score of an index i is defined as the number of indices j such that:

i < j < n, and
nums[i] and nums[j] have different parity (one is even and the other is odd).
Return an integer array answer of length n, where answer[i] is the score of index i.

 

Example 1:

Input: nums = [1,2,3,4]

Output: [2,1,1,0]

Explanation:

nums[0] = 1, which is odd. Thus, the indices j = 1 and j = 3 satisfy the conditions, so the score of index 0 is 2.
nums[1] = 2, which is even. Thus, the index j = 2 satisfies the conditions, so the score of index 1 is 1.
nums[2] = 3, which is odd. Thus, the index j = 3 satisfies the conditions, so the score of index 2 is 1.
nums[3] = 4, which is even. Thus, no index satisfies the conditions, so the score of index 3 is 0.
Thus, the answer = [2, 1, 1, 0].

Example 2:

Input: nums = [1]

Output: [0]

Explanation:

There is only one element in nums. Thus, the score of index 0 is 0.

 

Constraints:

1 <= nums.length <= 100
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
        
        int ans[] = countOppositeParity(arr);

        for(int ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    public static int[] countOppositeParity(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int cnt1= 0; //even
        int cnt2=0; //odd

        for(int ele: nums){
            if(ele%2==0)cnt1++;
            else cnt2++;
        }
        int index=0;
        for(int ele:nums){
            if(ele%2==0){
                cnt1--;
                ans[index++]=cnt2;
            }
            else {
                cnt2--;
                ans[index++]=cnt1;
            }

        }

        return ans;
        
    }
}