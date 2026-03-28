/*You are given two 2D integer arrays nums1 and nums2.

nums1[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
nums2[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
Each array contains unique ids and is sorted in ascending order by id.

Merge the two arrays into one array that is sorted in ascending order by id, respecting the following conditions:

Only ids that appear in at least one of the two arrays should be included in the resulting array.
Each id should be included only once and its value should be the sum of the values of this id in the two arrays. If the id does not exist in one of the two arrays, then assume its value in that array to be 0.
Return the resulting array. The returned array must be sorted in ascending order by id.

 

Example 1:

Input: nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
Output: [[1,6],[2,3],[3,2],[4,6]]
Explanation: The resulting array contains the following:
- id = 1, the value of this id is 2 + 4 = 6.
- id = 2, the value of this id is 3.
- id = 3, the value of this id is 2.
- id = 4, the value of this id is 5 + 1 = 6.
Example 2:

Input: nums1 = [[2,4],[3,6],[5,5]], nums2 = [[1,3],[4,3]]
Output: [[1,3],[2,4],[3,6],[4,3],[5,5]]
Explanation: There are no common ids, so we just include each id with its value in the resulting list.
 

Constraints:

1 <= nums1.length, nums2.length <= 200
nums1[i].length == nums2[j].length == 2
1 <= idi, vali <= 1000
Both arrays contain unique ids.
Both arrays are in strictly ascending order by id.
 
 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements of num1: ");
        int n = sc.nextInt();
        
        int arr1[][] = new int[n][2];
        System.out.println("Enter "+n+" elements of nums1: ");
        for(int i=0;i<n;i++) {
            
            System.out.println("Enter id: ");
            arr1[i][0] = sc.nextInt();
            System.out.println("Enter value: ");
            arr1[i][1] = sc.nextInt();
        }
        System.out.println("Enter number of Elements of num2: ");
        int m = sc.nextInt();
        
        int arr2[][] = new int[m][2];
        System.out.println("Enter "+n+" elements of nums2: ");
        for(int i=0;i<n;i++) {
            
            System.out.println("Enter id: ");
            arr2[i][0] = sc.nextInt();
            System.out.println("Enter value: ");
            arr2[i][1] = sc.nextInt();
        }

        int ans[][] =mergeArrays(arr1, arr2);

        for(int ele[]: ans)System.out.print(ele[0]+","+ele[1]);
        sc.close();
    }
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int m =nums1.length;
        int n =nums2.length;

        int left=0, right=0;

        int ans[][] = new int[m+n][2];

        int index=0;
        while(left<m&&right<n){
            int a[]=nums1[left];
            int b[]=nums2[right];

            if(a[0]==b[0]){
                ans[index][0]=a[0];
                ans[index][1]=a[1]+b[1];
                index++;
                left++;
                right++;
            }
            else if(a[0]<b[0]){
                ans[index][0]=a[0];
                ans[index][1]=a[1];
                index++;
                left++;
            }
            else{
                ans[index][0]=b[0];
                ans[index][1]=b[1];
                right++;
                index++;
            }
        }

        while(left<m){
            ans[index][0]=nums1[left][0];
            ans[index][1]=nums1[left][1];
            index++;
            left++;
        }
        while(right<n){
            ans[index][0]=nums2[right][0];
            ans[index][1]=nums2[right][1];
            index++;
            right++;
        }
        return Arrays.copyOf(ans, index); //original array, new size
    }
}