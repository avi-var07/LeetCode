/*Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

Constraints:

1 <= nums.length <= 8
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

        List<List<Integer>>list = permuteUnique(arr);

        for(var ele: list)System.out.print(ele+" ");

        sc.close();
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ds = new ArrayList<>();

        List<List<Integer>>ans = new ArrayList<>();

        boolean visited[] = new boolean[nums.length];

        generate(ds, ans, nums, visited);
        return ans;
    }
    static void generate(List<Integer> ds, List<List<Integer>>ans, int arr[], boolean visited[]){
        if(ds.size()==arr.length){
            ans.add(new ArrayList<>(ds));
            return ;
        }

        for(int i=0;i<arr.length;i++){
            if(visited[i])continue;
            
            if(i>0&&arr[i]==arr[i-1]&&!visited[i-1])continue;
            visited[i]=true;
            ds.add(arr[i]);
               
            generate(ds, ans, arr, visited);
            
            ds.remove(ds.size()-1);
            visited[i]=false;
            
        }
    }
   
}