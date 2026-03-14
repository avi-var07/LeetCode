/*You are given two integer arrays nums1 and nums2 of size n.

You can perform the following two operations any number of times on these two arrays:

Swap within the same array: Choose two indices i and j. Then, choose either to swap nums1[i] and nums1[j], or nums2[i] and nums2[j]. This operation is free of charge.
Swap between two arrays: Choose an index i. Then, swap nums1[i] and nums2[i]. This operation incurs a cost of 1.
Return an integer denoting the minimum cost to make nums1 and nums2 identical. If this is not possible, return -1.

 

Example 1:

Input: nums1 = [10,20], nums2 = [20,10]

Output: 0

Explanation:

Swap nums2[0] = 20 and nums2[1] = 10.
nums2 becomes [10, 20].
This operation is free of charge.
nums1 and nums2 are now identical. The cost is 0.
Example 2:

Input: nums1 = [10,10], nums2 = [20,20]

Output: 1

Explanation:

Swap nums1[0] = 10 and nums2[0] = 20.
nums1 becomes [20, 10].
nums2 becomes [10, 20].
This operation costs 1.
Swap nums2[0] = 10 and nums2[1] = 20.
nums2 becomes [20, 10].
This operation is free of charge.
nums1 and nums2 are now identical. The cost is 1.
Example 3:

Input: nums1 = [10,20], nums2 = [30,40]

Output: -1

Explanation:

It is impossible to make the two arrays identical. Therefore, the answer is -1.

 

Constraints:

2 <= n == nums1.length == nums2.length <= 8 * 104
1 <= nums1[i], nums2[i] <= 8 * 104 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements of arr1: ");
        int n = sc.nextInt();

        int arr1[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr1[i] = sc.nextInt();
        System.out.println("Enter number of Elements of arr2: ");
        int m = sc.nextInt();

        int arr2[] = new int[m];
        System.out.println("Enter "+m+" elements: ");
        for(int i=0;i<m;i++) arr2[i] = sc.nextInt();

        System.out.println(minCost(arr1, arr2));
        sc.close();
    }
    public static int minCost(int[] nums1, int[] nums2) {
        Map<Integer, Integer>map=new HashMap<>();

        for(int ele: nums1)map.put(ele, map.getOrDefault(ele,0)+1);

        for(int ele: nums2)map.put(ele, map.getOrDefault(ele,0)+1);

        for(int ele: map.values())if(ele%2!=0)return -1;

        Map<Integer, Integer>count=new HashMap<>();

        for(int ele: nums1)count.put(ele, count.getOrDefault(ele,0)+1);

        int diff=0;

        for(int ele: nums2){
            if(count.getOrDefault(ele,0)>0)count.put(ele, count.get(ele)-1);
            else diff++;
        }

        return diff/2;
        
    }
}