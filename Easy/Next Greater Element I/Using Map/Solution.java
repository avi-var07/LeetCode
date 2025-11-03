/*The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

 

Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
Example 2:

Input: nums1 = [2,4], nums2 = [1,2,3,4]
Output: [3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
- 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.
 

Constraints:

1 <= nums1.length <= nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 104
All integers in nums1 and nums2 are unique.
All the integers of nums1 also appear in nums2.
 

Follow up: Could you find an O(nums1.length + nums2.length) solution? */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements of nums1: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println("Enter number of elements of nums2: ");
        int m = sc.nextInt();
        int arr2[] = new int[m];
        System.out.println("Enter "+m+" elements: ");
        for(int i=0;i<m;i++)arr2[i] = sc.nextInt();

        int ans[] = nextGreaterElement(arr, arr2);

        for(int ele: ans)System.out.print(ele+ " ");
        
        sc.close();
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        Map<Integer, Integer>map = new HashMap<>();
        Stack<Integer>st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&st.peek()<=nums2[i])st.pop();

            map.put(nums2[i], st.isEmpty()? -1 : st.peek());

            st.push(nums2[i]);
        }
        int n1 = nums1.length;
        int res[]=new int[n1];
   
        for(int i=0;i<n1;i++)res[i] = map.get(nums1[i]);
        
        return res;
    }
}