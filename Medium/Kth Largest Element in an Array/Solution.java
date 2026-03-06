/*Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:

1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104 */
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

        System.out.println(findKthLargest(arr, k));

        sc.close();
    }
    public static int findKthLargest(int[] nums, int k) {
        // max-heap se: PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
        // for(int ele: nums)pq.add(ele);

        // for(int i=0;i<k-1;i++)pq.poll();

        // return pq.peek();

        PriorityQueue<Integer>pq = new PriorityQueue<>();
        for(int ele: nums){
            pq.add(ele);
            if(pq.size()>k)pq.poll();
        }
        return pq.peek();
    }
}