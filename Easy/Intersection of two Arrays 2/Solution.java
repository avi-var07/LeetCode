/*Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000 */

import java.util.*;

class Solution {
    static  int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums1) list.add(i);
        ArrayList<Integer> intersect = new ArrayList<>();
        
        for (int i : nums2) {
            if (list.contains(i)) {
                intersect.add(i);
                list.remove((Integer) i);
            }
        }

        int k = 0;
        int ans[] = new int[intersect.size()];
        for (int i : intersect) {
            ans[k] = i;
            k++;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array1");
        int n = sc.nextInt();   
        int nums1[] = new int[n];
        System.out.println("Enter the elements of array1");
        for (int i = 0; i < n; i++) nums1[i] = sc.nextInt();
        System.out.println("Enter the size of array2");
        int m = sc.nextInt();   
        int nums2[] = new int[m];
        System.out.println("Enter the elements of array2");
        for (int i = 0; i < m; i++) nums2[i] = sc.nextInt();
        int ans[] = intersect(nums1, nums2);
        for (int i : ans) System.out.print(i + " ");
        sc.close();
    }
}
