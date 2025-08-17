/*Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
 */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements of first array: ");
        int m = sc.nextInt();
        System.out.println("Enter " + m + " elements:");
        int arr1[] = new int[m];
        for(int i = 0; i < m; i++) 
        arr1[i] = sc.nextInt();
        System.out.println("Enter number of elements of second array: ");
        int n= sc.nextInt();
        System.out.println("Enter " + m + " elements:");
        int arr2[] = new int[n];
        for(int i = 0; i < n; i++) 
        arr2[i] = sc.nextInt();

        System.out.println("Median of the two sorted arrays is: "+findMedianSortedArrays(arr1, arr2));
        
        
        sc.close();
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2= nums2.length;
    
        int n = n1+n2;
        if(n1>n2)return findMedianSortedArrays(nums2, nums1);
        int left = (n1+n2+1)/2;
        int low=0, high = n1;
        while(low<=high){
            int mid1 = low+(high-low)/2;
            int mid2 = left-mid1;
            int l1 = (mid1>0)?nums1[mid1-1]:Integer.MIN_VALUE;
            int l2 = (mid2>0)?nums2[mid2-1]:Integer.MIN_VALUE;
            int r1 = (mid1<n1)?nums1[mid1]:Integer.MAX_VALUE;
            int r2 = (mid2<n2)?nums2[mid2]:Integer.MAX_VALUE;

            if(l1<=r2&&l2<=r1){
                if(n%2==1){
                    if(l1>l2)return l1;
                    else return l2;
                }
                else{
                    if(l1>l2){
                        if(r1<r2)return (l1+r1)/2.0;
                        else return (l1+r2)/2.0;
                    }
                    else{
                        if(r1<r2)return (l2+r1)/2.0;
                        else return (l2+r2)/2.0;
                    }
                }
            }
            else if(l1>r2)high=mid1-1;
            else low=mid1+1;
        }
        return 0;
    }
}