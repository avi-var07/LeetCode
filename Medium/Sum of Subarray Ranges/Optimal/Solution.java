/*You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.

Return the sum of all subarray ranges of nums.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,2,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0 
[2], range = 2 - 2 = 0
[3], range = 3 - 3 = 0
[1,2], range = 2 - 1 = 1
[2,3], range = 3 - 2 = 1
[1,2,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.
Example 2:

Input: nums = [1,3,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[3], range = 3 - 3 = 0
[3], range = 3 - 3 = 0
[1,3], range = 3 - 1 = 2
[3,3], range = 3 - 3 = 0
[1,3,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.
Example 3:

Input: nums = [4,-2,-3,4,1]
Output: 59
Explanation: The sum of all subarray ranges of nums is 59.
 

Constraints:

1 <= nums.length <= 1000
-109 <= nums[i] <= 109
 

Follow-up: Could you find a solution with O(n) time complexity?

  */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        Solution s = new Solution();
        
        System.out.println(s.subArrayRanges(arr));
        sc.close();
    }
    Stack<Integer>st;
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        return sumSubarrayMax(nums, n) - sumSubarrayMin(nums, n);
    }
    long sumSubarrayMin(int arr[], int n){
        int ns[] = new int[n];
        int ps[] = new int[n];
        st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&arr[st.peek()]>arr[i])st.pop();
            ps[i] = st.isEmpty()?-1:st.peek();

            st.push(i);
        }
        st.clear();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i])st.pop();
            ns[i] = st.isEmpty()? n: st.peek();

            st.push(i);
        }
        long sum = 0;
        for(int i=0;i<n;i++){
            int left = i-ps[i];
            int right = ns[i]-i;

            sum+= (long)arr[i]*left*right;
            
            
        }
        return sum;
    }
    long sumSubarrayMax(int arr[], int n){
        int ng[] = new int[n];
        int pg[] = new int[n];
        st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&arr[st.peek()]<arr[i])st.pop();
            pg[i] = st.isEmpty()?-1:st.peek();

            st.push(i);
        }
        st.clear();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&arr[st.peek()]<=arr[i])st.pop();
            ng[i] = st.isEmpty()? n: st.peek();

            st.push(i);
        }
        long sum = 0;
        for(int i=0;i<n;i++){
            int left = i-pg[i];
            int right = ng[i]-i;

            sum+= (long)arr[i]*left*right;
            
            
        }
        return sum;

    }
}