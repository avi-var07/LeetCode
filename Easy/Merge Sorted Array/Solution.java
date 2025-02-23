/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 

Constraints:

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
   static void merge(int[] nums1, int m, int[] nums2, int n) {
        int merge[] = new int[m+n];
        for(int i=0;i<m;i++)
        merge[i]=nums1[i];

        for(int i=0;i<n;i++)
        merge[m+i]=nums2[i];

        Arrays.sort(merge);


        for(int i=0;i<merge.length;i++){
            if(merge[i]!=0)
            System.out.print(merge[i]+" ");
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements of array1: ");
        int m=sc.nextInt();

        int arr1[]=new int[m];

        System.out.println("Enter array1 elements: ");

        for(int i=0;i<m;i++)
        arr1[i]=sc.nextInt();

        System.out.println("Enter number of elements of array2: ");
        int n=sc.nextInt();

        int arr2[]=new int[n];

        System.out.println("Enter array2 elements: ");

        for(int i=0;i<n;i++)
        arr2[i]=sc.nextInt();
        
        merge(arr1, m, arr2, n);
        
        sc.close();
    }
}