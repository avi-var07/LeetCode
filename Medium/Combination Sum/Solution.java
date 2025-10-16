/*Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
 

Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40 */

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

        List<List<Integer>> list = combinationSum(arr, target);

        for(List<Integer> ele: list)System.out.print(ele+" ");

        sc.close();
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        generate(candidates, ds, target, ans, 0, 0);

        return ans;
    }
    static void generate(int arr[], List<Integer> ds, int target, List<List<Integer>>ans, int index, int sum){
        if(index==arr.length){
            if(sum==target)ans.add(new ArrayList<>(ds));
            
            return;
            
        }

        if(sum>target)return;
        ds.add(arr[index]);
        sum+=arr[index];
        generate(arr, ds, target, ans, index, sum);
        ds.remove(ds.size()-1);
        sum-=arr[index];
        generate(arr, ds, target, ans, index+1, sum);
    }
}