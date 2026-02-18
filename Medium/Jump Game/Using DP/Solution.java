/*You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        Solution s = new Solution();
        System.out.println(s.canJump(arr));
        sc.close();
    }
    Boolean dp[];
    public boolean canJump(int[] nums) {
        int n =nums.length;
        if(nums[0]==0&&n>1)return false;
        else if(nums[0]==0&&n==1)return true;
        else if(n==1)return true;
        dp= new Boolean[n];
        return dfs_tab(nums, n);
    }
    // boolean dfs(int arr[], int idx, int n){
    //     if(idx==n-1)return dp[idx]=true;
    //     if(dp[idx]!=null)return dp[idx];
    //     for(int i=1;i<=arr[idx];i++){
    //         if(idx+i<n){
    //             if(dfs(arr, idx+i, n))return dp[idx]=true;
    //         }
    //     }
    //     return dp[idx]=false;
    // }
    boolean dfs_tab(int arr[], int n){
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                dp[i]=true;
                continue;
            }
            dp[i]=false;
            for(int j=1;j<=arr[i]&&i+j<n;j++){
                if(dp[i+j]!=null &&dp[i+j]){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[0];
    }
}