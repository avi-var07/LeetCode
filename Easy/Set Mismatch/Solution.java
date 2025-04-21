/*You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.

 

Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]
Example 2:

Input: nums = [1,1]
Output: [1,2]
 

Constraints:

2 <= nums.length <= 104
1 <= nums[i] <= 104 */
import java.util.*;
class Solution {
    public static int[] findErrorNums(int[] nums) {
        int i=0, n=nums.length;
        while(i<n){
            int correct = nums[i]-1;
            if(nums[i]!=nums[correct]){
                int temp=nums[i];
                nums[i]=nums[correct];
                nums[correct]=temp;
            }
            else i++;
        }
        int ans[]={-1,-1};
        for(int j=0;j<n;j++){
            if(nums[j]!=j+1){
                ans[0]=nums[j];
                ans[1]=j+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter elements: ");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        int result[]=findErrorNums(arr);
        System.out.println("The number duplicated and missing number is: ");
        for(int ele:result)
        System.out.println(ele+" ");
        sc.close();
    }
}