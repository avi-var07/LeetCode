/*You are given a sorted integer array nums and an integer k.

Return an array such that each distinct element appears at most k times, while preserving the relative order of the elements in nums.

Note: If a distinct element appears at least k times, then it must appear exactly k times in the resulting array.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2

Output: [1,1,2,2,3]

Explanation:

Each element can appear at most 2 times.

The element 1 appears 3 times, so only 2 occurrences are kept.
The element 2 appears 2 times, so both occurrences are kept.
The element 3 appears 1 time, so it is kept.
Thus, the resulting array is [1, 1, 2, 2, 3].

Example 2:

Input: nums = [1,2,3], k = 1

Output: [1,2,3]

Explanation:

All elements are distinct and already appear at most once, so the array remains unchanged.

 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100
nums is sorted in non-decreasing order.
1 <= k <= nums.length
 

Follow-up:

Can you solve this in-place using O(1) extra space?
Note that the space used for returning or resizing the result does not count toward the space complexity mentioned above, as some languages do not support in-place resizing. */
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
        int k =sc.nextInt();

        int ans[] = limitOccurrences(arr, k);

        for(int ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    public static int[] limitOccurrences(int[] nums, int k) {
        Map<Integer,Integer>map = new HashMap<>();
        for(int ele: nums)map.put(ele, map.getOrDefault(ele,0)+1);
        List<Integer>ans = new ArrayList<>();
        Set<Integer>set = new HashSet<>();
        for(int ele: nums){
            if(!set.contains(ele)){
                if(map.get(ele)>=k){
                    for(int i=0;i<k;i++)ans.add(ele);
                }
                else {
                    for(int i=0;i<map.get(ele);i++)ans.add(ele);
                }
                set.add(ele);
            }
        }

        int index=0;
        int n=ans.size();
        int res[] =new int[n];
        for(int i=0;i<n;i++)res[index++]=ans.get(i);

        return res;
    }
}