/*Given an array of integers nums, half of the integers in nums are odd, and the other half are even.

Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.

Return any answer array that satisfies this condition.

 

Example 1:

Input: nums = [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
Example 2:

Input: nums = [2,3]
Output: [2,3]
 

Constraints:

2 <= nums.length <= 2 * 104
nums.length is even.
Half of the integers in nums are even.
0 <= nums[i] <= 1000
 

Follow Up: Could you solve it in-place? */
import java.util.*;
class Solution {
    public static int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int odd[] = new int[n/2];
        int even[] = new int[n/2];
        
        int i=0,j=0;
        for(int num:nums){
            if(num%2==0){
                even[i] = num;
                i++;
            }
            else{
                odd[j]=num;
                j++;
            }
        }


        int ans[] = new int [n];
        int l=0,m=0;
        for(int k=0;k<n;k++){
            if(k%2==0){
                ans[k]=even[l];
                l++;
            }
            else{
                ans[k]=odd[m];
                m++;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int nums[] = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int ans[] = sortArrayByParityII(nums);
        System.out.println("The sorted array on the basis of odd-even parity is: ");
        for(int i=0;i<n;i++){
            System.out.print(ans[i]+" ");
        }
        sc.close();
    }
}