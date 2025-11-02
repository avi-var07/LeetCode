/*You are given an integer array nums consisting of unique integers.

Originally, nums contained every integer within a certain range. However, some integers might have gone missing from the array.

The smallest and largest integers of the original range are still present in nums.

Return a sorted list of all the missing integers in this range. If no integers are missing, return an empty list.

 

Example 1:

Input: nums = [1,4,2,5]

Output: [3]

Explanation:

The smallest integer is 1 and the largest is 5, so the full range should be [1,2,3,4,5]. Among these, only 3 is missing.

Example 2:

Input: nums = [7,8,6,9]

Output: []

Explanation:

The smallest integer is 6 and the largest is 9, so the full range is [6,7,8,9]. All integers are already present, so no integer is missing.

Example 3:

Input: nums = [5,1]

Output: [2,3,4]

Explanation:

The smallest integer is 1 and the largest is 5, so the full range should be [1,2,3,4,5]. The missing integers are 2, 3, and 4.

 

Constraints:

2 <= nums.length <= 100
1 <= nums[i] <= 100

Note: Please do not copy the description during the contest to maintain the integrity of your submissions. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        List<Integer>ans = findMissingElements(arr);
        for(int ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    public static List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer>ans = new ArrayList<>();
        HashSet<Integer>set =  new HashSet<>();
        int n = nums.length;
        int maxi = nums[n-1];
        int mini = nums[0];

        for(int ele: nums)set.add(ele);

        for(int i=mini;i<=maxi;i++){
            if(!set.contains(i))ans.add(i);
        }
        
        return ans;
    }

}