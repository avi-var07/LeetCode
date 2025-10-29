/*Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique. */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        List<List<Integer>>ans = subsets(arr);

        for(var ele: ans)System.out.print(ele+" ");

        sc.close();
    }
    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int subsets = (1<<n);
        List<List<Integer>>ans = new ArrayList<>();
        for(int num=0;num<=subsets-1;num++){
            List<Integer>list = new ArrayList<>();
            for(int i=0;i<n;i++){
                if((num&(1<<i))!=0)list.add(nums[i]);
            }
            ans.add(list);
        }
        return ans;
    }
}