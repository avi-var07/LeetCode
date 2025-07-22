/*Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 

Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
 */

// First sort them, then apply two pointer approach. Keep Two Pointers fixed and two movable, and skip duplicates!
import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements:");
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) 
        arr[i] = sc.nextInt();
        System.out.println("Enter the target: ");
        int target = sc.nextInt();
        List<List<Integer>> result = fourSum(arr, target);
        System.out.println("Unique quadraplets whose sum equals the target are: ");
        for(List<Integer> ele: result)
        System.out.print(ele+" ");
        
        sc.close();
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1])continue;
            for(int j = i+1;j<nums.length;j++){
                if(j>i+1 && nums[j]==nums[j-1])continue;
                int k = j+1, l=nums.length-1;
                while(k<l){
                    long sum = nums[i];
                    sum+=nums[j];
                    sum+=nums[k];
                    sum+=nums[l];
                    if(sum==target){
                        List<Integer> temp =  new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        k++;
                        l--;
                        ans.add(temp);
                        while(k<l && nums[k]==nums[k-1])k++;
                        while(k<l && nums[l]==nums[l+1])l--;
                    }
                    else if(sum<target)k++;
                    else l--;
                }
            }
        }
        return ans;
    }
}