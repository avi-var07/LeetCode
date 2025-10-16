/*Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        List<List<Integer>>list = subsetsWithDup(arr);
        for(List<Integer>ele: list)System.out.print(ele+" ");
        sc.close();
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>>ans = new ArrayList<>();

        generate(0,nums,ds,ans);
        return ans;
    }
    static void generate(int index, int arr[], List<Integer> ds, List<List<Integer>>ans){
        
        ans.add(new ArrayList<>(ds));
            
        
        for(int i=index;i<arr.length;i++){
            if(i>index&&arr[i]==arr[i-1])continue;
            ds.add(arr[i]);
            generate(i+1,arr,ds,ans);
            ds.remove(ds.size()-1);
        }
    }
}