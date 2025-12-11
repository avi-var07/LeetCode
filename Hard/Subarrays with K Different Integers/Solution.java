/*Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
Example 2:

Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 

Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i], k <= nums.length */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        System.out.println("Enter k: ");
        int k = sc.nextInt();

        System.out.println(subarraysWithKDistinct(arr, k));
        sc.close();
    }
    public static int subarraysWithKDistinct(int[] arr, int k) {
        return solve(k, arr)-solve(k-1, arr);
    }
    static int solve(int k, int arr[]){
        if(k==0)return 0;
        int left = 0, right = 0;
        Map<Integer, Integer>map = new HashMap<>();
        int n = arr.length, count=0;
        while(right<n){
            map.put(arr[right], map.getOrDefault(arr[right],0)+1);
            while(map.size()>k){
                map.put(arr[left], map.get(arr[left])-1);
                if(map.get(arr[left])==0)map.remove(arr[left]);
                left++;
            }
            count+=right-left+1;
            right++;
        }
        return count;
    }
}