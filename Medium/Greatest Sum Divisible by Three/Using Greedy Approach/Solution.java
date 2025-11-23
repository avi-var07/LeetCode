/*Given an integer array nums, return the maximum possible sum of elements of the array such that it is divisible by three.

 

Example 1:

Input: nums = [3,6,5,1,8]
Output: 18
Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).
Example 2:

Input: nums = [4]
Output: 0
Explanation: Since 4 is not divisible by 3, do not pick any number.
Example 3:

Input: nums = [1,2,3,4,4]
Output: 12
Explanation: Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum divisible by 3).
 

Constraints:

1 <= nums.length <= 4 * 104
1 <= nums[i] <= 104
 
 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println(maxSumDivThree(arr));
        sc.close();
    }
    public static int maxSumDivThree(int[] nums) {
        int sum =0;
        List<Integer>rem1 = new ArrayList<>();
        List<Integer>rem2 = new ArrayList<>();

        for(int ele: nums){
            sum+=ele;
            if(ele%3==1)rem1.add(ele);
            else if(ele%3==2)rem2.add(ele);
        }
        if(sum%3==0)return sum;
        Collections.sort(rem1);
        Collections.sort(rem2);

        int ans = 0;
        int rem = sum%3;
        if(rem==1){
            int remove1 = rem1.size()>=1?rem1.get(0):Integer.MAX_VALUE;
            int remove2 = rem2.size()>=2?(rem2.get(0)+rem2.get(1)):Integer.MAX_VALUE;
            ans = Math.max(ans, sum-Math.min(remove1, remove2));
        }
        else{
            int remove1 = rem2.size()>=1?rem2.get(0):Integer.MAX_VALUE;
            int remove2 = rem1.size()>=2?(rem1.get(0)+rem1.get(1)):Integer.MAX_VALUE;

            ans = Math.max(ans, sum-Math.min(remove1, remove2));
        }
        return ans;
    }
}