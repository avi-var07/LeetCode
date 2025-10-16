/*Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println("Enter the value of k: ");
        int k= sc.nextInt();

        List<List<Integer>> list = combinationSum2(arr, k);

        for(List<Integer> ele : list)System.out.print(ele+" ");

        sc.close();
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        generate(0,candidates, target,ds,ans);
        return ans;

    }
    static void generate(int index, int arr[], int target, List<Integer>ds, List<List<Integer>>ans){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index;i<arr.length;i++){
            if(i>index&&arr[i]==arr[i-1])continue;  //skip duplicates
            if(arr[i]>target)break;
            ds.add(arr[i]);
            generate(i+1, arr, target-arr[i], ds, ans); //because moving to ith position
            ds.remove(ds.size()-1);
        }

        
    }
}