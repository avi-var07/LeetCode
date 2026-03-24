/*Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.) */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        int ans[] = productExceptSelf(arr);

        for(int ele: ans)System.out.print(ele+ " ");
        sc.close();
    }
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // int pre[] = new int[n];
        // int suf[] = new int[n];
        
        // pre[0] =1;
        // suf[n-1]=1;
        // for(int i=1;i<n;i++)pre[i] = pre[i-1]*nums[i-1];
        // for(int i=n-2;i>=0;i--)suf[i] = suf[i+1]*nums[i+1];

        // int ans[] = new int[n];
        
        // for(int i=0;i<n;i++)ans[i] = pre[i]*suf[i];


        int ans[] =new int[n];
        ans[0]= 1;
        for(int i=1;i<n;i++)ans[i]=ans[i-1]*nums[i-1];

        int suf=1;

        for(int i=n-1;i>=0;i--){
            ans[i]= ans[i]*suf;
            suf*=nums[i];
        }
        return ans;
    }
}