/*Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000 */
import java.util.*;
class Solution {
    static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> intersect =new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();
        
        for(int i:nums1) set1.add(i);
    
        for(int i:nums2) if(set1.contains(i)) intersect.add(i);
        int ans[] = new int[intersect.size()];
        int k=0;
        for(int i:intersect)    {
            ans[k]=i;
            k++;
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the first array");
        int n = sc.nextInt();
        int nums1[] = new int[n];
        System.out.println("Enter the elements of the first array");
        for(int i=0;i<n;i++) nums1[i] = sc.nextInt();
        System.out.println("Enter the size of the second array");
        int m = sc.nextInt();
        int nums2[] = new int[m];
        System.out.println("Enter the elements of the second array");
        for(int i=0;i<m;i++) nums2[i] = sc.nextInt();
        int ans[] = intersection(nums1,nums2);
        System.out.println("The intersection of the two arrays is:");
        for(int i:ans) System.out.print(i+" ");
        sc.close();
    }
}