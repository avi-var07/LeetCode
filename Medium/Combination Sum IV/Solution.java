/*Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

The test cases are generated so that the answer can fit in a 32-bit integer.

 

Example 1:

Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.
Example 2:

Input: nums = [9], target = 3
Output: 0
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 1000
All the elements of nums are unique.
1 <= target <= 1000 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        System.out.println("Enter target: ");
        int target = sc.nextInt();
        System.out.println(combinationSum4(arr, target));
        sc.close();
    }
    static Integer dp[][];
    public static int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        dp = new Integer[n][target+1];
        return solve(nums,target,0);
    }
    static int solve(int arr[], int target, int index){
        if(target==0)return 1;
        
        if(target<0)return 0 ;
        if(index==arr.length)return 0;
        if(dp[index][target]!=null)return dp[index][target];
        int pick=solve(arr,target-arr[index],0);

        int notPick=solve(arr,target,index+1);

        return dp[index][target]= pick+notPick;
    }
}