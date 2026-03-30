/*You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:

The 2D array should contain only the elements of the array nums.
Each row in the 2D array contains distinct integers.
The number of rows in the 2D array should be minimal.
Return the resulting array. If there are multiple answers, return any of them.

Note that the 2D array can have a different number of elements on each row.

 

Example 1:

Input: nums = [1,3,4,1,2,3,1]
Output: [[1,3,4,2],[1,3],[1]]
Explanation: We can create a 2D array that contains the following rows:
- 1,3,4,2
- 1,3
- 1
All elements of nums were used, and each row of the 2D array contains distinct integers, so it is a valid answer.
It can be shown that we cannot have less than 3 rows in a valid array.
Example 2:

Input: nums = [1,2,3,4]
Output: [[4,3,2,1]]
Explanation: All elements of the array are distinct, so we can keep all of them in the first row of the 2D array.
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= nums.length */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        List<List<Integer>>ans = findMatrix(arr);
        for(List<Integer>ele: ans)System.out.print(ele+" ");

        
        sc.close();
    }
    public static List<List<Integer>> findMatrix(int[] nums) {
        int n =nums.length;
        List<List<Integer>>ans= new ArrayList<>();
        // for(int ele: nums){
        //     boolean placed=false;
        //     for(List<Integer>row: ans){
        //         if(!row.contains(ele)){
        //             row.add(ele);
        //             placed=true;
        //             break;
        //         }
        //     }
        //     if(!placed){
        //         List<Integer>newRow = new ArrayList<>();
        //         newRow.add(ele);
        //         ans.add(newRow);
        //     }
        // }

        //maximum rows - maximum frequency element kyuki har row unique elements se hona chahiye
        int freq[] = new int[n+1];
        for(int ele: nums)freq[ele]++;

        int maxi=0;
        for(int ele: freq)if(ele>maxi)maxi=ele;

        //ab itne rows bnega:

        for(int i=0;i<maxi;i++)ans.add(new ArrayList<>());

        //ab har row mei each element fill krenge 1 baar:

        for(int i=1;i<=n;i++){
            int f=freq[i]; //constraint mei hai 1 se n tk numbers honge

            for(int j=0;j<f;j++)ans.get(j).add(i); //har row mei us number ko add! (freq index ki trh kaam kr rha)
        }
        return ans;
    }
}