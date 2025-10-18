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

        List<List<Integer>> list  = permuteUnique(arr);
        for(var ele: list)System.out.print(ele+" ");
        sc.close();
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        
        List<Integer> ds = new ArrayList<>();

        List<List<Integer>>ans = new ArrayList<>();

        generate(ds, ans, 0, nums);
        return ans;
    }
    static void generate(List<Integer> ds, List<List<Integer>>ans, int index, int arr[]){
        if(index==arr.length){
            ans.add(new ArrayList<>(ds));
            return ;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=index;i<arr.length;i++){
            if(set.contains(arr[i]))continue;
            set.add(arr[i]);

            ds.add(arr[i]);
            swap(arr, i, index);
            generate(ds, ans, index+1, arr);
            swap(arr, i, index);
            ds.remove(ds.size()-1);
        }
    }
    static void swap(int arr[], int a, int b){
        int temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}