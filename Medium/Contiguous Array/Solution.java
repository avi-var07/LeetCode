/*Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

 

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Example 3:

Input: nums = [0,1,1,1,1,1,0,0,0]
Output: 6
Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println(findMaxLength(arr));
        sc.close();
    }
    //count0==count1, mtlb 0->-1, 1->-1 aur sum krte jao, agar sum==0 mtlb -1,+1 equal hai
    public static int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer>map = new HashMap<>();
        map.put(0,-1); 
        int maxi=0;
        int sum=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1)sum++;
            else sum--;

            if(map.containsKey(sum))maxi=Math.max(maxi, i-map.get(sum));
            else map.put(sum,i);
        }
        return maxi;
    }
}