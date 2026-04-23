/*You are given a 0-indexed integer array nums. There exists an array arr of length nums.length, where arr[i] is the sum of |i - j| over all j such that nums[j] == nums[i] and j != i. If there is no such j, set arr[i] to be 0.

Return the array arr.

 

Example 1:

Input: nums = [1,3,1,1,2]
Output: [5,0,3,4,0]
Explanation: 
When i = 0, nums[0] == nums[2] and nums[0] == nums[3]. Therefore, arr[0] = |0 - 2| + |0 - 3| = 5. 
When i = 1, arr[1] = 0 because there is no other index with value 3.
When i = 2, nums[2] == nums[0] and nums[2] == nums[3]. Therefore, arr[2] = |2 - 0| + |2 - 3| = 3. 
When i = 3, nums[3] == nums[0] and nums[3] == nums[2]. Therefore, arr[3] = |3 - 0| + |3 - 2| = 4. 
When i = 4, arr[4] = 0 because there is no other index with value 2. 

Example 2:

Input: nums = [0,5,3]
Output: [0,0,0]
Explanation: Since each element in nums is distinct, arr[i] = 0 for all i.
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 109 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        long ans[] = distance(arr);
        for(long ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    public static long[] distance(int[] nums) {
        int n =nums.length;
        long ans[] = new long[n];
        
        Map<Integer, Long>indexCount = new HashMap<>(); //kisi number ko kitni baar dekha ab tak
        Map<Integer, Long>indexSum = new HashMap<>(); //un indices ka total sum
        
        //Left to right: freq*i-sum
        for(int i=0;i<n;i++){
            long freq = indexCount.getOrDefault(nums[i], 0L);
            long sum = indexSum.getOrDefault(nums[i], 0L);

            ans[i]+=freq*i-sum; 
            //include current element:
            indexCount.put(nums[i], freq+1);
            indexSum.put(nums[i], sum+i);
        }
        //maps reset for right to left:
        indexSum.clear();
        indexCount.clear();
        //right to left: sum-freq*i
        for(int i=n-1;i>=0;i--){
            long freq = indexCount.getOrDefault(nums[i], 0L);
            long sum = indexSum.getOrDefault(nums[i], 0L);

            ans[i]+=sum-freq*i;
            //include current element:
            indexCount.put(nums[i], freq+1);
            indexSum.put(nums[i], sum+i);
        }
        return ans;
    }
}