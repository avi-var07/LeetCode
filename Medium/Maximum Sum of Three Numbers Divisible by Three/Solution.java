/*You are given an integer array nums.

Your task is to choose exactly three integers from nums such that their sum is divisible by three.

Return the maximum possible sum of such a triplet. If no such triplet exists, return 0.

 

Example 1:

Input: nums = [4,2,3,1]

Output: 9

Explanation:

The valid triplets whose sum is divisible by 3 are:

(4, 2, 3) with a sum of 4 + 2 + 3 = 9.
(2, 3, 1) with a sum of 2 + 3 + 1 = 6.
Thus, the answer is 9.

Example 2:

Input: nums = [2,1,5]

Output: 0

Explanation:

No triplet forms a sum divisible by 3, so the answer is 0.

 

Constraints:

3 <= nums.length <= 105
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

        System.out.println(maximumSum(arr));
        
        sc.close();
    }
    public static int maximumSum(int[] nums) {
        List<Integer>rem1 = new ArrayList<>();
        List<Integer>rem2 = new ArrayList<>();
        List<Integer>rem0 = new ArrayList<>();

        for(int ele: nums){
            if(ele%3==1)rem1.add(ele);
            else if(ele%3==2)rem2.add(ele);
            else rem0.add(ele);
        }
        Collections.sort(rem0, Collections.reverseOrder());
        Collections.sort(rem1, Collections.reverseOrder());
        Collections.sort(rem2, Collections.reverseOrder());

        int ans = 0;

        if(rem0.size()>=3)ans = Math.max(ans, rem0.get(0)+rem0.get(1)+rem0.get(2));
        if(rem1.size()>=3)ans = Math.max(ans, rem1.get(0)+rem1.get(1)+rem1.get(2));
        if(rem2.size()>=3)ans = Math.max(ans, rem2.get(0)+rem2.get(1)+rem2.get(2));

        if(rem0.size()>=1&&rem1.size()>=1&&rem2.size()>=1)ans = Math.max(ans, rem0.get(0)+rem1.get(0)+rem2.get(0));

        return ans;
    }
}