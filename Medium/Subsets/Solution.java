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

        List<List<Integer>> result = subsets(arr);

        for(List<Integer> ele: result)System.out.print(ele+" ");
        sc.close();
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        
        generate(0, nums, ds, ans);
        return ans;
    }
    static void generate(int index, int arr[], List<Integer> ds, List<List<Integer>>ans){
        if(index==arr.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        ds.add(arr[index]);
        generate(index+1, arr, ds, ans);
        ds.remove(ds.size()-1);
        generate(index+1, arr, ds, ans);

    }
}