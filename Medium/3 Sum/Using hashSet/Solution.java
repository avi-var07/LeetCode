/*Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */

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
        
        List<List<Integer>> ans = threeSum(arr);
        System.out.println("triplets with sum==0 are: ");
        for(List<Integer> ele: ans)
        System.out.print(ele+" ");
        
        sc.close();
    }
    public static List<List<Integer>> threeSum(int[] arr) {
        Set<List<Integer>> ans = new HashSet<>();
        for(int i = 0; i<arr.length;i++){
            Set<Integer> set = new HashSet<>();
            for(int j = i+1; j<arr.length;j++){
                int remaining =  -(arr[i]+arr[j]);
                if(set.contains(remaining)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(remaining);
                    Collections.sort(temp);
                    ans.add(temp);

                }
                set.add(arr[j]);

            }
        }
        return new ArrayList<>(ans);
    }
}